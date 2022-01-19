package com.project.quizgame.di

import com.project.quizgame.data.db.QuizDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RoomModule {
    @Provides
    fun getQuizDatabaseDao(quizDatabase: QuizDatabase) = quizDatabase.getQuizDao()
}