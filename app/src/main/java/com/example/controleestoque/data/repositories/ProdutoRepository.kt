package com.example.controleestoque.data.repositories

import com.example.controleestoque.data.dao.ProdutoDAO
import com.example.controleestoque.domain.model.Produto
import kotlinx.coroutines.flow.Flow

class ProdutoRepository (
    private val produtoDAO: ProdutoDAO
): ProdutoRepositoryInterface {

    override suspend fun addProduto(produto: Produto) {
        produtoDAO.insert(produto)
    }

    override suspend fun getProdutos(): Flow<List<Produto>> {
        return produtoDAO.getAll()
    }

    override suspend fun removeProduto(id: Int) {
        produtoDAO.remove(id)
    }

    override suspend fun updateProduto(produto: Produto) {
        produtoDAO.update(produto)
    }
}