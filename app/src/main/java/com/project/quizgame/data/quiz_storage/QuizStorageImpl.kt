package com.project.quizgame.data.quiz_storage

import android.content.Context
import com.project.quizgame.data.db.entity.Difficulty
import com.project.quizgame.data.db.entity.QuizEnt
import com.project.quizgame.data.db.entity.QuizType
import java.io.BufferedReader
import javax.inject.Inject
import kotlin.math.abs
import kotlin.random.Random

class QuizStorageImpl @Inject constructor( private val context: Context) : QuizStorage {

    companion object {
        private const val FILE_ID = "data"
    }

    override suspend fun loadQuizes(): List<QuizEnt> {
        val questions = mutableListOf<List<String>>()
        val fileInputStream = context.resources.openRawResource(
            context.resources.getIdentifier(FILE_ID, "raw", context.packageName))
        val reader = BufferedReader(fileInputStream.reader())
        reader.use {
            var line = it.readLine()
            questions.add(line.split("\t"))
            while (line != null) {
                line = it.readLine()
                questions.add(line.split("\t"))
            }
        }
        return generateQuizes(questions)

    }

    fun generateQuizes(questions: List<List<String>>): List<QuizEnt> {
        val quizEnts = mutableListOf<QuizEnt>()
        questions.forEachIndexed { index, question ->
            val correctAns = question[0]
            val answers = mutableListOf<String>()
            val randoms = mutableListOf<Int>()
            while (randoms.size < 3) {
                val ansIndex = abs(Random.nextInt(index - 10, index + 10))%questions.size
                if (ansIndex != index && !randoms.contains(ansIndex) && correctAns != questions[ansIndex][0]) randoms.add(ansIndex)
            }
            randoms.add(index)
            quizEnts.add(QuizEnt(-1, question[1], Difficulty.NONE, QuizType.FourChooser(randoms.map { questions[it][0] },  index)))

        }

        return quizEnts
    }
}