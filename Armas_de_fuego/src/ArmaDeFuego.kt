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

    fun dispara(): String {
        if (municion >= municionARestar){
            municion -= municionARestar
            return "${nombre.uppercase()} dispara. Munición restante: $municion"
        }
    }

    fun recarga(){
        if (cantidadMunicionExtra >= municionARestar){
            cantidadMunicionExtra -= municionARestar
            municion += municionARestar
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de munición: $tipoDeMunicion, Daño: $danio, Radio: $radio"
    }
}