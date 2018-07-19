package com.liang.kotlinlearning

import org.junit.Test
import java.io.File

class KotlinSyntax {
    companion object {
        const val PI = 3.14
    }
    data class Family(var father: String, var mother: String, var brother: String?)
    data class Person(val name: String, val age: Int, val isMale: Boolean,
                      var address: String? = "", val family: Family? = null)

    // 懒加载
    private val freshman by lazy {
        Person("feifei", 18, true)
    }

    // 延迟加载
    private lateinit var old: Person






    fun testDefination() {
        // 不可变
        val a: Int = 1  // 立即赋值
        val b = 2   // 自动推断出 `Int` 类型
        val c: Int  // 如果没有初始值类型不能省略
        c = 3       // 明确赋值

        // 可变
        var x = 5 // 自动推断出 `Int` 类型
        x += 1
    }

    @Test
    fun testStringPattern() {
        val age = 12
        val name = "feifei"
        print("name -> $name, age -> $age")
    }

    fun testNull(str: String?) {
        println("Length = " + str?.length)
    }

    @Test
    fun testCast() {
        val l2 = listOf("A", 1, 3, 6, 8, 'c')
        l2.forEach { println(it as? Int) }
    }

    private var p1: Person? = null
    @Test
    fun testAssert() {
        p1 = Person("feifei", 18, true)
        println(p1!!.name)
    }

    @Test
    fun testCondition() {
        // 空条件
        val files = File("Test").listFiles()
        println(files?.size ?: "empty")

        // if-else
        println("max -> ${maxOf(1, 2)}")

        // when
        val items = listOf("apple", "banana", "kiwifruit", "grape", "pear", "ab...")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }

        // when
        describe(items[0])
    }

    fun maxOf(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

    @Test
    fun testLoop() {
        val items = listOf("apple", "banana", "kiwifruit", "grape", "pear", "ab...")
        // for loop
        testForLoop(items)
        // collection
        testCollection(items)
    }

    private fun testForLoop(items: List<String>) {
        for (item in items) {
            println(item)
        }
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
        for (index in 0 until items.size) {
            println("item at $index is ${items[index]}")
        }
        for (index in items.size - 1 downTo 0 step 2) {
            println("item at $index is ${items[index]}")
        }
    }

    private fun testCollection(items: List<String>) {
        items.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    @Test
    fun testDefaultArgs() {
        println(createPerson("feifei1"))
        println(createPerson("feifei2", 12))
        println(createPerson("feifei2", 12, true))
    }

    private fun createPerson(name:String, age:Int = 0, isMale: Boolean = false):Person {
        return Person(name, age, isMale)
    }

    object Resource {
        val name = "Name"
        const val PI = 3.14
    }

    class Turtle {
        fun penDown(){}
        fun penUp(){}
        fun turn(degrees: Double){}
        fun forward(pixels: Double){}
    }

    // 对一个对象实例调用多个方法 （with）
    @Test
    fun testWith() {
        val myTurtle = Turtle()
        with(myTurtle) { // 画一个 100 像素的正方形
            penDown()
            for(i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }
    }


    @Test
    fun testHighOrderFunc() {
        val items = listOf("a", "b", "c")
        wrapDoSomething { println(items) }
    }

    private fun wrapDoSomething(doSomething:()->Unit) {
        println("-->")
        doSomething()
        println("<--")
    }

    /**
     * -->
    [a, b, c]
    <--
     */

    private fun toItemDetail(item:String) {
        println(item)
    }


}