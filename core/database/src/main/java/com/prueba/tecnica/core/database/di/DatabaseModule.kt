package com.prueba.tecnica.core.database.di

import android.content.Context
import androidx.room.Room
import com.prueba.tecnica.core.database.AppDatabase
import com.prueba.tecnica.core.database.dao.BetItemDao
import com.prueba.tecnica.core.database.dao.MatchItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "BetDayLiteDB"
        ).build()
    }

    @Provides
    fun provideMatchItemDao(db: AppDatabase): MatchItemDao = db.matchItemDao()

    @Provides
    fun provideBetItemDao(db: AppDatabase): BetItemDao = db.betItemDao()
}