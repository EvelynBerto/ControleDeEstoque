package com.example.controleestoque.domain.usecase

import androidx.lifecycle.LiveData
import com.example.controleestoque.domain.model.Produto
import kotlinx.coroutines.flow.Flow

interface ProdutoUseCaseInterface{
    suspend fun add(nome: String, valor: String, descricao: String, nf: String): Boolean
    suspend fun delete(id: Int)
    suspend fun validation(produto: Produto): Boolean
    suspend fun getAllProducts(): Flow<List<Produto>>
    suspend fun update(id: Int, nome: String, valor: String, descricao: String, nf: String)
}