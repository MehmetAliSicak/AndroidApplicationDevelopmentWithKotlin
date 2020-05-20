package com.mas.retrofitapp.iterator

import com.mas.gsonapp.Word


var word_list: List<Word>? = null

class Words : Container {
    override fun getIterator(): Iterator {
        return NameIterator()
    }

    class NameIterator : Iterator {
        override var index: Int = 0

        override fun hasNext(): Boolean {
            if (index < word_list!!.size) {
                return true
            }
            return false
        }

        override fun next(): Word? {
            if (this.hasNext()) {
                return word_list!!.get(index++)
            }
            return null
        }

        override fun hasPrev(): Boolean {
            if (index > 0) {
                return true
            }
            return false
        }

        override fun prev(): Word? {

            if (this.hasPrev()) {
                return word_list!!.get(--index)
            }

            return null
        }
    }
}