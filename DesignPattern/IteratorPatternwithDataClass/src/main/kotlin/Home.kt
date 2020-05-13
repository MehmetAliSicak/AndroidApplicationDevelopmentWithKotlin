fun main() {
    val iterator = AllData().getIterator()
    println("NO---------City")
    while (iterator.hasNext()) {
        var city: City? = iterator.next()
        println("${city!!.no}---------${city!!.name}")
    }
}