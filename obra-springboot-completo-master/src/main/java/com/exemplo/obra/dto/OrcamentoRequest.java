package com.exemplo.obra.dto;

import jakarta.validation.constraints.*;

public class OrcamentoRequest {

    @NotBlank(message = "O nome do usuário é obrigatório.")
    private String nomeUsuario;

    @NotNull @DecimalMin("1.0")
    private Double areaTotal;

    @NotNull @Min(1)
    private Integer numComodos;

    @NotNull @Min(1)
    private Integer numBanheiros;

    @NotNull @DecimalMin("1.0")
    private Double perimetroTotal;

    @NotNull @DecimalMin("0.5")
    private Double alturaParedes;

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
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
}