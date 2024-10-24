package com.example.controleestoque.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.controleestoque.data.dao.ProdutoDAO
import com.example.controleestoque.domain.model.Produto

@Database(entities = [Produto::class], version = 1, exportSchema = false)
abstract class ProdutoDB : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDAO
}
   /* companion object {
        @Volatile
        private var INSTANCE: ProdutoDB? = null

        fun getDatabase(context: Context): ProdutoDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProdutoDB::class.java,
                    "produto_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}*/
