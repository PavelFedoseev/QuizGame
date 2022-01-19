package com.project.quizgame.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "quiz_table")
//@Parcelize
data class QuizEnt(
    @PrimaryKey val id: Int,
    val name: String,
    val difficulty: Difficulty,
    val type: QuizType
)

sealed class QuizType{
    data class FourChooser(val answers: List<String>, val correctAnswerId: Int): QuizType()
    data class WriteAnswer(val correctAnswer: List<String>): QuizType()
}

enum class Difficulty{
    EASY, NORMAL, HARD, NONE;
}