package com.mas.retrofitapp.iterator

import City

interface Iterator {
    fun hasNext(): Boolean
    fun next(): City?
}