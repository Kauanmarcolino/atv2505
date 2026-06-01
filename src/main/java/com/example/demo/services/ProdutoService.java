package com.example.demo.services;

import com.example.demo.models.ProdutoModel;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pelas regras de negócio relacionadas aos produtos.
 *
 * Atua como intermediário entre os controllers e o repositório,
 * centralizando operações de consulta e persistência de dados.
 */
@Service
public class ProdutoService {

    /**
     * Repositório responsável pelo acesso aos dados dos produtos.
     */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Retorna todos os produtos cadastrados.
     *
     * @return Lista contendo todos os produtos encontrados.
     */
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    /**
     * Cria e persiste um novo produto no banco de dados.
     *
     * @param produtoModel Dados do produto a ser salvo.
     * @return Produto salvo com os dados persistidos.
     */
    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    /**
     * Busca um produto pelo seu identificador.
     *
     * @param id Identificador único do produto.
     * @return Optional contendo o produto encontrado ou vazio caso não exista.
     */
    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
}