package com.project.quizgame.presentation.fragemnt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.quizgame.R
import com.project.quizgame.data.db.entity.QuizEnt

class FourChooserFragment private constructor(): Fragment() {

    companion object{
        fun newInstance(quizEnt: QuizEnt) = FourChooserFragment().apply {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_four_chooser, container)
    }
}