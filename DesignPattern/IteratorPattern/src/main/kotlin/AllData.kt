import com.mas.retrofitapp.iterator.Iterator

var languages = ArrayList<String>()

class AllData : Container {
    override fun getIterator(): Iterator {
        fillList()
        return Languages()
    }

    private fun fillList() {
        languages.add("Kotlin")
        languages.add("Java")
        languages.add("JavaScript")
        languages.add("Python")
    }

    class Languages : Iterator {
        var index = 0
        override fun hasNext(): Boolean {
            if (index < languages!!.size) {
                return true
            }
            return false
        }

        override fun next(): String? {
            if (this.hasNext()) {
                return languages!!.get(index++)
            }
            return null
        }

    }
}