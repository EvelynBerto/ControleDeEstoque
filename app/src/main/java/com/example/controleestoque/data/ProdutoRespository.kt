package com.example.controleestoque.data

import com.example.controleestoque.data.dao.ProdutoDAO
import com.example.controleestoque.domain.Produto
import javax.inject.Inject

class ProdutoRespository @Inject constructor(
    private val produtoDAO: ProdutoDAO
): ProdutoRepositoryInterface{

    override suspend fun getProdutos(): List<Produto> {
        return produtoDAO.getAll()
    }

    override suspend fun addProduto(produto: Produto) {
        produtoDAO.insert(produto)
    }

    override suspend fun removeProduto(id: Int) {
        produtoDAO.remove(id)
    }
}