package com.baozistore.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baozistore.api.model.Pedido;
import com.baozistore.api.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}