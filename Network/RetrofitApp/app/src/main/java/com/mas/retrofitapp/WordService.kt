package com.mas.retrofitapp

import retrofit2.Call
import retrofit2.http.GET

interface WordService {
    @GET("word_list.php")
    fun getList(): Call<List<Word>>
}