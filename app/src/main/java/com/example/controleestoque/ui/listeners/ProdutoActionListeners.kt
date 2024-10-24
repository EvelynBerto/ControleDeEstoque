package com.example.controleestoque.ui.listeners

import com.example.controleestoque.domain.model.Produto

interface ProdutoActionListeners {
    fun onAddProduto(produto: Produto)
    fun onRemoveProduto(produto: Produto)
    fun onDetailsProduto(produto: Produto)
}