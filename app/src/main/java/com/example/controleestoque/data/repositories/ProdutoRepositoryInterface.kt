package com.example.controleestoque.data.repositories

import com.example.controleestoque.domain.model.Produto
import kotlinx.coroutines.flow.Flow

interface ProdutoRepositoryInterface {

    suspend fun getProdutos(): Flow<List<Produto>>
    suspend fun addProduto(produto: Produto)
    suspend fun removeProduto(id: Int)
    suspend fun updateProduto(produto: Produto)
}