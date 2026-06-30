package com.exemplo.obra.service;

import com.exemplo.obra.dto.OrcamentoRequest;
import com.exemplo.obra.dto.OrcamentoResponse;
import com.exemplo.obra.model.Orcamento;
import com.exemplo.obra.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    private static final double PRECO_SACO_CIMENTO = 35.0;
    private static final double PRECO_M3_AREIA     = 120.0;
    private static final double PRECO_M3_BRITA     = 150.0;
    private static final double PRECO_TIJOLO       = 1.20;
    private static final double AREA_TIJOLO_M2     = 0.19 * 0.09;
    private static final double PERCENTUAL_PERDA   = 0.10;

    private final OrcamentoRepository repository;

    public OrcamentoService(OrcamentoRepository repository) {
        this.repository = repository;
    }

    public OrcamentoResponse calcularESalvar(OrcamentoRequest req) {
        Orcamento o = new Orcamento();
        o.setNumeroOrcamento("ORC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        o.setNomeUsuario(req.getNomeUsuario());
        o.setDataCriacao(LocalDate.now());
        o.setAreaTotal(req.getAreaTotal());
        o.setNumComodos(req.getNumComodos());
        o.setNumBanheiros(req.getNumBanheiros());
        o.setPerimetroTotal(req.getPerimetroTotal());
        o.setAlturaParedes(req.getAlturaParedes());

        double area = req.getAreaTotal();
        double sacos = arr(area * 0.30);
        double areia = arr(area * 0.04);
        double brita = arr(area * 0.03);
        int tijolos  = (int) Math.ceil((req.getPerimetroTotal() * req.getAlturaParedes()) / AREA_TIJOLO_M2);
        int comPerda = (int) Math.ceil(tijolos * 1.10);
        double custo = arr((sacos * PRECO_SACO_CIMENTO) + (areia * PRECO_M3_AREIA)
                + (brita * PRECO_M3_BRITA) + (comPerda * PRECO_TIJOLO));

        o.setQtdSacosCimento(sacos);
        o.setVolumeAreiaM3(areia);
        o.setVolumeBritaM3(brita);
        o.setQtdTijolos(tijolos);
        o.setQtdTijolosComPerda(comPerda);
        o.setCustoTotalEstimado(custo);

        return toResponse(repository.save(o), "Orçamento salvo com sucesso.");
    }

    public OrcamentoResponse buscarPorNumero(String numero) {
        Orcamento o = repository.findByNumeroOrcamento(numero)
                .orElseThrow(() -> new RuntimeException("Orçamento não encontrado: " + numero));
        return toResponse(o, "OK");
    }

    public List<OrcamentoResponse> buscarPorNome(String nome) {
        return repository.findByNomeUsuarioContainingIgnoreCase(nome)
                .stream().map(o -> toResponse(o, "OK")).collect(Collectors.toList());
    }

    public List<OrcamentoResponse> listarTodos() {
        return repository.findAll()
                .stream().map(o -> toResponse(o, "OK")).collect(Collectors.toList());
    }

    private double arr(double v) { return Math.round(v * 100.0) / 100.0; }

    private OrcamentoResponse toResponse(Orcamento o, String msg) {
        OrcamentoResponse r = new OrcamentoResponse();
        r.setId(o.getId());
        r.setNumeroOrcamento(o.getNumeroOrcamento());
        r.setNomeUsuario(o.getNomeUsuario());
        r.setDataCriacao(o.getDataCriacao());
        r.setAreaTotal(o.getAreaTotal());
        r.setNumComodos(o.getNumComodos());
        r.setNumBanheiros(o.getNumBanheiros());
        r.setPerimetroTotal(o.getPerimetroTotal());
        r.setAlturaParedes(o.getAlturaParedes());
        r.setQtdSacosCimento(o.getQtdSacosCimento());
        r.setVolumeAreiaM3(o.getVolumeAreiaM3());
        r.setVolumeBritaM3(o.getVolumeBritaM3());
        r.setQtdTijolos(o.getQtdTijolos());
        r.setQtdTijolosComPerda(o.getQtdTijolosComPerda());
        r.setCustoTotalEstimado(o.getCustoTotalEstimado());
        r.setMensagem(msg);
        return r;
    }
}