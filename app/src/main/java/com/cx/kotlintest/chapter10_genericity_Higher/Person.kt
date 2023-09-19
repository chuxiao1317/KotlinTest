package com.cx.kotlintest.chapter10_genericity_Higher

open class Person(var name: String, var age: Int) {
    class Student(name: String, age: Int) : Person(name, age)
    class Teacher(name: String, age: Int) : Person(name, age)
}