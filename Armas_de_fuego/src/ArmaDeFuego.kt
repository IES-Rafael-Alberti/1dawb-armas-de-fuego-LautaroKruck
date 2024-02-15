import kotlin.random.Random

abstract class ArmaDeFuego (
    private val nombre: String,
    private var municion: Int,
    private var municionARestar: Int,
    private val tipoDeMunicion: String)

{
    abstract val radio: Radio
    abstract val danio: Int

    companion object{
        var cantidadMunicionExtra = Random.nextInt(5,16)
    }

    init {
        require(nombre.isNotEmpty()) { "El nombre no puede estar vacío." }
        require(nombre.isNotBlank()) { "El nombre no puede estar en blanco." }
        require(municion >= 0) { "La municion no puede ser negativa." }
        require(municionARestar > 0) { "La municionARestar no puede ser negativa." }
        require(tipoDeMunicion.isNotEmpty()) { "El nombre no puede estar vacío." }
        require(tipoDeMunicion.isNotBlank()) { "El nombre no puede estar en blanco." }

    }

    fun dispara() {
        if (municion < municionARestar) {
            recarga()
            if (municion < municionARestar) {
                println("No hay suficiente munición para disparar.")
                return
            }
        }
        municion -= municionARestar
        println("${nombre.uppercase()} dispara. Munición restante: $municion")
    }

    fun recarga() {
        val municionARecargar = if (cantidadMunicionExtra >= municionARestar * 2) municionARestar * 2 else municionARestar
        if (cantidadMunicionExtra >= municionARecargar) {
            municion += municionARecargar
            cantidadMunicionExtra -= municionARecargar
            println("${nombre.uppercase()} se ha recargado. Munición actual: $municion")
        } else {
            println("No hay suficiente munición extra para recargar.")
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de munición: $tipoDeMunicion, Daño: $danio, Radio: $radio"
    }
}