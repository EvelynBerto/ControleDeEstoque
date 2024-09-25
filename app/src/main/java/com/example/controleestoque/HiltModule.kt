package com.example.controleestoque

import android.content.Context
import com.example.controleestoque.data.ProdutoDB
import com.example.controleestoque.data.ProdutoRespository
import com.example.controleestoque.data.dao.ProdutoDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ProdutoDB {
        return ProdutoDB.getDatabase(context) // Instância do banco de dados
    }

    // Fornece o DAO de Produto
    @Provides
    fun provideProdutoDao(database: ProdutoDB): ProdutoDAO {
        return database.produtoDao() // Extrai o DAO do banco de dados
    }

    // Fornece o ProdutoRespository, injetando o DAO
    @Provides
    @Singleton
    fun provideProdutoRepository(produtoDao: ProdutoDAO): ProdutoRespository {
        return ProdutoRespository(produtoDao) // Passa o DAO ao repositório
    }
}

