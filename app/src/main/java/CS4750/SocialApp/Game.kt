package com.bignerdranch.android.geoquiz

import CS4750.SocialApp.QuizViewModel
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
private const val TAG = "Home"
class Home : AppCompatActivity() {
    private lateinit var nextButton: ImageButton
    //private lateinit var passButton: ImageButton
    private lateinit var failButton: ImageButton
    private lateinit var questionTextView: TextView
    private var counter =0





    private val questionViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d(Companion.TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_game)
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
    private fun startTimeCounter() {
        val countTime: TextView = findViewById(R.id.countTime)
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.text = counter.toString()
                counter++
                nextButton.setOnClickListener {
                    this.cancel()
                    questionViewModel.moveToNext()
                    updateQuestion()
                }
            }
            override fun onFinish() {
                countTime.text = "Times up!"
            }
        }.start()
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
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
        counter =0
        startTimeCounter()
        val questionTextResId = questionViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)


    }
    private fun updateQuestion1() {
        val questionTextResId = questionViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }



    companion object {
        private const val TAG = "Home"
        private const val KEY_INDEX = "index"
    }
}