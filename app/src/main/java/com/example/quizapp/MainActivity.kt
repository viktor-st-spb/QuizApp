package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        /*** Button Start onClickListener ***/
        btn_start.setOnClickListener {

            // Check if EditText et_name is empty (no text inside this field)
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(
                    this, "Please enter your name",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                // In case user has entered his name - start QuizQuestionsActivity
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                startActivity(intent)
                // Destroy the current activity
                finish()
            }
        }
    }
}