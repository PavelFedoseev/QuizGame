package com.project.quizgame.data.db.entites

import androidx.room.Entity
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity(tableName = "quiz_table")
data class QuizEnt(
    var id: Int,
    var name: String,
    var difficulty: Int,
    @TypeConverters(QuizTypeConverter::class)
    var type: QuizType
)

sealed class QuizType{
    data class FourChooser(val answers: List<String>, val correctAnswerId: Int): QuizType()
    data class WriteAnswer(val correctAnswer: List<String>): QuizType()
}