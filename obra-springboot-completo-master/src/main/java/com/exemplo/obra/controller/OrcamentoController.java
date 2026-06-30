package com.exemplo.obra.controller;

import com.exemplo.obra.dto.OrcamentoRequest;
import com.exemplo.obra.dto.OrcamentoResponse;
import com.exemplo.obra.service.OrcamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping
    public ResponseEntity<OrcamentoResponse> criar(@Valid @RequestBody OrcamentoRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoService.calcularESalvar(req));
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoResponse>> listar() {
        return ResponseEntity.ok(orcamentoService.listarTodos());
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<OrcamentoResponse> porNumero(@PathVariable String numero) {
        return ResponseEntity.ok(orcamentoService.buscarPorNumero(numero));
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<OrcamentoResponse>> porNome(@RequestParam String nome) {
        return ResponseEntity.ok(orcamentoService.buscarPorNome(nome));
    }
}