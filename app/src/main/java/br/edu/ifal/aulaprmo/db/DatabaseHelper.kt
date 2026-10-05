package br.edu.ifal.aulaprmo.db


import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import br.edu.ifal.aulaprmo.domain.Accommodation

@Database(
    version = 1, entities = [Accommodation::class]
)
abstract class DatabaseHelper : RoomDatabase() {

    // List DAOs
    abstract fun accommodationDao(): AccommodationDao

    // Database Connection
    // Static
    companion object {
        fun getInstance(context: Context): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "airbnb.db"
            ).build()
            // .allowMainThreadQueries().build()
        }
    }
}