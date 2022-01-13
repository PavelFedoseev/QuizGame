package com.project.quizgame

import com.project.quizgame.data.db.entites.QuizType
import com.project.quizgame.data.db.entites.QuizTypeConverter
import org.junit.Test

class TypeConverterTest {

    @Test
    fun `QuizType converter test`(){
        val testWriteAnswer = QuizType.WriteAnswer(listOf("test1", "test2", "test3", "test4"))
        val testFourAnswer = QuizType.FourChooser(listOf("test1", "test2", "test3", "test4"), 1)

        val converterTest = QuizTypeConverter()
        val writeString = converterTest.fromQuizToString(testWriteAnswer)
        val convertWriteResult = converterTest.fromStringToQuizType(writeString)
        assert(testWriteAnswer == convertWriteResult)
        val fourString = converterTest.fromQuizToString(testFourAnswer)
        val convertFourResult = converterTest.fromStringToQuizType(fourString)
        assert(testFourAnswer == convertFourResult)
    }
}