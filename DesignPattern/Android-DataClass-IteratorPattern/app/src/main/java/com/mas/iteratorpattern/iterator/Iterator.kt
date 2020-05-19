package com.mas.retrofitapp.iterator

import com.mas.iteratorpattern.model.Language

interface Iterator {
    fun hasNext(): Boolean
    fun next(): Language?
    fun hasPrev(): Boolean
    fun prev(): Language?
}