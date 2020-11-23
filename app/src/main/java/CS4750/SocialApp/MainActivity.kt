package CS4750.SocialApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_1, true),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, true),
        Question(R.string.question_5, true),
        Question(R.string.question_6, true),
        Question(R.string.question_7, true),
        Question(R.string.question_8, true),
        Question(R.string.question_9, true),
        Question(R.string.question_10, true),
        Question(R.string.question_11, true),
        Question(R.string.question_12, true),
        Question(R.string.question_13, true),
        Question(R.string.question_14, true),
        Question(R.string.question_15, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        updateQuestion()

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

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
}
