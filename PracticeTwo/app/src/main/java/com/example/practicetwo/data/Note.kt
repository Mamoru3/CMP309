package com.example.practicetwo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This data class represents a table row in the database.
 * @Entity tells Room to create a table "notes".
 */
@Entity(tableName = "notes")
data class Note(
    /**
     * @PrimaryKey(autoGenerate = true) means the id column will
     * automatically increment for new rows.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // title and content are just normal columns in the "notes" table.
    val title: String,
    val content: String
)
