package com.example.controleestoque.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controleestoque.domain.model.Produto
import com.example.controleestoque.domain.usecase.ProdutoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ProdutoViewModel (
    private val produtoUseCase: ProdutoUseCase
): ViewModel() {

    // Estado interno do fluxo
    private val _produtos = MutableStateFlow<List<Produto>>(emptyList())

    // Estado público exposto como StateFlow
    val produtos: StateFlow<List<Produto>> get() = _produtos


    init {
        // Carrega produtos do banco de dados ao iniciar, com Coroutines
        viewModelScope.launch {
            loadProdutos()
        }
    }

    private suspend fun loadProdutos() {
        produtoUseCase.getAllProducts().collect { produtosDaBase ->
            _produtos.value = produtosDaBase
        }
    }

    private val _adicaoProdutoSucesso = MutableStateFlow(false)
    val adicaoProdutoSucesso: StateFlow<Boolean> = _adicaoProdutoSucesso

    fun adicionarProduto(nome: String, valor: String, descricao: String, nf: String) {
        viewModelScope.launch {
            val resultado = produtoUseCase.add(nome, valor, descricao, nf)
            if (resultado)
                loadProdutos()
            _adicaoProdutoSucesso.value = resultado
        }

        fun removeProduto(id: Int) {
            viewModelScope.launch {
                produtoUseCase.delete(id)
                loadProdutos() // Atualiza a lista
            }
        }
    }
}

