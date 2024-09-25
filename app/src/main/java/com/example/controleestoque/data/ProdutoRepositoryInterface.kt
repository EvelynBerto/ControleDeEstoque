package com.example.controleestoque.data

import com.example.controleestoque.domain.Produto

interface ProdutoRepositoryInterface {
    //SUSPEND - FUNCAO ASSINCRONA
    suspend fun getProdutos(): List<Produto>
    suspend fun addProduto(produto: Produto)
    suspend fun removeProduto(id: Int)
}