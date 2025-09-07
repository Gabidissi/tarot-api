package com.anagfraiz.tarotapi.model;

public class Carta {
    private Integer id;
    private String nome;
    private String arcano;
    private String significado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArcano() {
        return arcano;
    }

    public void setArcano(String arcano) {
        this.arcano = arcano;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }
}
