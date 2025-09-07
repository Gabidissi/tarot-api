package com.anagfraiz.tarotapi.controller;

import com.anagfraiz.tarotapi.model.Carta;
import com.anagfraiz.tarotapi.model.Jogo;
import com.anagfraiz.tarotapi.repository.TarotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TarotApiController {


    private final TarotRepository repo;

    public TarotApiController(TarotRepository repo) {
        this.repo = repo;
    }

    // --- CARTAS ---
    @GetMapping("/cartas")
    public List<Carta> getCartas() {
        return repo.getCartas();
    }

    @GetMapping("/cartas/{id}")
    public ResponseEntity<?> getCartaById(@PathVariable int id) {
        return repo.getCartaById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Carta não encontrada"));
    }

    // --- JOGOS ---
    @GetMapping("/jogos")
    public List<Jogo> getJogos() {
        return repo.getJogos();
    }

    @GetMapping("/jogos/{id}")
    public ResponseEntity<?> getJogoById(@PathVariable int id) {
        return repo.getJogoById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Jogo não encontrado"));
    }

    @PostMapping("/jogos")
    public ResponseEntity<?> addJogo(@RequestBody Jogo jogo) {

        if (jogo.getNome() == null || jogo.getNome().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome do jogo é obrigatório");
        if (jogo.getCartas() == null || jogo.getCartas().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("É necessário incluir cartas");


        for (Jogo.CartaPosicao cp : jogo.getCartas()) {
            if (repo.getCartaById(cp.getId()).isEmpty())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Carta com ID " + cp.getId() + " não existe");
        }

        Jogo novo = repo.addJogo(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/jogos/{id}")
    public ResponseEntity<?> updateJogo(@PathVariable int id, @RequestBody Jogo jogo) {
        var existing = repo.getJogoById(id);
        if (existing.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado");

        Jogo jogoExistente = existing.get();
        if (jogo.getNome() != null) jogoExistente.setNome(jogo.getNome());
        if (jogo.getCartas() != null) jogoExistente.setCartas(jogo.getCartas());

        return ResponseEntity.ok(jogoExistente);
    }

    @DeleteMapping("/jogos/{id}")
    public ResponseEntity<?> deleteJogo(@PathVariable int id) {
        var existing = repo.getJogoById(id);
        if (existing.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado");

        repo.removeJogo(existing.get());
        return ResponseEntity.ok("Jogo removido com sucesso");
    }

}
