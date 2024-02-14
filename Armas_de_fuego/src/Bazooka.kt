class Bazooka (
    municion: Int ,
    tipoDeMunicion: String,
    override var danio: Int,
    override var radio: Radio)
    : ArmaDeFuego("Bazooka", municion,3, tipoDeMunicion) {


    init{
        require(radio == Radio.INTERMEDIO || radio == Radio.ENORME) {"ERROR RADIO"}
        require(danio in 10..30) {"ERROR DAÑO"}
    }
}