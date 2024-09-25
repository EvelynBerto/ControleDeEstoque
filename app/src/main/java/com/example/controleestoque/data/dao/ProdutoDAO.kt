package com.example.controleestoque.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.controleestoque.domain.Produto

@Dao
interface ProdutoDAO {

    @Insert
    fun insert(produto: Produto)

    @Query("SELECT * FROM Produtos")
    fun getAll(): List<Produto>

    @Delete
    fun remove(id: Int)
}

