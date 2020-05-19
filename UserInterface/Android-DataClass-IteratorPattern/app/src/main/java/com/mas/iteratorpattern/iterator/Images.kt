package com.mas.retrofitapp.iterator

import com.mas.iteratorpattern.R
import com.mas.iteratorpattern.model.Language

//Language modelini kullanan ArrayList tanımladık.
var languages = ArrayList<Language>()

class Images : Container {
    override fun getIterator(): Iterator {
        /*languages ArrayList'ine ilgili verileri aşağıdaki gibi ekledik.
        Kullandığımız Language modelinden dolayı ArrayList yapısına Language
        nesneleri ekledik. Her bir nesne iki parametre almaktadır.*/
        languages.add(Language(R.drawable.kotlin, "Kotlin"))
        languages.add(Language(R.drawable.java, "Java"))
        languages.add(Language(R.drawable.c, "C"))
        languages.add(Language(R.drawable.cplus, "C++"))
        languages.add(Language(R.drawable.fsharp, "F#"))
        return NameIterator()
    }

    class NameIterator : Iterator {
        var index: Int = -1

        override fun hasNext(): Boolean {
            if (index < languages!!.size) {
                return true
            }
            return false
        }

        override fun next(): Language? {
            if (this.hasNext()) {
                return languages!!.get(++index)
            }
            return null
        }

        override fun hasPrev(): Boolean {
            if (index > 0) {
                return true
            }
            return false
        }

        override fun prev(): Language? {

            if (this.hasPrev()) {
                return languages!!.get(--index)
            }

            return null
        }
    }
}