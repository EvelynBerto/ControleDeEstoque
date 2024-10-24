package com.example.controleestoque.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.controleestoque.R
import com.example.controleestoque.domain.model.Produto
import com.example.controleestoque.ui.theme.ControleEstoqueTheme
import com.example.controleestoque.ui.vm.ProdutoViewModel
import org.koin.androidx.compose.koinViewModel


// TODO - LINK UTIL = https://dev.to/alexfelipe/boas-praticas-com-modifiers-no-jetpack-compose-3men
class TelaAdicionarProduto(private val navController: NavController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControleEstoqueTheme {
                AdicionarProdutoScreen()
            }
        }
    }
//TODO
    /* @Composable
        fun MyLazyColumn(modifier: Modifier = Modifier) {
            val viewModel = koinViewModel<ProdutoViewModel>()
            LazyColumn(
                modifier = modifier
                    //match_parent
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(vertical = 16.dp)
            ) {
                item {
                    AdicionarProdutoScreen(viewModel)
                }
            }
        }*/

    @Composable
    fun AdicionarProdutoScreen() {
        val viewModel = koinViewModel<ProdutoViewModel>()

        val addProdutoSucess by viewModel.adicaoProdutoSucesso.collectAsState()

        var nome by remember { mutableStateOf("") }
        var valor by remember { mutableStateOf("") }
        var descricao by remember { mutableStateOf("") }
        var nf by remember { mutableStateOf("") }

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text(text = stringResource(R.string.NOME_PROD)) }
            )
            TextField(
                value = valor,
                onValueChange = { valor = it },
                label = { Text(text = stringResource(R.string.VALOR_PROD)) }
            )
            TextField(
                value = descricao,
                onValueChange = { descricao = it },
                label = { Text(text = stringResource(R.string.DESC_PROD)) }
            )
            TextField(
                value = nf,
                onValueChange = { nf = it },
                label = { Text(text = stringResource(R.string.NF_PROD)) }
            )
            Button(onClick = {
                viewModel.adicionarProduto(nome, valor, descricao, nf)
                nome = ""
                valor = ""
                descricao = ""
                nf = ""
            }) {
                Text(text = stringResource(R.string.ADD))
            }
            if (addProdutoSucess){
                LaunchedEffect(Unit) {
                    navController.navigate("lista_produtos") {
                        popUpTo("adicionar_produto") { inclusive = true }
                    }
                }
            }
        }
    }
}