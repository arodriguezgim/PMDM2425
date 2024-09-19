fun main(){
    //getMonth(20)

    //getSemester(13)

    resultado(12.4f)
}

fun getMonth(month: Int){
    when (month) {
        1 -> print("Enero")
        2 -> print("Febrero")
        3 -> print("Marzo")
        4 -> print("Enero")
        5 -> print("Enero")
        6 -> print("Enero")
        7 -> print("Enero")
        8 -> print("Enero")
        9 -> print("Enero")
        10 -> print("Enero")
        11 -> print("Enero")
        12 -> print("Enero")
        else -> println("No corresponde a ningún mes del año")
    }
}
fun getTrimester(month: Int){
    when (month) {
        1, 2, 3 -> print("Es el primer trimeste")
        4, 5, 6 -> print("Es el segundo trimeste")
        7, 8, 9 -> print("Es el tercer trimeste")
        else -> println("No corresponde a ningún mes disponible")
    }
}

fun getSemester(month: Int){
    when (month) {
        in 1..6 -> print("Es el primer semestre")
        in 7..12 -> print("Es el segundo semestre")
        !in 1..12 -> println("No corresponde a ningún semestre")
    }
}

fun resultado(valor: Any){
    when (valor){
        is Int -> println("Es un Int")
        is String -> println("Es un String")
        is Boolean -> println("Es un Booleano")
        else -> println("No sabemos que es")
    }
}
