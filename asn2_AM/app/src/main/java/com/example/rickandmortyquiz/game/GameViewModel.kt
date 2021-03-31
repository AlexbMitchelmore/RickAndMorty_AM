package com.example.rickandmortyquiz.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyquiz.R

data class Question(
    val id: Int,
    val answer: Boolean,
    var attempted: Boolean = false,
    var isCorrect: Boolean = false
)

class GameViewModel : ViewModel() {

    private var currentQuestion = 0
    private lateinit var questionList: MutableList<Question>

    private val _question = MutableLiveData<Int>()
    val question: LiveData<Int>
        get() = _question

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _score2 = MutableLiveData<Int>()
    val score2: LiveData<Int>
        get() = _score2

    private fun updateQuestion(){
        _question.value = questionList[currentQuestion].id
    }

    private fun resetList() {
        questionList = mutableListOf(
            Question(R.string.question_1, false),
            Question(R.string.question_2, true),
            Question(R.string.question_3, true),
            Question(R.string.question_4, false),
            Question(R.string.question_5, false),
            Question(R.string.question_6, true),
            Question(R.string.question_7, false),
            Question(R.string.question_8, true),
            Question(R.string.question_9, false),
            Question(R.string.question_10, false),
            Question(R.string.question_11, false),
            Question(R.string.question_12, true),
            Question(R.string.question_13, false),
            Question(R.string.question_14, true),
            Question(R.string.question_15, false),
            Question(R.string.question_16, false),
            Question(R.string.question_17, true),
            Question(R.string.question_18, false),
            Question(R.string.question_19, false),
            Question(R.string.question_20, true)
        )
        //questionList.shuffle()
    }

    init {
        _question.value = 0
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        updateQuestion()
    }

    fun nextQuestion(){
        currentQuestion = (currentQuestion + 1) % questionList.size
        updateQuestion()
    }

    fun previousQuestion(){
        currentQuestion = (currentQuestion - 1 + questionList.size) % questionList.size
        updateQuestion()
    }

    fun answerQuestion(answer: Boolean ){
        if (answer){

        }
    }
}