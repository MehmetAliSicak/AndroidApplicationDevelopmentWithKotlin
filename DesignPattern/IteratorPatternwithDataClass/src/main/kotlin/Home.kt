fun main() {
    val iterator = AllData().getIterator()
    println("NO---------City")
    while (iterator.hasNext()) {
        var city: City? = iterator.next()
        println("${city!!.no}---------${city!!.name}")
    }
}


//////////////Uygualam 32
/*
import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val t1 = async{task1()}
        val t2 = async{task2()}
        val t3 = async{task3()}
        println("The result: ${t1.await() + t2.await() + t3.await()}")
    }
    println("Completed in $time ms")
}

suspend fun task1(): String {
    return "Kotlin "
}

suspend fun task2(): String {
    return "Programming "
}

suspend fun task3(): String {
    return "Language"
}
*/
//////////////Uygulama 31
/*

import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val t1 = task1()
        val t2 = task2()
        val t3 = task3()
        println("The result: ${t1 + t2 + t3}")
    }
    println("Completed in $time ms")
}

suspend fun task1(): String {
    return "Kotlin "
}

suspend fun task2(): String {
    return "Programming "
}

suspend fun task3(): String {
    return "Language"
}
*/
//////////////Uygulama 30
/*
import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val t1 = async{task1()}
        val t2 = async{task2()}
        val t3 = async{task3()}
        println("The result: ${t1.await() + t2.await() + t3.await()}")
    }
    println("Completed in $time ms")
}

suspend fun task1(): String {
    delay(1000L)
    return "Kotlin "
}

suspend fun task2(): String {
    delay(1000L)
    return "Programming "
}

suspend fun task3(): String {
    delay(1000L)
    return "Language"
}
*/

//////////////Uygulama 29
/*
import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val t1 = task1()
        val t2 = task2()
        val t3 = task3()
        println("The result: ${t1 + t2 + t3}")
    }
    println("Completed in $time ms")
}

suspend fun task1(): String {
    delay(1000L)
    return "Kotlin "
}

suspend fun task2(): String {
    delay(1000L)
    return "Programming "
}

suspend fun task3(): String {
    delay(1000L)
    return "Language"
}
*/

//////////////Uygulama 28
/*
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val t1 = task1()
    val t2 = task2()
    val t3 = task3()
    println("The result: ${t1 + t2 + t3}")

}

suspend fun task1(): String {
    delay(1000L)
    return "Kotlin "
}

suspend fun task2(): String {
    delay(1000L)
    return "Programming "
}

suspend fun task3(): String {
    delay(1000L)
    return "Language"
}
*/
//////////////Uygulama 27
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        try {
            repeat(30){i->
                println("$i")
                delay(200L)
            }
        } catch (ce:CancellationException ){
            println("Exception: ${ce.message}")
        }
        finally {
            //withContext kullanımı
            withContext(NonCancellable) {
                delay(200L)//200 milisaniye bir gecikme
                println("finally")
            }
        }
    }
    delay(1000L)
    job.cancelAndJoin()
}

*/
/////////////Uygulama 26
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        try {
            repeat(30){i->
                println("$i")
                delay(200L)
            }
        } catch (ce:CancellationException ){
            println("Exception: ${ce.message}")
        }
        finally {
            delay(200L)//200 milisaniye bir gecikme
            println("finally")
        }
    }
    delay(1000L)
    job.cancelAndJoin()
}

*/

////////////Uygulama 25
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        try {
            repeat(30){i->
                println("$i")
                delay(200L)
            }
        } catch (ce:CancellationException ){
            println("Exception: ${ce.message}")
        }
        finally {
            println("finally")
        }
    }
    delay(1000L)
    job.cancelAndJoin()
}

*/

///////////Uygulama 24
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        try {
            repeat(30){i->
                println("$i")
                delay(200L)
            }
        } finally {
            println("finally")
        }
    }
    delay(1000L)
    job.cancelAndJoin()
}

*/

///////////Uygulama 23
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        try {
            repeat(3){i->
                println("$i")
                delay(200L)
            }
        } finally {
            println("finally")
        }
    }
    delay(1000L)
    job.cancelAndJoin()
}

*/

///////////Uygulama 22
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val name ="Kotlin"
    val st = System.currentTimeMillis()

    val job = launch(Dispatchers.Default) {
        var npt = st
        var i = 0
        while (isActive) {
            if (System.currentTimeMillis() >= npt) {
                println("${name[i]}")
                npt += 500L
                i++;
            }
        }
    }
    delay(1300L)
    println("coroutine is cancelling")
    job.cancelAndJoin()
    println("at the end of program")
}

*/
///////////Uygulama 21
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val name ="Kotlin"
    val st = System.currentTimeMillis()

    val job = launch(Dispatchers.Default) {
        var npt = st

        for (i in name) {
            if (System.currentTimeMillis() >= npt) {
                println("$i")
                npt += 500L

            }
        }
    }
    delay(1300L)
    println("coroutine is cancelling")
    job.cancelAndJoin()
    println("at the end of program")
}

*/
///////////Uygulama 20
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val name ="Kotlin"
    val st = System.currentTimeMillis()

    val job = launch(Dispatchers.Default) {
        var npt = st
        var i = 0
        while (i<name.length) {
            if (System.currentTimeMillis() >= npt) {
                println("${name[i]}")
                npt += 500L
                i++;
            }
        }
    }
    delay(1300L)
    println("coroutine is cancelling")
    job.cancelAndJoin() //coroutine iptal edilir ama while içindeki
                          işlemin bitmesi beklenir.
    println("at the end of program")
}

*/
///////////Uygulama 19
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        for(i in "Kotlin Programming"){
            print("$i ")
            delay(500)
        }
    }
    delay(3000)
    job.cancel() // Coroutine iptal edilir.
}

*/
///////////Uygulama 18
/*
import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        for(i in "Kotlin Programming"){
            print("$i ")
            delay(500)
        }
    }

}

*/
///////////Uygulama 17
/*

import kotlin.concurrent.*
import kotlin.system.measureTimeMillis

fun main()  {
    val duration= measureTimeMillis {
        repeat(50_000) {i ->
            thread {

            }
        }
    }
    println("50K threads took <$duration> ms")
}
*/

//////////Uygulama 16
/*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main()= runBlocking  {
    val duration= measureTimeMillis {
        repeat(50_000) {i ->
            launch {

            }
        }
    }
    println("50K Coroutines took <$duration> ms")
}
*/
//////////Uygulama 15
/*
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    print("Type something:")
    val message = readLine()!!
    launch {
        hello(message)
    }
}

suspend fun hello(message: String) {
    delay(2000L)
    println(message)
}

*/

/////////Uygulama 14
/*
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    print("Type something:")
    val message = readLine()!!
    launch {
        hello(message)
    }
}

fun hello(message: String) {
    println(message)
}

*/
/////////Uygulam 13
/*
import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{
    launch {
        delay(1000L)
        funRun()
    }
    coroutineScope {
        launch {
            delay(5000L)
            funNewScope()
        }
    }
    println("Program sonu")
}

fun funRun() {
    println("runBlocking alanı")
}

fun funNewScope() {
    println("Yeni alan")
}

*/
/////////Uygulama 12
/*

import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = GlobalScope.launch {
        delay(3000L)
        fun2()
    }
    fun1()
    job.join()
}

fun fun2() {
    println("fun2:"+CoroutineName)
}

fun fun1() {
    println("fun1:"+CoroutineName)
}

*/
/////////Uygulama 11
/*
import kotlinx.coroutines.*

fun main() = runBlocking{
    launch {
        delay(3000L)
        fun2()
    }
    fun1()
}

fun fun2() {
    println("fun2:"+CoroutineName)
}

fun fun1() {
    println("fun1:"+CoroutineName)
}

*/

/////////Uygulama 10
/*
import kotlinx.coroutines.*

//join() metodu için, runBlocking ile ana coroutine oluşturduk.
fun main() = runBlocking{
    val job=GlobalScope.launch {
        delay(2000L)
        println("The job is over...")

    }
    println("the program is over")
    // main thread job isimli coroutine tamamlanan kadar bekletilir.
    job.join()
}

*/
////////Uygulama 9
/*
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(2000L)
        println("The job is over...")

    }
    println("the program is over")
    Thread.sleep(2500L)
}

*/

////////Uygulama 8
/*

import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(2000L)
        println("The job is over...")

    }
    println("the program is over")
}

*/

////////Uygulama 7
/*
import kotlinx.coroutines.*

fun main() {
    getJsonDataFromServer()
}

//runBlocking yapısı yeni bir coroutine oluşturur
fun getJsonDataFromServer() = runBlocking{
    delay(2000L) //HATA VERMEZ
    println("the end of program")
}
*/
////////Uygulama 6
/*
import kotlinx.coroutines.*

fun main() {
    getJsonDataFromServer()
}

fun getJsonDataFromServer(){
    delay(2000L) //DERLEME ZAMANI HATASI VERİR
    println("the end of program")
}

*/

////////Uygulama 5
/*
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        getJsonDataFromServer()
    }
}

fun getJsonDataFromServer() {
    println("Veriler sunucudan alınıyor......")
}

*/

////////Uygulama 4
/*
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        Thread.sleep(1000L)
        fun2()
    }
    fun1()
    runBlocking { //runBlocking yapısı
        delay(2000L) //delay burada kullanılabilir.
    }
}

fun fun1() {
    println("Merhaba")
}

fun fun2() {
    println("Dünya")
}
*/


////////Uygulama 3
/*
import kotlin.concurrent.thread

fun main() {
    thread { //GlobalScope.launch { ... } yerine thread {}
        Thread.sleep(1000L) //delay(1000L) yerine Thread.sleep()
        fun2()
    }
    fun1()
    Thread.sleep(2000L)
}

fun fun1() {
    println("Merhaba")
}

fun fun2() {
    println("Dünya")
}
*/


/////////Uygulama 2
/*
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(2001L)//2001 ms gecikme yaptık
        fun2()
    }
    fun1()
    Thread.sleep(2000L)
}

fun fun1() {
    println("Merhaba")
}

fun fun2() {
    println("Dünya")
}
*/

/////////Uygulama 1
/*import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000L)
        fun2()
    }
    fun1()
    Thread.sleep(2000L)
}

fun fun1() {
    println("Merhaba")
}

fun fun2() {
    println("Dünya")
}*/


