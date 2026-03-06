package com.example.calculatrice

import org.junit.Test
import org.junit.Assert.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Locale

data class Person(val name: String, val age: Int)

class Exercise3Test {

    @Test
    fun testAverageAge() {
        // ÉTAPE 1 : Données fournies
        val people = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 35),
            Person("Anna", 22),
            Person("Ben", 28)
        )

        // ÉTAPE 2 : Filtrer les personnes dont le nom commence par 'A' ou 'B'
        val filteredPeople = people.filter { person ->
            person.name.startsWith('A') || person.name.startsWith('B')
        }
        println("Étape 2 - Personnes filtrées : ${filteredPeople.map { it.name }}")

        // ÉTAPE 3 : Extraire les âges
        val ages = filteredPeople.map { it.age }
        println("Étape 3 - Âges extraits : $ages")

        // ÉTAPE 4 : Calculer la moyenne
        val average = if (ages.isNotEmpty()) ages.average() else 0.0
        println("Étape 4 - Moyenne brute : $average")

        // ÉTAPE 5 : Arrondir à 1 décimale et formater
        val roundedAverage = BigDecimal(average)
            .setScale(1, RoundingMode.HALF_UP)
            .toDouble()

        // ÉTAPE 6 : Formater l'affichage avec une décimale (Locale.US pour éviter la virgule)
        val formattedResult = String.format(Locale.US, "%.1f", roundedAverage)

        // ÉTAPE 7 : Imprimer le résultat final selon la consigne
        println("\n=== RÉSULTAT EXERCICE 3 ===")
        println("L'âge moyen des personnes dont le nom commence par A ou B est : $formattedResult")

        // Vérification du résultat
        assertEquals(26.3, roundedAverage, 0.01)
        println("✅ Test réussi !")
    }
}