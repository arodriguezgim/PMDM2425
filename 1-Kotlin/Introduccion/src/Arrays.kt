fun main(){
    val weekdays = arrayOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo" )

    if (weekdays.size >= 7){
        println(weekdays.get(6))
    } else {
        println("No hay tantos parametros en el array")
    }

    weekdays[5] = "Sabadete"

    println(weekdays[5])

    weekdays.set(0, "Lunes de mierda")
    println(weekdays[0])
    println("----------------------------")
    // Recorremos los Arrays
    for (day in weekdays){
        println(day)
    }
    println("----------------------------")
    for ( (posicion, dia) in weekdays.withIndex()){
        println("El dia ${posicion +1} de la semana es $dia")
    }
}