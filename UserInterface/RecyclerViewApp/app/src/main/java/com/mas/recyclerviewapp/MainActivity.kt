package com.mas.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Veriler alınır. Bunun için drawable klasöründe bulunan
        resimlerin ID bilgisi ArrayList yapısına eklenir.*/
        val images_lang = ArrayList<Int>()
        images_lang.add(R.drawable.java)
        images_lang.add(R.drawable.kotlin)
        images_lang.add(R.drawable.cplus)
        images_lang.add(R.drawable.c)
        images_lang.add(R.drawable.fsharp)

        /*strings.xml dosyasında tanımladığımız
        string array verileri alınır.*/
        val languages = resources.getStringArray(R.array.programming)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(images_lang,languages, applicationContext)

        /*setHasFixedSize(true):Bu özelliği set ettiğimizde
        performansı arttırır. Eğer içeriğin değişmesi, RecyclerView
        düzen boyutunu değiştirmiyorsa bu özelliği set edebilirsiniz.

        layoutManager: Her bir satırın nasıl hizalanacağı belirlenir.
        Her satır dikey olarak hizalanır.

        adapter: RecyclerView, adapter ile doldurulur.*/
        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

    }
}
