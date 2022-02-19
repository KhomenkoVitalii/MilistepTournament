package com.milistep.competitive.navigation

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.milistep.competitive.R

class UserInfoFragment : Fragment() {
    lateinit var acct: GoogleSignInAccount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        acct = GoogleSignIn.getLastSignedInAccount(activity!!)!!
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_info, container, false)

        val personName = acct.displayName
        val personFamilyName = acct.familyName
        val personEmail = acct.email
        val personPhoto: Uri? = acct.photoUrl


        view.findViewById<TextView>(R.id.user_name).text = "$personName $personFamilyName"
        view.findViewById<TextView>(R.id.user_email).text = personEmail
        view.findViewById<ImageView>(R.id.user_photo).setImageURI(personPhoto)


        return view
    }
}