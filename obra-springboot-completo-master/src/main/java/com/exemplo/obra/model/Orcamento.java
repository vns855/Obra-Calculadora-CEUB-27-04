package com.exemplo.obra.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_orcamento", unique = true, nullable = false, length = 20)
    private String numeroOrcamento;

    @Column(name = "nome_usuario", nullable = false, length = 100)
    private String nomeUsuario;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "area_total")
    private Double areaTotal;

    @Column(name = "num_comodos")
    private Integer numComodos;

    @Column(name = "num_banheiros")
    private Integer numBanheiros;

    @Column(name = "perimetro_total")
    private Double perimetroTotal;

    @Column(name = "altura_paredes")
    private Double alturaParedes;

    @Column(name = "qtd_sacos_cimento")
    private Double qtdSacosCimento;

    @Column(name = "volume_areia_m3")
    private Double volumeAreiaM3;

    @Column(name = "volume_brita_m3")
    private Double volumeBritaM3;

    @Column(name = "qtd_tijolos")
    private Integer qtdTijolos;

    @Column(name = "qtd_tijolos_com_perda")
    private Integer qtdTijolosComPerda;

    @Column(name = "custo_total_estimado")
    private Double custoTotalEstimado;

    public Orcamento() {}

    public Long getId() { return id; }
    public String getNumeroOrcamento() { return numeroOrcamento; }
    public void setNumeroOrcamento(String numeroOrcamento) { this.numeroOrcamento = numeroOrcamento; }
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public Double getAreaTotal() { return areaTotal; }
    public void setAreaTotal(Double areaTotal) { this.areaTotal = areaTotal; }
    public Integer getNumComodos() { return numComodos; }
    public void setNumComodos(Integer numComodos) { this.numComodos = numComodos; }
    public Integer getNumBanheiros() { return numBanheiros; }
    public void setNumBanheiros(Integer numBanheiros) { this.numBanheiros = numBanheiros; }
    public Double getPerimetroTotal() { return perimetroTotal; }
    public void setPerimetroTotal(Double perimetroTotal) { this.perimetroTotal = perimetroTotal; }
    public Double getAlturaParedes() { return alturaParedes; }
    public void setAlturaParedes(Double alturaParedes) { this.alturaParedes = alturaParedes; }
    public Double getQtdSacosCimento() { return qtdSacosCimento; }
    public void setQtdSacosCimento(Double qtdSacosCimento) { this.qtdSacosCimento = qtdSacosCimento; }
    public Double getVolumeAreiaM3() { return volumeAreiaM3; }
    public void setVolumeAreiaM3(Double volumeAreiaM3) { this.volumeAreiaM3 = volumeAreiaM3; }
    public Double getVolumeBritaM3() { return volumeBritaM3; }
    public void setVolumeBritaM3(Double volumeBritaM3) { this.volumeBritaM3 = volumeBritaM3; }
    public Integer getQtdTijolos() { return qtdTijolos; }
    public void setQtdTijolos(Integer qtdTijolos) { this.qtdTijolos = qtdTijolos; }
    public Integer getQtdTijolosComPerda() { return qtdTijolosComPerda; }
    public void setQtdTijolosComPerda(Integer qtdTijolosComPerda) { this.qtdTijolosComPerda = qtdTijolosComPerda; }
    public Double getCustoTotalEstimado() { return custoTotalEstimado; }
    public void setCustoTotalEstimado(Double custoTotalEstimado) { this.custoTotalEstimado = custoTotalEstimado; }
}