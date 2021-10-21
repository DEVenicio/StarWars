//package com.venicio.starwars.data.db.dao
//
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.venicio.starwars.data.db.RemoteKeys
//
//
//interface RemoteKeysDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(remoteKey: List<RemoteKeys>)
//
//    @Query("SELECT * FROM remote_keys WHERE peopleId = :peopleId")
//    suspend fun remoteKeysPeopleId(peopleId: Long) : RemoteKeys?
//
//    @Query("DELETE FROM remote_keys")
//    suspend fun clearRemoteKeys()
//}