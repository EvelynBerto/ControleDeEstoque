package com.example.controleestoque.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Produtos")
data class Produto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val valor: String,
    val descricao: String? = null,
    val notaFiscal: String
)
