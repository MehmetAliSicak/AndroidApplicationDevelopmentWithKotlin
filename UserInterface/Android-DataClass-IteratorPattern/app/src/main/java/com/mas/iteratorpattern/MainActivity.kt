package com.mas.iteratorpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mas.iteratorpattern.model.Language
import com.mas.retrofitapp.iterator.Images

class MainActivity : AppCompatActivity() {

    //Images sınıfı ile bir iterator oluşturuyoruz.
    var iter = Images().getIterator()


    lateinit var imageView: ImageView
    lateinit var textView: TextView

    //Language sınıfından bir adet nesne
    lateinit var lang: Language
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Arayüz bileşenlerinden ImageView ve TextView'e erişim sağlarız
        imageView = findViewById<ImageView>(R.id.imageView)
        textView = findViewById<TextView>(R.id.textView)
    }

    /*ImageButton'ların onClick özelliğine verilen left ve right metotları*/
    fun right(v: View) {
        /*iter.hasNext() ile koleksiyonda veri olup olmadığı kontrol edilir
        Koleksiyonda sonraki verinin gösterimini sağlar.*/
        if (iter.hasNext()) {
            //Eğer veri varsa iter.next ile Language nesnesi alınır.
            lang = iter.next()!!
            /*Language Data Class'ının iki parametresi var: img ve name
            Bunları kullanarak arayüz bileşenlerine ilgili veriler yerleştirilir.*/
            imageView.setImageResource(lang.img)
            textView.text = "" + lang.name
        }
    }

    fun left(v: View) {
        /*iter.hasNext() ile koleksiyonda veri olup olmadığı kontrol edilir
        Koleksiyonda önceki verinin gösterimini sağlar.*/
        if (iter.hasPrev()) {
            lang = iter.prev()!!
            imageView.setImageResource(lang.img)
            textView.text = "" + lang.name
        }
    }
}
