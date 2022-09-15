package com.example.ecrecycler.ui

val numbers = arrayOf(2, 6, 2, 1, 3, 5, 5, 6, 3, 1, 1, 5, 1)

fun main() {
    println("El numero que se repite en numero impar de veces es ${numerorRepetido(numbers)}")
}

fun numerorRepetido(array: Array<Int>): Int {
    for (i in array.indices) {
        var contador = 0
        for (j in array) {
            if (array[i] == j) {
                contador += 1
            }
        }
        if (contador % 2 == 1) {
            return array[i]
        }
    }
    return -1
}
