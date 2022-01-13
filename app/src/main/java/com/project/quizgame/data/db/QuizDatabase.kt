package com.project.quizgame.data.db

import androidx.room.Database
import com.project.quizgame.data.db.entites.QuizEnt

@Database(entities = [QuizEnt::class], version = 1)
object QuizDatabase {
    
}