//package com.venicio.starwars.data.db.dao
//
//import androidx.paging.PagingSource
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.venicio.starwars.data.model.People
//
//@Dao
//interface PeopleDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(peoples: List<People>)
//
//    @Query(
//        "SELECT * FROM peoples WHERE"
//                + "name LIKE :queryString OR species LIKE :queryString OR homeworld LIKE :queryString"
//                + "ORDER BY name ASC")
//    fun peoplesByName(queryString: String) : PagingSource<Int, People>
//
//    @Query("DELETE FROM peoples")
//    suspend fun clearPeoples()
//
//}