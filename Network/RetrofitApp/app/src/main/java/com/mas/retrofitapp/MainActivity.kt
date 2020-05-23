package com.mas.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), Callback<List<Word>> {
    val host_name = "https://memetalisicak.com/"
    lateinit var words: List<Word>
    lateinit var word: Word
    var tvTotal: TextView? = null
    var tvWord: TextView? = null
    var tvMeaning: TextView? = null
    var tvCurrent: TextView? = null
    var oldTouchValue: Float = 0.0F
    var currentX: Float = 0.0F
    var i = 0
    lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getView()
        textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { s ->
            if (s != TextToSpeech.ERROR) {
                textToSpeech.language = Locale.US
            }
        })
        getWords()
    }

    private fun getView() {
        tvTotal = findViewById<TextView>(R.id.tvTotal)
        tvWord = findViewById<TextView>(R.id.tvWord)
        tvMeaning = findViewById<TextView>(R.id.tvMeaning)
        tvCurrent = findViewById<TextView>(R.id.tvCurrent)
    }

    private fun getWords() {
        val gson = GsonBuilder().setLenient().create()
        val client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(host_name)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val service: WordService = retrofit.create(WordService::class.java)
        val call = service.getList()
        call.enqueue(this)
    }

    override fun onResponse(call: Call<List<Word>>?, response: Response<List<Word>>?) {
        words = response!!.body()!!
        tvTotal!!.text = (words.size).toString()
        tvTotal!!.text = "" + words.size
        showWord()
    }

    override fun onFailure(call: Call<List<Word>>?, t: Throwable?) {
        Toast.makeText(applicationContext, "Hata", Toast.LENGTH_SHORT).show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> oldTouchValue = event.getX()
            MotionEvent.ACTION_UP -> {
                currentX = event.getX()
                if (oldTouchValue!! < currentX!!) {
                    i--
                    if (i < 0) i = words!!.size - 1
                } else {
                    i++
                    if (i >= words!!.size) i = 0
                }
            }
        }
        showWord()
        return super.onTouchEvent(event)
    }


    private fun showWord() {
        word = words!!.get(i)
        textToSpeech.speak(word!!.word, TextToSpeech.QUEUE_FLUSH, null)
        tvWord!!.text = word!!.word
        tvMeaning!!.text = word!!.meaning
        tvCurrent!!.text = "" + word!!.id

    }

    public fun speech(v: View) {
        textToSpeech.speak(word!!.word, TextToSpeech.QUEUE_FLUSH, null)
    }
}
