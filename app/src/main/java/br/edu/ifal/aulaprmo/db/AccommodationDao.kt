package br.edu.ifal.aulaprmo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import br.edu.ifal.aulaprmo.domain.Accommodation

@Dao
interface AccommodationDao {
    @Insert(onConflict = REPLACE)
    fun insertAll(accommodations: List<Accommodation>)

    @Insert
    fun insert(accommodation: Accommodation)

    @Query("SELECT * FROM Accommodation")
    suspend fun findAll(): List<Accommodation>

    @Query("SELECT * FROM Accommodation")
    suspend fun findAllSuspendFunction(): List<Accommodation>

}