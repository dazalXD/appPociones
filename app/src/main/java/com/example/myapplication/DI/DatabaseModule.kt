package com.example.myapplication.DI

import android.content.Context
import com.example.myapplication.DB.DatabaseHelper
import com.example.myapplication.Data.Local.Sources.PocionesLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabaseHelper(@ApplicationContext context: Context): DatabaseHelper {
        return DatabaseHelper(context)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseSourceModule {
    @Provides
    @Singleton
    fun bindLocalDataSource(dbHelper: DatabaseHelper): PocionesLocalDataSource =
        PocionesLocalDataSource(dbHelper)
}
