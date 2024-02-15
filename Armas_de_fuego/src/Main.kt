fun main() {
    // Crear instancias de cada tipo de arma con configuraciones específicas
    val armas = listOf(
        Pistola(municion = 10, tipoDeMunicion = "9mm", danio = 3, radio = Radio.REDUCIDO),
        Rifle(municion = 15, tipoDeMunicion = "7.62mm", danio = 7, radio = Radio.CORTO),
        Bazooka(municion = 5, tipoDeMunicion = "RPG", danio = 20, radio = Radio.ENORME)
    )

    // Mostrar la munición extra total disponible para todas las armas
    println("\nMunición extra = ${ArmaDeFuego.cantidadMunicionExtra}... para todas las armas de fuego.\n")

    // Crear una lista de pares (Arma, Número de disparos) de forma aleatoria
    val disparos = (1..12).map { armas.random() to (1..3).random() }

    // Recorrer la lista de disparos y procesar cada uno
    disparos.forEachIndexed { _, (arma, numDisparos) ->
        repeat(numDisparos) {
            println(arma.dispara())
        }
        // Mostrar información de la arma después de disparar
        println(arma)
        println() // Espacio entre cada arma para mejor legibilidad
    }
}
