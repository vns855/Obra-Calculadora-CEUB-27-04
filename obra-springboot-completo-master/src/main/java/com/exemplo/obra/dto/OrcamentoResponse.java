package com.exemplo.obra.dto;

import java.time.LocalDate;

public class OrcamentoResponse {
    private Long id;
    private String numeroOrcamento;
    private String nomeUsuario;
    private LocalDate dataCriacao;
    private Double areaTotal;
    private Integer numComodos;
    private Integer numBanheiros;
    private Double perimetroTotal;
    private Double alturaParedes;
    private Double qtdSacosCimento;
    private Double volumeAreiaM3;
    private Double volumeBritaM3;
    private Integer qtdTijolos;
    private Integer qtdTijolosComPerda;
    private Double custoTotalEstimado;
    private String mensagem;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroOrcamento() { return numeroOrcamento; }
    public void setNumeroOrcamento(String v) { this.numeroOrcamento = v; }
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String v) { this.nomeUsuario = v; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate v) { this.dataCriacao = v; }
    public Double getAreaTotal() { return areaTotal; }
    public void setAreaTotal(Double v) { this.areaTotal = v; }
    public Integer getNumComodos() { return numComodos; }
    public void setNumComodos(Integer v) { this.numComodos = v; }
    public Integer getNumBanheiros() { return numBanheiros; }
    public void setNumBanheiros(Integer v) { this.numBanheiros = v; }
    public Double getPerimetroTotal() { return perimetroTotal; }
    public void setPerimetroTotal(Double v) { this.perimetroTotal = v; }
    public Double getAlturaParedes() { return alturaParedes; }
    public void setAlturaParedes(Double v) { this.alturaParedes = v; }
    public Double getQtdSacosCimento() { return qtdSacosCimento; }
    public void setQtdSacosCimento(Double v) { this.qtdSacosCimento = v; }
    public Double getVolumeAreiaM3() { return volumeAreiaM3; }
    public void setVolumeAreiaM3(Double v) { this.volumeAreiaM3 = v; }
    public Double getVolumeBritaM3() { return volumeBritaM3; }
    public void setVolumeBritaM3(Double v) { this.volumeBritaM3 = v; }
    public Integer getQtdTijolos() { return qtdTijolos; }
    public void setQtdTijolos(Integer v) { this.qtdTijolos = v; }
    public Integer getQtdTijolosComPerda() { return qtdTijolosComPerda; }
    public void setQtdTijolosComPerda(Integer v) { this.qtdTijolosComPerda = v; }
    public Double getCustoTotalEstimado() { return custoTotalEstimado; }
    public void setCustoTotalEstimado(Double v) { this.custoTotalEstimado = v; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String v) { this.mensagem = v; }
}