package com.example.myapplication.DB

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.Data.Local.DAO.IngredienteDao
import com.example.myapplication.Data.Local.DAO.ObtencionDao
import com.example.myapplication.Data.Local.DAO.PocionesDao
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Entities.ObtencionEntity
import com.example.myapplication.Data.Local.Entities.PasoPocionEntity
import com.example.myapplication.Data.Local.Entities.PocionEntity
import com.example.myapplication.Data.Local.Entities.PocionIngredienteCrossRef

@Database(
    entities = [
        IngredienteEntity::class,
        ObtencionEntity::class,
        PocionEntity::class,
        PasoPocionEntity::class,
        PocionIngredienteCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun obtencionDao(): ObtencionDao
    abstract fun ingredienteDao(): IngredienteDao
    abstract fun pocionesDao(): PocionesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "minecraft_potions.db"
                )
                    // Agregamos una llamada a .addCallback para registrar la creación
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Este código se ejecuta UNA SOLA VEZ, la primera vez que se crea la BD
                            Log.d("AppDataBase", "Base de datos CREADA por primera vez.")
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            // Este código se ejecuta CADA VEZ que se abre la BD
                            Log.d("AppDataBase", "Base de datos ABIERTA.")
                        }
                    })
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}