//package com.venicio.starwars.data.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.venicio.starwars.data.db.dao.PeopleDao
//import com.venicio.starwars.data.db.dao.RemoteKeysDao
//
//
//@Database(entities = [PeopleEntity::class, RemoteKeys::class], version = 1)
//
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun peopleDao(): PeopleDao
//    abstract fun remoteKeysDao(): RemoteKeysDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}