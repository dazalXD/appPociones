package com.example.myapplication.DI

import android.content.Context
import com.example.myapplication.DB.AppDataBase
import com.example.myapplication.Data.Local.DAO.IngredienteDao
import com.example.myapplication.Data.Local.DAO.ObtencionDao
import com.example.myapplication.Data.Local.DAO.PocionesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase {
        return AppDataBase.getInstance(context)
    }

    @Provides
    fun provideIngredienteDao(database: AppDataBase): IngredienteDao {
        return database.ingredienteDao()
    }

    @Provides
    fun providePocionesDao(database: AppDataBase): PocionesDao {
        return database.pocionesDao()
    }

    @Provides
    fun provideObtencionDao(database: AppDataBase): ObtencionDao {
        return database.obtencionDao()
    }
}
