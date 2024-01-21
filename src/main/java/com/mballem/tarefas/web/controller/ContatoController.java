package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tarefas/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    // EXERCICIO 1
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato contact = contatoService.save(contato);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 2
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato contact = contatoService.getById(id);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 3
    @GetMapping
    public ResponseEntity<Contato> getContatoByNome(@RequestParam("nome") String name) {
        Contato contact = contatoService.getContatoByNome(name);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 4
    @GetMapping("/total")
    public int getQuantidadeDeContatos() {
        return contatoService.getAll();
    }

    // EXERCICIO 5
    @GetMapping("/nascimento/{dataNascimento}")
    public ResponseEntity<List<Contato>> getContatosByDataNascimento(@PathVariable LocalDate dataNascimento) {
        List<Contato> contact = contatoService.getByDataNascimento(dataNascimento);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 6
    @PatchMapping("/{id}")
    public ResponseEntity<Contato> updateContatoById(@PathVariable Long id, @RequestBody Contato contato) {
        Contato contact = contatoService.update(id, contato);
        return ResponseEntity.ok(contact);
    }

    // EXERCICIO 7
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String contact = contatoService.delete(id);
        return ResponseEntity.ok(contact);
    }
}
