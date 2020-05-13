import com.mas.retrofitapp.iterator.Iterator

var languages = ArrayList<City>()

class AllData : Container {
    override fun getIterator(): Iterator {
        fillList()
        return Languages()
    }

    private fun fillList() {
        languages.add(City("01","Adana"))
        languages.add(City("02","Adıyaman"))
        languages.add(City("03","Afyon"))
        languages.add(City("04","Ağrı"))
        languages.add(City("05","Amasya"))
        languages.add(City("06","Ankara"))
    }

    class Languages : Iterator {
        var index = 0
        override fun hasNext(): Boolean {
            if (index < languages!!.size) {
                return true
            }
            return false
        }

        override fun next(): City? {
            if (this.hasNext()) {
                return languages!!.get(index++)
            }
            return null
        }

    }
}