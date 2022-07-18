package com.vignesh.harrypotterquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1;
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = -1
    private var score: Int =0;
    private var isAttended = false;
    private var userName : String? = null
    private var pbProgressBar: ProgressBar? = null
    private var tvProgressIndicator: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null
    private var ivImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        val intent = intent
        userName = intent.getStringExtra("USER_NAME")
        Log.i("RESULTACTVITIY",userName.toString())

        ivImage = findViewById(R.id.ivImage)
        pbProgressBar = findViewById(R.id.pbProgressBar)
        tvProgressIndicator = findViewById(R.id.tvProgressIndicator)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)

        mQuestionsList = Constants.getQuestions()


        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()




    }

    private fun setQuestion() {
        resetOptions()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        pbProgressBar?.progress = mCurrentPosition
        tvProgressIndicator?.text = "$mCurrentPosition/${pbProgressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOptionOne -> {
                if(!isAttended){
                    tvOptionOne?.setBackgroundResource(R.drawable.selected_option_border_bg)
                    tvOptionTwo?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionThree?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionFour?.setBackgroundResource(R.drawable.default_option_border_bg)
                    mSelectedOptionPosition = 0
                }

            }
            R.id.tvOptionTwo -> {
                if(!isAttended){
                    tvOptionOne?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionTwo?.setBackgroundResource(R.drawable.selected_option_border_bg)
                    tvOptionThree?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionFour?.setBackgroundResource(R.drawable.default_option_border_bg)
                    mSelectedOptionPosition = 1
                }
            }
            R.id.tvOptionThree -> {
                if(!isAttended){
                    tvOptionOne?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionTwo?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionThree?.setBackgroundResource(R.drawable.selected_option_border_bg)
                    tvOptionFour?.setBackgroundResource(R.drawable.default_option_border_bg)
                    mSelectedOptionPosition = 2
                }
            }
            R.id.tvOptionFour -> {
                if(!isAttended){
                    tvOptionOne?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionTwo?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionThree?.setBackgroundResource(R.drawable.default_option_border_bg)
                    tvOptionFour?.setBackgroundResource(R.drawable.selected_option_border_bg)
                    mSelectedOptionPosition = 3
                }
            }
            R.id.btnSubmit -> {
                if(btnSubmit?.text == "GO TO NEXT QUESTION"){
                    isAttended = false
                }else if(btnSubmit?.text == "SUBMIT" && mSelectedOptionPosition != -1){
                    isAttended = true
                }
                if(mSelectedOptionPosition == -1){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra("SCORE",score.toString())
                            intent.putExtra("USER_NAME",userName.toString())
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    Log.i("QUIZACTVITIY",question?.correctAnswer.toString())
                    Log.i("QUIZACTVITIY",mSelectedOptionPosition.toString())
                    if(question!!.correctAnswer == mSelectedOptionPosition){
                        score++
                    }

                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        Log.i("QUIZACTVITIY","WRONG ANSWER")

                        when(mSelectedOptionPosition){

                            0  -> tvOptionOne?.setBackgroundResource(R.drawable.incorrect_option_border_bg)
                            1  -> {
                                tvOptionTwo?.setBackgroundResource(R.drawable.incorrect_option_border_bg)
                                Log.i("QUIZACTVITIY","im here")
                            }

                            2  -> tvOptionThree?.setBackgroundResource(R.drawable.incorrect_option_border_bg)
                            3  -> tvOptionFour?.setBackgroundResource(R.drawable.incorrect_option_border_bg)
                        }
                    }
                    when(question!!.correctAnswer){
                        0  -> tvOptionOne?.setBackgroundResource(R.drawable.correct_option_border_bg)
                        1  -> tvOptionTwo?.setBackgroundResource(R.drawable.correct_option_border_bg)
                        2  -> tvOptionThree?.setBackgroundResource(R.drawable.correct_option_border_bg)
                        3  -> tvOptionFour?.setBackgroundResource(R.drawable.correct_option_border_bg)
                    }

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "GO TO NEXT QUESTION"


                    }
                    mSelectedOptionPosition = -1

                }

            }

        }
    }
    private fun resetOptions(){
        tvOptionOne?.setBackgroundResource(R.drawable.default_option_border_bg)
        tvOptionThree?.setBackgroundResource(R.drawable.default_option_border_bg)
        tvOptionTwo?.setBackgroundResource(R.drawable.default_option_border_bg)
        tvOptionFour?.setBackgroundResource(R.drawable.default_option_border_bg)
    }
}