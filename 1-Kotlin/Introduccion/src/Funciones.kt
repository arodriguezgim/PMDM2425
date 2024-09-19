

fun main(){
    //showMyName( "Juan José")
    //showMyFirstName()
    //showMyAge()

    showMyInformation("Alberto", "Rodriguez", 43)
    println("-----------------------")
    var resultado = add(4,5)
    println(resultado)
}
// Parámetros de Entrada
fun showMyName(nombre: String){
    println("Me llamo $nombre")
}

fun showMyFirstName(){
    println("Mi apellido es Rodríguez")
}

fun showMyAge(){
    println("Tengo 43 años")
}

fun showMyInformation(nombre: String, apellido: String, edad:Int){
    println("Hola, me llamo $nombre $apellido, y tengo $edad años")
}
// Parámetros de Salida
fun add(numero1:Int, numero2:Int):Int {

    return numero1 + numero2
}