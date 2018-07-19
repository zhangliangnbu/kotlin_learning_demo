package com.liang.kotlinlearning

class KotlinClass {
    companion object {
        const val PI = 3.14
        fun max(a: Int, b: Int): Int {
            return if (a > b) {
                a
            } else {
                b
            }
        }
    }
}