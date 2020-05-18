package com.javo_soft.solarsystemapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Planet::class], version = 1)
abstract class PlanetDatabase: RoomDatabase() {

    abstract fun planetDao(): PlanetDao

    companion object {
        @Volatile private var instance: PlanetDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PlanetDatabase::class.java,
            "planetDatabase"
        ).build()
    }

}