package com.example.a16_room_db.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// 2 UserDao contiene los metodos para acceder a nuestra BBDD
// Room usa esta interfaz para generar automáticamente el código necesario para realizar operaciones en la base de datos.
@Dao
interface UserDao {

    // Esta anotación indica que este método se usará para insertar datos en la tabla.
    @Insert(onConflict = OnConflictStrategy.IGNORE)  // Si esta el conflicto se ignora y no se insertará
    suspend fun addUser(user: User)

    @Query("SELECT * FROM users_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}