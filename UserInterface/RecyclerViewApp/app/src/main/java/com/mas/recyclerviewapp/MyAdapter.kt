package com.mas.recyclerviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
/*RecyclerView.Adapter: Adapter oluşturmak için bu sınıf kullanılır.
Adapter sınıfları, veri ile AdapterView arasındaki bağlantıyı sağlar.*/
/*Kurucu metot ile ihtiyaç duyulan parametreler alınır.
Burada iki adet Array ile çalıştık. Biri resimleri diğeri de
programlama dili isimlerini tutmayı sağlar.*/
class MyAdapter(
    private val images_lang: ArrayList<Int>,
    private val languages: Array<String>,
    val applicationContext: Context
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    /*RecyclerView ve ListView içerisinde periyodik
    olarak findViewById metodunu çağırmak performansı düşürebilir.
    Bundan dolayı bu işlem için ViewHolder sınıfı kullanılır.*/
    class MyViewHolder(val layout: RelativeLayout) : RecyclerView.ViewHolder(layout) {
        val img = layout.findViewById<ImageView>(R.id.img)
        val lang = layout.findViewById<TextView>(R.id.lang)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        /*Her bir satır temsil edecek arayüz seçilir.*/
        val relativeLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.custom_layout,
            parent,
            false
        ) as RelativeLayout

        return MyViewHolder(relativeLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        /*Her bir görünümün içeriği belirlenir.*/
        holder.lang.text = languages[position]
        holder.img.setImageResource(images_lang[position])
        holder.layout.setOnClickListener {
            Toast.makeText(
                applicationContext,
                languages[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    /*Gelen verilerin boyutu*/
    override fun getItemCount() = languages.size
}