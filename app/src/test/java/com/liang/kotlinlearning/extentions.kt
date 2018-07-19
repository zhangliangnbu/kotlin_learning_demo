package com.liang.kotlinlearning

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

fun testExtension() {
    val l = mutableListOf(1, 2, 3)
    l.swap(0, 2) // “swap()”内部的“this”得到“l”的值
}