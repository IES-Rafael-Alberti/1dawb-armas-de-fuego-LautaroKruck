class Rifle(
    municion: Int ,
    tipoDeMunicion: String,
    override var danio: Int,
    override var radio: Radio)
    : ArmaDeFuego("Rifle", municion,2, tipoDeMunicion) {


        init{
            require(radio == Radio.CORTO || radio == Radio.INTERMEDIO) {"ERROR RADIO"}
            require(danio in 5..10) {"ERROR DAÑO"}
        }
}