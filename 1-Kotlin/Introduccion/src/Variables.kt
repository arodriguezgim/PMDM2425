/**
 * VARIABLES EN KOTLIN
 */

fun main(){

    // Variables numéricas
    // Int es para valores entre -2,147,483,647 a 2,147,483,647
    val edad:Int = 42
    // Long -9,223,372,036,854,775,807 a 9,223,372,036,854,775,807
    val edad2:Long = 21
    // Float
    val ejemploFloat:Float = 30.5f
    // Double
    val ejemploDouble:Double = 3241.653865443

    /**
     * Variable Alfanuméricas
     */
    //Char - Almacenan un carácter y han de ir siemre entre comillas simples
    val charExample:Char = 'e'
    val charExample2:Char = '2'
    val charExample3:Char = '@'

    //String
    val stringExample:String = "Esta clase de DAM mola un huevo"

    /**
     * Variables Booleanas
     */
    val booleanExample:Boolean = true
    val booleanExample2:Boolean = false

    // Trabajamos con variables en Kotlin

    var numero1 = 43
    var numero2 = 23

    print("Suma: ")
    println(numero1 + numero2)

    print("Resta: ")
    println(numero1 - numero2)

    print("Multiplicar: ")
    println(numero1 * numero2)

    print("Dividir: ")
    println(numero1 / numero2)

    print("El módulo (resto): ")
    println(numero1 % numero2)
    println("---------------------------------")

    // ¿Qué pasa si operamos con variables diferentes?
    var a:Int = 5
    var b:Float = 10.5f

    print("Suma: ")
    var resultado = a + b
    print(resultado)
    println("---------------------------------")

    // Concatenación
    var introduccion = "El resultado de"
    var plus = "sumar"
    var primerNumero = 43
    var segundoNumero = 19

    println("$introduccion $plus $primerNumero más $segundoNumero es ${primerNumero + segundoNumero}")


}
















