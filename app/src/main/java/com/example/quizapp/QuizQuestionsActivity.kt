package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {

    // Current and default choice of an answer
    private var mCurrentPosition: Int = 1

    // A variable for the questions list
    // (is null because we will initialize it later)
    private var mQuestionsList: ArrayList<Question>? = null

    // Selected object position
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()
        Log.i("QuestionsSize", "${mQuestionsList!!.size}")

        /****************************************************/
        /*** Setting the question in the UI from the list ***/
        /****************************************************/
        setQuestion()
    }

    private  fun setQuestion(){
        // Default and the first question position of questionsList
        mCurrentPosition = 1
        // Getting one question from the list with the help of current position
        val question = mQuestionsList!![mCurrentPosition - 1]

        // Set all buttons to the default appearance
        defaultOptionsView()

        // Setting the current progress in the progressbar using the position of question
        progressBar.progress = mCurrentPosition
        // Setting up the progress text
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        // Set the current question and the options in the UI
        // according to chosen question
        tv_question.text = question.question
        iv_image.setImageResource((question.image))
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    // This function makes to look out options TextVies default
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg)
        }
    }
}