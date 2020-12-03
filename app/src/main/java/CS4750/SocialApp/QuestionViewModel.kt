package CS4750.SocialApp
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.geoquiz.R


private const val TAG = "QuestionViewModel"

class QuizViewModel : ViewModel() {

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

    var currentIndex = 0
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}
