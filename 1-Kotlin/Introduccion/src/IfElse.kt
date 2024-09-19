fun main(){
    var resultado = sumar(10, 20)

    if (resultado > 40){
        println("El resultado es mayor que 40")
    } else {
        println("El resultado es menor que 40")
    }
    // IF Anidados
    var animal = "perro"
    if (animal == "perro"){
        println("Es un perro Sanchez")
    } else if (animal == "gato"){
        println("Es un gato")
    } else if (animal == "pajaro"){
        println("Es un pajaro")
    } else {
        println("Es otro animal")
    }
    
}

fun sumar(a:Int, b:Int) : Int {
    return a + b
}