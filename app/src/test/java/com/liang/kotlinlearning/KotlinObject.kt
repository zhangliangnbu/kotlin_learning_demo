package com.liang.kotlinlearning

object KotlinObject {

    const val PI = 3.14

    fun max(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }
}