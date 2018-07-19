package com.liang.kotlinlearning

import org.junit.Test

class KotlinSyntaxExample {

    data class Course(val name: String, val score: Float?)
    data class Examination(val type: String, val courses: List<Course>?)
    data class Student(val name: String, val recentExamination: Examination?)

    @Test
    fun testExample2() {
        val feifei = getStudentByName("feifei")
        with(feifei?.recentExamination?.courses) {
            if (this == null || this.isEmpty()) {
                return println("学生: feifei;没有记录")
            }
            this.filter { course ->
                return@filter course.name == "Chinese" || course.name == "Math"
            }
                    .forEach { course ->
                        println("学生:${feifei!!.name};${course.name}:${course.score ?: "没有记录"}")
                    }
        }
    }

    @Test
    fun testExample1() {
        val feifei = getStudentByName("feifei")
        val courses = feifei?.recentExamination?.courses
        if (courses == null || courses.isEmpty()) {
            return println("学生: feifei;没有记录")
        } else {
            courses.filter { course ->
                        return@filter course.name == "Chinese" || course.name == "Math"
                    }
                    .forEach { course ->
                        println("学生:${feifei.name};${course.name}:${course.score ?: "没有记录"}")
                    }
        }
    }
    // 不加? 编译期间会报错

    private fun getStudentByName(name: String): Student? {
        val courses = listOf(Course("Chinese", null),
                Course("Math", 99f),
                Course("English", 30f))
        val random = Math.random()
        print("random->$random")
        return when {
            random > 0.7 -> Student(name, Examination("midterm", courses))
            random > 0.4 -> Student(name, Examination("midterm", null))
            else -> null
        }
    }
}