package com.project.quizgame.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.quizgame.data.db.QuizDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun getApplicationContext(@ApplicationContext context: Context) = context

    @Provides
    fun getQuizDatabase(@ApplicationContext context: Context): QuizDatabase =
        Room.databaseBuilder(context,
            QuizDatabase::class.java,
            "quizDatabase.db")
            .fallbackToDestructiveMigration()
            .build()
}