package com.example.controleestoque.domain.usecase

import android.content.Context
import android.widget.Toast
import com.example.controleestoque.R
import com.example.controleestoque.data.repositories.ProdutoRepository
import com.example.controleestoque.domain.model.Produto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class ProdutoUseCase (
    private val produtoRepository: ProdutoRepository,
    private val context: Context
): ProdutoUseCaseInterface {

    override suspend fun add(nome: String, valor: String, descricao: String, nf: String): Boolean {
        if (nome.isEmpty()) {
            showToast(R.string.NOME_VAZIO)
            return false
        }
        if (valor.isEmpty()) {
            showToast(R.string.NOME_VAZIO)
            return false
        }
        if (nf.isEmpty()) {
            showToast(R.string.NOME_VAZIO)
            return false
        }

        val novoProduto = Produto(
            nome = nome,
            valor = valor,
            descricao = descricao,
            notaFiscal = nf
        )

        if (validation(novoProduto)) {
            produtoRepository.addProduto(novoProduto)
            showToast(R.string.PROD_ADD)
            return true
        }
        return false
    }

    override suspend fun delete(id: Int) {
        produtoRepository.removeProduto(id)
    }
    // TODO - Context de um Toast
    private fun showToast(msgId: Int){
        Toast.makeText(context, context.getString(msgId), Toast.LENGTH_SHORT).show()
    }

    override suspend fun getAllProducts(): Flow<List<Produto>> {
        return produtoRepository.getProdutos()
    }

    override suspend fun update(id: Int, nome: String, valor: String, descricao: String, nf: String) {
        val produtoAtualizado = Produto(
            id = id,
            nome = nome,
            valor = valor,
            descricao = descricao,
            notaFiscal = nf
        )
        try {
            produtoRepository.updateProduto(produtoAtualizado)
            showToast(R.string.PROD_UPDATE)
        } catch (e: Exception){
            showToast(R.string.PROD_UPDATE_ERROR)
        }

    }

    //ANY FUNCAO DE LISTA QUE PERCORRE E VERIFICA SE PELO MENOS ALGUM ITEM SATISFAZ A CONDICAO EXIGIDA
    override suspend fun validation(produto: Produto): Boolean {
        val produtos = produtoRepository.getProdutos().first()
        if (produtos.any { existeProduto ->
                existeProduto.notaFiscal == produto.notaFiscal &&
                        existeProduto.nome == produto.nome
            }) {
            showToast(R.string.PROD_JA_EXISTE)
            return false
        }
        return true
    }
}