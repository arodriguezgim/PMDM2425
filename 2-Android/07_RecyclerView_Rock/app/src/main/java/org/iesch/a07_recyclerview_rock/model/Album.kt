package org.iesch.a07_recyclerview_rock.model

// 1 - La hacemos data class, esto hace que nuestra clase necesite al menos un parámetro por defecto
// Nos permite crear un modelo de datos super sencillo, ya que esta clase es más inteligente y ya tiene los getters y los setters definidos
data class Album(
    val titulo:String,
    val autor: String,
    val anio: Int,
    val portada: String
    )
