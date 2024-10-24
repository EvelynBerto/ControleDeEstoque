package com.example.controleestoque.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.controleestoque.domain.model.Produto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProdutoDAO {

    @Insert
    fun insert(produto: Produto)

    @Query("SELECT * FROM Produtos")
    fun getAll(): Flow<List<Produto>>

    @Query("DELETE FROM produtos WHERE id = :id")
    fun remove(id: Int)

    @Update
    fun update(produto: Produto)
}

