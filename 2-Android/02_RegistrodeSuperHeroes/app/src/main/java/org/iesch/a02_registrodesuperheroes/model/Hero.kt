package org.iesch.a02_registrodesuperheroes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// 15- Creamos la clase Hero yañadimos los pará,metros necesarios
//19 Hacemos el objeto Hero parcelable
@Parcelize
class Hero( val name: String, val alterEgo:String, val bio:String, val power: Float) : Parcelable