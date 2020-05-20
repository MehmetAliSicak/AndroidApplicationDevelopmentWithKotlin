package com.mas.retrofitapp.iterator

import com.mas.gsonapp.Word
interface Iterator {
    var index: Int
    fun hasNext(): Boolean
    fun next(): Word?
    fun hasPrev(): Boolean
    fun prev(): Word?
}