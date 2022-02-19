package com.milistep.competitive

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.milistep.competitive.data.db.DataBaseRepository
import com.milistep.competitive.data.db.model.Hangout

class AppViewModel : ViewModel() {
    val readAllData: LiveData<List<Hangout>>
    private val db = DataBaseRepository()

    init {
        db.getHangout()
        readAllData = db.hangouts
    }

    fun addHangout(hangout: Hangout){
        db.addHangout(hangout)
    }
}