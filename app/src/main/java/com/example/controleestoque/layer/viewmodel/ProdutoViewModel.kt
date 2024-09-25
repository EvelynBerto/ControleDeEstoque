package com.example.controleestoque.layer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controleestoque.data.ProdutoRespository
import com.example.controleestoque.domain.Produto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProdutoViewModel @Inject constructor(
    private val produtoRespository: ProdutoRespository
): ViewModel() {
    private val _produtos = MutableLiveData<List<Produto>>()
    val produtos: LiveData<List<Produto>> get() = _produtos

    init {
        // Carrega produtos do banco de dados ao iniciar
        viewModelScope.launch {
            loadProdutos()
        }
    }

    private suspend fun loadProdutos() {
        _produtos.value = emptyList() // Limpa a lista antes de carregar novos produtos
        _produtos.value = produtoRespository.getProdutos() // Carrega produtos do repositório
    }

    fun adicionarProduto(produto: Produto) {
        viewModelScope.launch {
            produtoRespository.addProduto(produto)
            _produtos.value = _produtos.value?.plus(produto)
        }
    }

    fun removeProduto(id: Int) {
        viewModelScope.launch {
            produtoRespository.removeProduto(id)
            _produtos.value = _produtos.value?.filterNot { it.id == id }
        }
    }
}