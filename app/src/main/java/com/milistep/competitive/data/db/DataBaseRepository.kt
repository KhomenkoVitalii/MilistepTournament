package com.milistep.competitive.data.db

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.milistep.competitive.MainActivity.Companion.TAG
import com.milistep.competitive.data.db.model.Hangout

class DataBaseRepository {
    var db = Firebase.firestore
    var hangouts = MutableLiveData<List<Hangout>>()

    fun addHangout(hangout: Hangout) {
        db.collection("hangout")
            .add(hangout.label)
            .addOnSuccessListener {
                Log.d(TAG, "Success!")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    fun getHangout(){
        db.collection("hangout")
            .get()
            .addOnSuccessListener { result ->
                hangouts.value = result.toObjects()
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}

