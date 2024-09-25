package com.example.controleestoque.layer

import com.example.controleestoque.domain.Produto

interface ProdutoActionListeners {
    fun onAddProduto(produto: Produto)
    fun onRemoveProduto(produto: Produto)
    fun onDetailsProduto(produto: Produto)
}