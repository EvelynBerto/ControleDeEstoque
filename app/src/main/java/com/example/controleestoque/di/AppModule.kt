package com.example.controleestoque.di

import androidx.room.Room
import com.example.controleestoque.data.ProdutoDB
import com.example.controleestoque.data.repositories.ProdutoRepository
import com.example.controleestoque.domain.usecase.ProdutoUseCase
import com.example.controleestoque.ui.vm.ProdutoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module {
    singleOf(::ProdutoRepository)
    viewModelOf(::ProdutoViewModel)
}

val useCaseModule = module {
    single {
        ProdutoUseCase(get(), androidContext()) }
    }

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            ProdutoDB::class.java,
            "estoque.db"
        ).build()
    }
    single { get<ProdutoDB>().produtoDao()}
}