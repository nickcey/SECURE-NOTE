package com.example.calculatrice

import org.junit.Test
import org.junit.Assert.*

class Exercice2Test {

    @Test
    fun testLongWords() {
        val words = listOf("apple", "cat", "banana", "dog", "elephant")

        val wordLengthMap = words.associateWith { it.length }

        val result = wordLengthMap
            .filter { (_, length) -> length > 4 }

        // CORRECTION : elephant a 8 lettres, pas 7
        assertEquals(3, result.size)
        assertEquals(5, result["apple"])      // apple = 5 lettres
        assertEquals(6, result["banana"])     // banana = 6 lettres
        assertEquals(8, result["elephant"])   // elephant = 8 lettres !!!

        // Affichage
        result.forEach { (word, length) ->
            println("$word has length $length")
        }
    }
}