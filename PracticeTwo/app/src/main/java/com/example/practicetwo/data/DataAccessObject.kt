package com.example.practicetwo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * @Dao tells Room that this interface defines methods
 * for accessing the database (CRUD operations).
 */
@Dao
interface NoteDao {

    /**
     * @Insert automatically generates the code to insert
     * a Note into the database. OnConflictStrategy.REPLACE
     * means if the same primary key already exists, it will
     * overwrite that row with the new data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    /**
     * Use @Query for custom SQL queries. Here we retrieve
     * all notes (SELECT * FROM notes) sorted in descending order by id.
     * We return a Flow, so the UI can observe changes reactively.
     */
    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Note>>
}
