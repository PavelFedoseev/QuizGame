package com.project.quizgame

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.project.quizgame.data.quiz_storage.QuizStorage
import com.project.quizgame.data.quiz_storage.QuizStorageImpl
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class QuizStorageInstrumentedTest {
    lateinit var instrumentationContext: Context
    lateinit var quizStorage: QuizStorage

    @Before
    fun setup() {
        instrumentationContext = getInstrumentation().context
        quizStorage = QuizStorageImpl(instrumentationContext)

        val resources = instrumentationContext.resources
        val identifier = instrumentationContext.resources.getIdentifier(
            "data",
            "raw",
            instrumentationContext.packageName
        )
        assertNotNull(identifier)
        assertNotNull(resources)
        assertNotNull(instrumentationContext)
    }

    @Test
    fun QuizStorageInstrumentedTest() {
        runBlocking {
            val quizes = quizStorage.loadQuizes()
            assert(quizes.isNotEmpty())
        }
    }
}