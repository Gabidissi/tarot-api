package com.anagfraiz.tarotapi.repository;

import com.anagfraiz.tarotapi.model.Carta;
import com.anagfraiz.tarotapi.model.Jogo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TarotRepository {
    private List<Carta> cartas = new ArrayList<>();
    private List<Jogo> jogos = new ArrayList<>();
    private int nextCartaId = 1;
    private int nextJogoId = 1;

    public TarotRepository() {
        // Arcanos Maiores
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Louco");
            setArcano("Maior");
            setSignificado("Novos começos, liberdade, espontaneidade");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Mago");
            setArcano("Maior");
            setSignificado("Criatividade, iniciativa, poder pessoal");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Sacerdotisa");
            setArcano("Maior");
            setSignificado("Intuição, mistério, sabedoria interior");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Imperatriz");
            setArcano("Maior");
            setSignificado("Fertilidade, abundância, nutrição");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Imperador");
            setArcano("Maior");
            setSignificado("Autoridade, estabilidade, estrutura");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Hierofante");
            setArcano("Maior");
            setSignificado("Tradição, espiritualidade, aprendizado");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("Os Amantes");
            setArcano("Maior");
            setSignificado("Relacionamentos, escolhas, harmonia");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Carro");
            setArcano("Maior");
            setSignificado("Determinação, conquista, controle");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Força");
            setArcano("Maior");
            setSignificado("Coragem, paciência, domínio sobre si mesmo");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Eremita");
            setArcano("Maior");
            setSignificado("Reflexão, introspecção, busca interior");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Roda da Fortuna");
            setArcano("Maior");
            setSignificado("Mudança, ciclos, destino");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Justiça");
            setArcano("Maior");
            setSignificado("Equilíbrio, justiça, responsabilidade");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Enforcado");
            setArcano("Maior");
            setSignificado("Sacrifício, pausa, mudança de perspectiva");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Morte");
            setArcano("Maior");
            setSignificado("Fim de ciclo, transformação, renovação");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Temperança");
            setArcano("Maior");
            setSignificado("Equilíbrio, moderação, paciência");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Diabo");
            setArcano("Maior");
            setSignificado("Apego, materialismo, tentações");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Torre");
            setArcano("Maior");
            setSignificado("Ruptura, crise, revelação");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Estrela");
            setArcano("Maior");
            setSignificado("Esperança, inspiração, cura");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("A Lua");
            setArcano("Maior");
            setSignificado("Intuição, ilusões, emoções profundas");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Sol");
            setArcano("Maior");
            setSignificado("Sucesso, alegria, vitalidade");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Julgamento");
            setArcano("Maior");
            setSignificado("Renascimento, avaliação, decisões importantes");
        }});
        cartas.add(new Carta(){{
            setId(nextCartaId++);
            setNome("O Mundo");
            setArcano("Maior");
            setSignificado("Conclusão, realização, plenitude");
        }});
        //Arcanos Menores
        String[][] naipes = {
                {"Copas", "Emoções, sentimentos, relações"},
                {"Ouros", "Dinheiro, trabalho, sucesso material"},
                {"Espadas", "Conflitos, desafios, pensamentos"},
                {"Paus", "Ação, criatividade, energia"}
        };

        String[] valores = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Pajem", "Cavaleiro", "Rainha", "Rei"};

        for (String[] naipe : naipes) {
            String nomeNaipe = naipe[0];
            String significadoBase = naipe[1];

            for (String valor : valores) {
                cartas.add(new Carta(){{
                    setId(nextCartaId++);
                    setNome(valor + " de " + nomeNaipe);
                    setArcano("Menor");
                    setSignificado(significadoBase + " (" + valor + ")");
                }});
            }
        }
    }

    public List<Carta> getCartas() { return cartas; }
    public Optional<Carta> getCartaById(int id) {
        return cartas.stream().filter(c -> c.getId() == id).findFirst();
    }

    public List<Jogo> getJogos() { return jogos; }
    public Optional<Jogo> getJogoById(int id) {
        return jogos.stream().filter(j -> j.getId() == id).findFirst();
    }

    public Jogo addJogo(Jogo jogo) {
        jogo.setId(nextJogoId++);
        jogos.add(jogo);
        return jogo;
    }

    public void removeJogo(Jogo jogo) { jogos.remove(jogo); }
}

