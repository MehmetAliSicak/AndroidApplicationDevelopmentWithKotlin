import com.mas.retrofitapp.iterator.Iterator

var cities = ArrayList<City>()

class AllData : Container {
    override fun getIterator(): Iterator {
        fillList()
        return Languages()
    }

    private fun fillList() {
        cities.add(City("01","Adana"))
        cities.add(City("02","Adıyaman"))
        cities.add(City("03","Afyon"))
        cities.add(City("04","Ağrı"))
        cities.add(City("05","Amasya"))
        cities.add(City("06","Ankara"))
    }

    class Languages : Iterator {
        var index = 0
        override fun hasNext(): Boolean {
            if (index < cities!!.size) {
                return true
            }
            return false
        }

        override fun next(): City? {
            if (this.hasNext()) {
                return cities!!.get(index++)
            }
            return null
        }

    }
}