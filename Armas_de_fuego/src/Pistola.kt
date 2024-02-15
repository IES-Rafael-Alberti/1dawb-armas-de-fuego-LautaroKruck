class Pistola(

    municion: Int ,
    tipoDeMunicion: String,
    override var danio: Int,
    override var radio: Radio)
    : ArmaDeFuego("Pistola", municion,1, tipoDeMunicion) {


    init{
        require(radio == Radio.REDUCIDO || radio == Radio.CORTO) {"ERROR RADIO"}
        require(danio in 1..5) {"ERROR DAÑO"}
    }
}