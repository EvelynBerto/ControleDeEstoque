/*
package com.example.controleestoque.layer

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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.controleestoque.R
import com.example.controleestoque.domain.Produto
import com.example.controleestoque.ui.theme.ControleEstoqueTheme
import com.example.controleestoque.layer.viewmodel.ProdutoViewModel


// TODO - LINK UTIL = https://dev.to/alexfelipe/boas-praticas-com-modifiers-no-jetpack-compose-3men
class TelaAdicionarProduto : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControleEstoqueTheme {
                ViewModelInstance()
            }
        }
    }
}
//TODO
*/
/* @Composable
    fun MyLazyColumn(modifier: Modifier = Modifier) {
        val viewModel: ProdutoViewModel = viewModel()
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
    }*//*


@Composable
fun ViewModelInstance() {
    val viewModel: ProdutoViewModel = viewModel()

    Scaffold { paddingValues ->
        AdicionarProdutoScreen(
            modifier = Modifier.padding(paddingValues),
            viewModel = viewModel
        )
    }
}

@Composable
fun AdicionarProdutoScreen(modifier: Modifier = Modifier, viewModel: ProdutoViewModel) {
    var nome by remember { mutableStateOf("") }
    var valor by remember { mutableStateOf("") }

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier.padding(16.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            TextField(
                value = nome,
                onValueChange = { novoNome -> nome = novoNome },
                label = { Text(text = stringResource(R.string.NOME_PROD)) },
                modifier = Modifier.padding(bottom = 16.dp)
            )
            TextField(
                value = valor,
                onValueChange = { novoValor -> valor = novoValor },
                label = { Text(text = stringResource(R.string.PRECO_PROD)) },
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(onClick = {
                val precoDouble = valor.toDoubleOrNull()
                if (nome.isNotBlank() && precoDouble != null) {
                    val novoProduto = Produto((viewModel.produtos.size + 1), nome, precoDouble)
                    viewModel.adicionarProduto(novoProduto)
                    nome = ""
                    valor = ""
                }
            }
            ) {
                Text(text = stringResource(R.string.ADICIONAR_PRODUTOS))
            }
        }
    }
}
*/
