package com.example.controleestoque.domain

import android.content.Context

interface UseCasesProduto{
    suspend fun add(context: Context, nome: String, valor: String, descricao: String, nf: String)
    suspend fun delete(id: Int)
    suspend fun validation(context: Context, produto: Produto): Boolean
}