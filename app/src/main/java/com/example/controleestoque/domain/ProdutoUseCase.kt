package com.example.controleestoque.domain

import android.content.Context
import android.widget.Toast
import com.example.controleestoque.R
import com.example.controleestoque.data.ProdutoRespository

class ProdutoUseCase(private val produtoRepository: ProdutoRespository): UseCasesProduto{

    override suspend fun add(context: Context, nome: String, valor: String, descricao: String, nf: String) {
        if (nome.isEmpty()) {
            context.getString(R.string.NOME_VAZIO)
            if (valor.isEmpty()) {
                context.getString(R.string.VALOR_VAZIO)
                if (nf.isEmpty()) {
                    context.getString(R.string.NF_VAZIO)
                }
            }
        }

        val novoProduto = Produto((produtoRepository.getProdutos().size + 1), nome, valor, descricao, nf)
        produtoRepository.addProduto(novoProduto)

        if (validation(context, novoProduto)) {
            val msg = context.getString(R.string.PROD_ADD)
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    override suspend fun delete(id: Int) {
        produtoRepository.removeProduto(id)
    }

    //TODO - ANY FUNCAO DE LISTA QUE PERCORRE E VERIFICA SE PELO MENOS ALGUM ITEM SATISFAZ A CONDICAO EXIGIDA
    override suspend fun validation(context: Context, produto: Produto): Boolean {
        if (produtoRepository.getProdutos().any { existeProduto ->
            existeProduto.notaFiscal == produto.notaFiscal &&
            existeProduto.nome == produto.nome}) {
            val msg = context.getString(R.string.PROD_JA_EXISTE)
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}