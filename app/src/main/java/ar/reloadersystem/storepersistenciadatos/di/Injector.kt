package ar.reloadersystem.storepersistenciadatos.di

import ar.reloadersystem.storepersistenciadatos.AppExecutors
import javax.sql.DataSource

object Injector {

    private val appExecutors: AppExecutors = AppExecutors()
    private lateinit var  dataSource:DataSource
    //private lateinit var  noteRepository:NoteRepository

}