package com.milistep.competitive.navigation

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milistep.competitive.AppViewModel
import com.milistep.competitive.R
import com.milistep.competitive.data.db.model.Hangout
import com.milistep.competitive.data.recyclerview.model.AppRecyclerAdapter

class ListFragment : Fragment() {
    lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = AppRecyclerAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { hangouts ->
            adapter.setData(hangouts)
        })

        view.findViewById<Button>(R.id.add_hangout_butt).setOnClickListener {
            viewModel.addHangout(Hangout("New Hangout"))
        }
        return view
    }
}