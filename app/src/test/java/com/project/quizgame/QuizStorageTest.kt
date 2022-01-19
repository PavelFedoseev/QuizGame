package com.project.quizgame

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.project.quizgame.data.quiz_storage.QuizStorage
import com.project.quizgame.data.quiz_storage.QuizStorageImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class QuizStorageTest {

    private lateinit var quizStorage: QuizStorage
    @Before
    fun setUp(){
        val app : Context = getApplicationContext()
        quizStorage = QuizStorageImpl(app)
    }
    @Test
    fun `QuizStorage test`() {
        runBlocking {
            val quizes = quizStorage.loadQuizes()
            assert(true)
        }

    }
}