package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        Log.i("Questions Size", "${questionsList.size}")

        /****************************************************/
        /*** Setting the question in the UI from the list ***/
        /****************************************************/

        // Default and the first question position of questionsList
        val currentPosition = 1
        // Getting one question from the list with the help of current position
        val question: Question = questionsList[currentPosition - 1]

        // Setting the current progress in the progressbar using the position of question
        progressBar.progress = currentPosition
        // Setting up the progress text
        tv_progress.text = "$currentPosition" + "/" + progressBar.max

        // Set the current question and the options in the UI
        // according to chosen question
        tv_question.text = question.question
        iv_image.setImageResource((question.image))
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }
}