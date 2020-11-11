package CS4750.SocialApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class MainActivity : AppCompatActivity() {

     private val questionViewModel: QuestionViewModel by lazy {
         ViewModelProviders.of(this).get(QuestionViewModel::class.java)
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(){};

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

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i(TAG,"onSaveInstanceState")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }
    private fun updateQuestion() {
        XButton.isEnabled = true
        YalseButton.isEnabled= true
        val questionTextResId = questionViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }
    private fun updateQuestion1() {
        XButton.isEnabled = false
        YButton.isEnabled= false
        val questionTextResId = questionViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }
    companion object {
        private const val TAG = "MainActivity"
        private const val KEY_INDEX = "index"
    }

}