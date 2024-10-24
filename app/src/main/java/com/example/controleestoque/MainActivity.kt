package com.example.controleestoque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.controleestoque.ui.TelaAdicionarProduto
import com.example.controleestoque.ui.TelaListaProdutos

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // NavHost para definir as rotas entre telas
            NavHost(navController = navController, startDestination = "lista_produtos") {
                composable("lista_produtos") {
                    TelaListaProdutos(navController) // Tela principal com o FAB
                }
                composable("adicionar_produto") {
                    TelaAdicionarProduto(navController) // Tela de adicionar produto
                }
            }
        }
    }
}
