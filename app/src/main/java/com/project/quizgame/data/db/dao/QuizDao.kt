package com.project.quizgame.data.db.dao

import androidx.room.*
import com.project.quizgame.data.db.entity.QuizEnt

@Dao
interface QuizDao {
    @Insert
    fun insertQuiz(quizEnt: QuizEnt)

    @Update
    fun updateQuiz(quizEnt: QuizEnt)

    @Delete
    fun deleteQuiz(quizEnt: QuizEnt)

    @Query("SELECT * FROM quiz_table WHERE id = :id")
    suspend fun getQuizById(id: Int): QuizEnt

    @Query("SELECT * FROM quiz_table")
    suspend fun getAllQuizEnt(): List<QuizEnt>
}