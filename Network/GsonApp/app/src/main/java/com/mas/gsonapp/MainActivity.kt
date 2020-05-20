package com.mas.gsonapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var words: List<Word>
    lateinit var word: Word
    var tvTotal: TextView? = null
    var tvWord: TextView? = null
    var tvMeaning: TextView? = null
    var tvCurrent: TextView? = null
    var oldTouchValue: Float = 0.0F
    var currentX: Float = 0.0F
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getView()
        getWords()

    }

    private fun getView() {
        tvTotal = findViewById<TextView>(R.id.tvTotal)
        tvWord = findViewById<TextView>(R.id.tvWord)
        tvMeaning = findViewById<TextView>(R.id.tvMeaning)
        tvCurrent = findViewById<TextView>(R.id.tvCurrent)
    }

    private fun getWords() {
        val jsonFileString = getJsonData(applicationContext, "word_list.json")
        val gson = Gson()
        val jsonData = object : TypeToken<List<Word>>() {}.type
        words = gson.fromJson(jsonFileString, jsonData)
        tvTotal!!.text = "" + words.size
        showWord()
    }

    fun getJsonData(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> oldTouchValue = event.getX()
            MotionEvent.ACTION_UP -> {
                currentX = event.getX()
                if (oldTouchValue!! < currentX!!) {
                    i--
                    if (i < 0) i = words.size - 1
                } else {
                    i++
                    if (i >= words.size) i = 0
                }
            }
        }
        showWord()
        return super.onTouchEvent(event)
    }

    private fun showWord() {
        word = words.get(i)
        tvWord!!.text = word.word
        tvMeaning!!.text = word.meaning
        tvCurrent!!.text = "" + word.id
    }
}
