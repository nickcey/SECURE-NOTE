package com.example.calculatrice

import org.junit.Test
import org.junit.Assert.*

class ProcessListTest {

    // La fonction à tester
    fun processList(
        numbers: List<Int>,
        predicate: (Int) -> Boolean
    ): List<Int> {
        val resultat = mutableListOf<Int>()
        for (nombre in numbers) {
            if (predicate(nombre)) {
                resultat.add(nombre)
            }
        }
        return resultat
    }

    @Test
    fun testNombresPairs() {
        val nombres = listOf(1, 2, 3, 4, 5, 6)
        val resultat = processList(nombres) { it % 2 == 0 }

        println("Test des nombres pairs: $resultat")
        assertEquals(listOf(2, 4, 6), resultat)
    }

    @Test
    fun testNombresImpairs() {
        val nombres = listOf(1, 2, 3, 4, 5, 6)
        val resultat = processList(nombres) { it % 2 != 0 }

        println("Test des nombres impairs: $resultat")
        assertEquals(listOf(1, 3, 5), resultat)
    }
}