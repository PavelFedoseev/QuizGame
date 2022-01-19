package com.project.quizgame.data.quiz_storage

import com.project.quizgame.data.db.entity.QuizEnt

interface QuizStorage {
    suspend fun loadQuizes(): List<QuizEnt>
}