package com.example.demo.controllers;

import com.example.demo.models.ProdutoModel;
import com.example.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller responsável por expor os endpoints da API de Produtos.
 * Todas as requisições relacionadas a produtos são mapeadas
 * para a rota base "/produtos".
 */
@RequestMapping(path = "/produtos")
@RestController
public class ProdutoController {

    /**
     * Serviço responsável pelas regras de negócio dos produtos.
     */
    @Autowired
    private ProdutoService produtoService;

/**
 * Lista todos os produtos cadastrados.
 * Endpoint: GET /produtos
 * @return ResponseEntity contendo a lista de produtos e status HTTP 200 (OK).
 */
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAllProduto() {
        return ResponseEntity.ok(produtoService.findAll());
    }

/**
 * Busca um produto pelo seu identificador.
 * Endpoint: GET /produtos/{id}
 * @param id Identificador único do produto.
 * @return HTTP 200 (OK) com o produto encontrado
 * ou HTTP 404 (Not Found) caso não exista.
 */
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarProduto(@PathVariable Long id) {
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

/**
 * Cria um novo produto.
 * Endpoint: POST /produtos
 * @param produtoModel Dados do produto enviados no corpo da requisição.
 * @return HTTP 201 (Created) contendo o produto criado.
 */
    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel novo = produtoService.criarProduto(produtoModel);
        return ResponseEntity.status(201).body(novo);
    }
}