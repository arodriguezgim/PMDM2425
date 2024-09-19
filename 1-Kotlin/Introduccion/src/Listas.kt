fun main(){
    //Dos grande familias de Listas: Mutables y las Inmutables
    // Listas inmutables
    val readOnly: List<String> = listOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")

    readOnly.size //Muestra el tamaño de la lista
    readOnly.get(3) //Devuelve el valor enla posicion 3
    readOnly.first() //Devuelve el primer valor
    readOnly.last() // devuelve el ultimo valor
    println(readOnly)

    // Filtramos en listas
    val a = readOnly.filter { it == "Lunes" || it == "Jueves"}
    println(a)
    println("--------------------------")
    // Listas Mutables
    var mutableList : MutableList<String> = mutableListOf("Lunes","Martes","Miercoles")

    mutableList.addFirst("Jueves") //Añade al primer elemento

    mutableList.none() //Nos devuelve true si esta vacia lalista
    mutableList.firstOrNull() // Nos devolverá el primer campo, y si no hay nada null
    mutableList.elementAtOrNull(2) //El elemento del indice 2, si no hay devolvera un null
    mutableList.lastOrNull() //Saca el ultimo valor de la lista (si no hay null)

    mutableList.forEach {
        println(it)
    }







}