package com.mas.alarmclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    //Değişkenlerimiz
    val days = ArrayList<Int>()
    lateinit var message: String
    var hour: Int = 0
    var minutes: Int = 0
    var etHour: EditText? = null
    var etMinute: EditText? = null
    var etMesage: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getControls()
    }

    //Arayüz kontrollerine erişim sağlarız.
    private fun getControls() {
        etHour = findViewById<EditText>(R.id.etHour)
        etMinute = findViewById<EditText>(R.id.etMinute)
        etMesage = findViewById<EditText>(R.id.etMesage)
    }

    //Alarm için mesaj ve alarmın çalacağı saat ve dakika
    private fun getInfoAlarm() {
        hour = (etHour!!.text.toString()).toInt()
        minutes = (etMinute!!.text.toString()).toInt()
        message = etMesage!!.text.toString()
    }

    fun createAlarm(view: View) {
        //bu metot ile arayüzde girilen veriler alınır
        getInfoAlarm()
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
            putExtra(AlarmClock.EXTRA_DAYS, days)
            putExtra(AlarmClock.EXTRA_VIBRATE, true)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            Toast.makeText(baseContext, "Alarm Oluşturuldu", Toast.LENGTH_SHORT).show()
        }
    }

    //Alarmın hangi günler tekrarlanacağı burada belirlenir.
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.cbSun -> {
                    if (checked) {
                        //Pazar günü tekrarlanır.
                        days.add(Calendar.SUNDAY)
                    } else {
                        //Pazar günü tekrarlanmaz.
                        days.remove(Calendar.SUNDAY)
                    }
                }
                R.id.cbMon -> {
                    if (checked) {
                        days.add(Calendar.MONDAY)
                    } else {
                        days.remove(Calendar.MONDAY)
                    }
                }
                R.id.cbTue -> {
                    if (checked) {
                        days.add(Calendar.TUESDAY)
                    } else {
                        days.remove(Calendar.TUESDAY)
                    }
                }
                R.id.cbWed -> {
                    if (checked) {
                        days.add(Calendar.WEDNESDAY)
                    } else {
                        days.remove(Calendar.WEDNESDAY)
                    }
                }
                R.id.cbThu -> {
                    if (checked) {
                        days.add(Calendar.THURSDAY)
                    } else {
                        days.remove(Calendar.THURSDAY)
                    }
                }
                R.id.cbFri -> {
                    if (checked) {
                        days.add(Calendar.FRIDAY)
                    } else {
                        days.remove(Calendar.FRIDAY)
                    }
                }
                R.id.cbSat -> {
                    if (checked) {
                        days.add(Calendar.SATURDAY)
                    } else {
                        days.remove(Calendar.SATURDAY)
                    }
                }
            }
        }
    }
}
