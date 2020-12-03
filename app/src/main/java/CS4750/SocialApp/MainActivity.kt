package com.bignerdranch.android.geoquiz


import CS4750.SocialApp.Question
import CS4750.SocialApp.QuizViewModel
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
private const val REQUEST_CODE_CHEAT = 0
class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView


    private val questionViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Companion.TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        questionViewModel.currentIndex = currentIndex

        nextButton = findViewById(R.id.next_button)

        questionTextView = findViewById(R.id.question_text_view)

        nextButton.setOnClickListener {
            questionViewModel.moveToNext()
            updateQuestion()
        }
        updateQuestion()

    }
    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, questionViewModel.currentIndex)
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
    private fun updateQuestion() {
        val questionTextResId = questionViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }
    private fun updateQuestion1() {
        trueButton.isEnabled = false
        falseButton.isEnabled= false
        val questionTextResId = questionViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }


    companion object {
        private const val TAG = "MainActivity"
        private const val KEY_INDEX = "index"
    }
}