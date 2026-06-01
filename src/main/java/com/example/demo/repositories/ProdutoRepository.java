package com.example.demo.repositories;

import com.example.demo.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório responsável pelo acesso aos dados da entidade Produto.
 *
 * Ao estender JpaRepository, esta interface herda automaticamente
 * operações CRUD e funcionalidades de paginação e ordenação.
 *
 * Exemplos de métodos disponíveis:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 * - existsById()
 */
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}