package com.project.quizgame.data.db.entity

import androidx.room.TypeConverter
import java.lang.IllegalStateException

class QuizTypeConverter {

    @TypeConverter
    fun fromQuizToString(quizType: QuizType): String {
        var answers = ""
        when (quizType) {
            is QuizType.FourChooser -> {
                quizType.answers.forEach {
                    answers += "\n" + it
                }
                answers += "\n" + quizType.correctAnswerId
                return "${quizType::class.simpleName}" + answers
            }
            is QuizType.WriteAnswer -> {
                quizType.correctAnswer.forEach {
                    answers += "\n" + it
                }
                return "${quizType::class.simpleName}" + answers
            }
        }
    }

    @TypeConverter
    fun fromStringToQuizType(text: String): QuizType {
        val result = text.split("\n")
        when (result[0]) {
            QuizType.FourChooser::class.simpleName -> {
                val listOfAnswers = result.filterIndexed { index, s ->
                    index != 0 && index < result.size - 1
                }
                val correctAnswerId = result.last().toInt()
                return QuizType.FourChooser(listOfAnswers, correctAnswerId)
            }
            QuizType.WriteAnswer::class.simpleName -> {
                val listOfAnswers = result.filterIndexed { index, s ->
                    index != 0
                }
                return QuizType.WriteAnswer(listOfAnswers)
            }
            else -> throw IllegalStateException("Wrong QuizType data structure")
        }
    }

    @TypeConverter
    fun fromDifficultyToInt(difficulty: Difficulty) = Difficulty.values().indexOf(difficulty)

    @TypeConverter
    fun fromIntToDifficulty(index: Int) = Difficulty.values()[index]
}