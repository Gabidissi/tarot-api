package com.anagfraiz.tarotapi.model;

import java.util.List;

public class Jogo {
    private Integer id;
    private String nome;
    private List<CartaPosicao> cartas;

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

    public List<CartaPosicao> getCartas() {
        return cartas;
    }

    public void setCartas(List<CartaPosicao> cartas) {
        this.cartas = cartas;
    }

    public static class CartaPosicao {
        private Integer id;
        private String posicao;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }
    }
}
