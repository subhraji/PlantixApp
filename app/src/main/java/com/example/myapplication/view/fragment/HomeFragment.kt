package com.example.myapplication.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.helper.gone
import com.example.myapplication.helper.visible
import com.example.myapplication.model.pojo.Row
import com.example.myapplication.model.repository.Outcome
import com.example.myapplication.view.adapter.AboutCanadaListAdapter
import com.example.myapplication.viewmodel.AboutCanadaViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val aboutCanadaViewModel: AboutCanadaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        about_canada_progress_bar.gone()
        getProfile()
    }

    private fun getProfile(){
        about_canada_progress_bar.visible()
        aboutCanadaViewModel.getAboutCanada().observe(viewLifecycleOwner, { outcome ->
            about_canada_progress_bar.gone()
            when(outcome){
                is Outcome.Success ->{
                    if (outcome.data.rows != null){
                        fillRecyclerView(outcome.data.rows)
                    }else{
                        Toast.makeText(activity,"error !!!", Toast.LENGTH_SHORT).show()
                    }
                }
                is Outcome.Failure<*> ->{
                    Toast.makeText(activity,outcome.e.message, Toast.LENGTH_SHORT).show()
                    outcome.e.printStackTrace()
                    Log.i("status",outcome.e.cause.toString())
                }
            }
        })
    }

    private fun fillRecyclerView(list: List<Row>) {
        val gridLayoutManager = GridLayoutManager(activity, 2)
        about_canada_recycler.apply {
            layoutManager = gridLayoutManager
            setHasFixedSize(true)
            isFocusable = false
            adapter = AboutCanadaListAdapter(list,requireActivity())
        }
    }

}