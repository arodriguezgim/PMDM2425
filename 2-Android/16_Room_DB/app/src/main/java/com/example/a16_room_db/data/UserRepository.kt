package com.example.a16_room_db.data

import androidx.lifecycle.LiveData

// 4 UserRepository no es parte de Room, su propósito es servir como intermediario entre el UserDao y el resto de la aplicación.
// es una práctica recomendada en la arquitectura de Android para manejar el acceso a los datos de una manera más limpia y organizada.


//UserRepository recibe una instancia de UserDao como parámetro en su constructor, lo cual permite que el repositorio acceda a los métodos del DAO.
class UserRepository(private val userDao: UserDao) {

    /*
    readAllData es una propiedad pública que expone los datos almacenados en la tabla users_table.
    Obtiene el LiveData<List<User>> de userDao.readAllData(), lo que significa que otras partes de la aplicación pueden observar los cambios en los datos.
    Cada vez que haya un cambio en la tabla, las vistas que observen readAllData se actualizarán automáticamente.
    */

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}

/*
Propósito de UserRepository en la Arquitectura

    Abstracción: UserRepository abstrae la fuente de datos, por lo que si en el futuro necesitas cambiar la implementación de almacenamiento de datos (por ejemplo, usar una API o cambiar de Room a otra tecnología de almacenamiento), solo tendrías que modificar el repositorio sin afectar el resto de la aplicación.
    Organización: Mejora la organización y mantiene el código relacionado con el acceso a datos en un solo lugar.
    Simplificación: Facilita la reutilización de datos y métodos de acceso a los datos, lo cual resulta útil en arquitecturas como MVVM (Modelo-Vista-ViewModel), en donde el ViewModel usa el repositorio para obtener los datos que necesita para las vistas.

 */