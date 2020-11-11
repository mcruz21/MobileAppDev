package CS4750.SocialApp

import androidx.lifecycle.ViewModel

private const val TAG = "QuestionViewModel"

class QuizViewModel : ViewModel() {

    val questionBank = listOf(
        Question(R.string.question_california),
        Question(R.string.question_county),
        Question(R.string.question_us,),
        Question(R.string.question_africa),
        Question(R.string.question_americas),
        Question(R.string.question_asia))

    var currentIndex = 0
    var isCheater = false
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}
