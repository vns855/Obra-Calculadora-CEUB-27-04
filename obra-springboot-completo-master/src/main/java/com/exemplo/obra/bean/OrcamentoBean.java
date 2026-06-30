package com.exemplo.obra.bean;

import com.exemplo.obra.dto.OrcamentoRequest;
import com.exemplo.obra.dto.OrcamentoResponse;
import com.exemplo.obra.service.OrcamentoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class OrcamentoBean implements Serializable {

    @Inject
    private OrcamentoService orcamentoService;

    // Dados do formulário (entrada do usuário)
    private OrcamentoRequest request;

    // Resultado calculado, exibido após o cálculo
    private OrcamentoResponse resultado;

    // Campos usados na tela de busca
    private String numeroBusca;
    private String nomeBusca;
    private List<OrcamentoResponse> listaResultados;

    @PostConstruct
    public void init() {
        request = new OrcamentoRequest();
    }


    public void calcular() {
        try {
            resultado = orcamentoService.calcularESalvar(request);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Orçamento " + resultado.getNumeroOrcamento() + " calculado com sucesso!", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao calcular orçamento: " + e.getMessage(), null));
        }
    }

    public void buscarPorNumero() {
        try {
            OrcamentoResponse encontrado = orcamentoService.buscarPorNumero(numeroBusca);
            listaResultados = List.of(encontrado);
        } catch (Exception e) {
            listaResultados = List.of();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Nenhum orçamento encontrado com o número informado.", null));
        }
    }


    public void buscarPorNome() {
        listaResultados = orcamentoService.buscarPorNome(nomeBusca);
        if (listaResultados.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Nenhum orçamento encontrado para o nome informado.", null));
        }
    }


    public void novoOrcamento() {
        request = new OrcamentoRequest();
        resultado = null;
    }

    // ---------- Getters e Setters ----------

    public OrcamentoRequest getRequest() { return request; }
    public void setRequest(OrcamentoRequest request) { this.request = request; }

    public OrcamentoResponse getResultado() { return resultado; }

    public String getNumeroBusca() { return numeroBusca; }
    public void setNumeroBusca(String numeroBusca) { this.numeroBusca = numeroBusca; }

    public String getNomeBusca() { return nomeBusca; }
    public void setNomeBusca(String nomeBusca) { this.nomeBusca = nomeBusca; }

    public List<OrcamentoResponse> getListaResultados() { return listaResultados; }
}