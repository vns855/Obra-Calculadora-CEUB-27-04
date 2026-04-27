package com.exemplo.obra.service;

import com.exemplo.obra.dto.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MaterialService {

    private static final int SCALE = 4;

    public ConcretoResponse calcularVolumeConcreto(ConcretoRequest request) {
        BigDecimal alturaViga = BigDecimal.valueOf(request.getAlturaViga());
        BigDecimal volumeTotal = BigDecimal.ZERO;
        for (ArestaRequest aresta : request.getArestas()) {
            BigDecimal largura = BigDecimal.valueOf(aresta.getEspessura());
            BigDecimal comprimento = BigDecimal.valueOf(aresta.getComprimento());
            volumeTotal = volumeTotal.add(largura.multiply(alturaViga).multiply(comprimento));
        }
        return new ConcretoResponse(
                volumeTotal.setScale(SCALE, RoundingMode.HALF_UP),
                request.getArestas().size(),
                "Volume de concreto calculado com sucesso."
        );
    }

    public TijoloResponse calcularQuantidadeTijolos(TijoloRequest request) {
        BigDecimal areaTijolo = BigDecimal.valueOf(request.getAlturaTijolo())
                .multiply(BigDecimal.valueOf(request.getLarguraTijolo()));
        BigDecimal areaTotalParedes = BigDecimal.ZERO;
        BigDecimal areaAberturas = BigDecimal.ZERO;
        for (ArestaRequest aresta : request.getArestas()) {
            areaTotalParedes = areaTotalParedes.add(
                    BigDecimal.valueOf(aresta.getComprimento())
                            .multiply(BigDecimal.valueOf(aresta.getAlturaParede())));
            if (aresta.isPossuiPorta() && aresta.getAlturaPorta() > 0 && aresta.getLarguraPorta() > 0)
                areaAberturas = areaAberturas.add(
                        BigDecimal.valueOf(aresta.getLarguraPorta())
                                .multiply(BigDecimal.valueOf(aresta.getAlturaPorta())));
            if (aresta.isPossuiJanela() && aresta.getAlturaJanela() > 0 && aresta.getLarguraJanela() > 0)
                areaAberturas = areaAberturas.add(
                        BigDecimal.valueOf(aresta.getLarguraJanela())
                                .multiply(BigDecimal.valueOf(aresta.getAlturaJanela())));
        }
        BigDecimal areaLiquida = areaTotalParedes.subtract(areaAberturas).max(BigDecimal.ZERO);
        int qtd = areaLiquida.divide(areaTijolo, SCALE, RoundingMode.HALF_UP)
                .setScale(0, RoundingMode.CEILING).intValue();
        int qtdComPerda = (int) Math.ceil(qtd * (1 + request.getPercentualPerda() / 100.0));
        return new TijoloResponse(
                areaTotalParedes.setScale(SCALE, RoundingMode.HALF_UP),
                areaLiquida.setScale(SCALE, RoundingMode.HALF_UP),
                areaAberturas.setScale(SCALE, RoundingMode.HALF_UP),
                qtd, qtdComPerda,
                "Quantidade de tijolos calculada com sucesso."
        );
    }
}