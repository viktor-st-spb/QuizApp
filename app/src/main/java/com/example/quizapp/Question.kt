package com.example.quizapp

/****************************************/
/*** This class defines the format of ***/
/***      questions of an app         ***/
/****************************************/

data class Question(
    // The id of the question
    val id: Int,
    // Question
    val question: String,
    // Image ID
    val image: Int,
    // Four possible answers
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    // The number of the correct answer (1, 2, 3 or 4)
    val correctAnswer: Int
)