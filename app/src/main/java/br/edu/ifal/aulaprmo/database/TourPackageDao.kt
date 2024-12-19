package br.edu.ifal.aulaprmo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifal.aulaprmo.domain.TourPackage

@Dao
interface TourPackageDao {

    @Insert
    fun insert(tourPackage: TourPackage)

    @Query("SELECT * FROM TourPackage")
    fun findAll(): List<TourPackage>

    @Query("SELECT * FROM TourPackage WHERE id = :id")
    fun findById(id: Long): TourPackage?

}