package com.example.a16_room_db.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 3 UserDatabase Contiene el titular de la base de datos. Esta clase extiende RoomDatabase y proporciona el punto de acceso principal para la conexión a los datos persistentes.
@Database(entities = [User::class], version = 1, exportSchema = false)
/*
@Database: Define esta clase como la base de datos de Room.
entities = [User::class]: Especifica que User es una entidad en la base de datos. Pueden incluirse múltiples entidades en esta lista si tienes más tablas.
version = 1: Establece la versión de la base de datos. Es importante porque Room utiliza este valor para manejar las migraciones entre versiones de la base de datos.
exportSchema = false: Si es true, Room generará un archivo de esquema de base de datos en el proyecto.
Esto suele ser útil para el control de versiones y migraciones, pero para proyectos básicos puede omitirse */
abstract class UserDatabase : RoomDatabase() {


    /*Room usa este método para obtener el UserDao y acceder a los métodos que hemos definido (como addUser y readAllData). Este método actúa como un "getter" para el DAO.*/
    abstract fun userDao(): UserDao

    companion object{

        @Volatile  //Asegura que cualquier cambio en INSTANCE sea visible para todos los hilos de la aplicación. Esto es importante en aplicaciones multihilo.
        private var INSTANCE: UserDatabase? = null
        //Este método se utiliza para obtener una instancia de UserDatabase
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "users_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
        /* Este método se utiliza para obtener una instancia de UserDatabase. Implementa el patrón Singleton para asegurarse de que solo haya una única instancia de la base de datos en toda la aplicación.
synchronized(this): Esta sincronización evita que dos hilos creen instancias al mismo tiempo.
Room.databaseBuilder(...): Este método construye la base de datos:

    context.applicationContext: Pasa el contexto de la aplicación para evitar fugas de memoria.
    UserDatabase::class.java: Especifica que esta es la clase de base de datos.
    "users_database": Nombre de la base de datos. Room usará este nombre para identificar el archivo de la base de datos.*/
    }
}