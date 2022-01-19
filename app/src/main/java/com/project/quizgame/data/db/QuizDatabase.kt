package com.project.quizgame.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.quizgame.data.db.dao.QuizDao
import com.project.quizgame.data.db.entity.QuizEnt
import com.project.quizgame.data.db.entity.QuizTypeConverter

@Database(entities = [QuizEnt::class], version = 1)
@TypeConverters(QuizTypeConverter::class)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun getQuizDao(): QuizDao
}