package br.edu.ifal.aulaprmo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifal.aulaprmo.domain.TourPackage

@Database(
    version = 1,
    entities = [TourPackage::class]
)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun tourPackageDao() : TourPackageDao

    // Static do Kotlin
    companion object {
        fun getInstance(context: Context): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "tourPackage.db"
            ).allowMainThreadQueries()
                .build()
        }
    }


}