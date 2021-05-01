package com.sitare.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sitare.recyclerview.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PersonAdapter
    private lateinit var personList: ArrayList<Person>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        //recycler view design, without data binding
        //binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //alternative to linear layout manager
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        personList = ArrayList()
        val p1 = Person(1, "Alice", "+909999999")
        val p2 = Person(2, "Bob", "+909999999")
        val p3 = Person(3, "Charlie", "+909999999")
        val p4 = Person(3, "Daniel", "+909999999")
        personList.add(p1)
        personList.add(p2)
        personList.add(p3)
        personList.add(p4)

        adapter = PersonAdapter(requireContext(), personList)
        //added for data binding
        binding.personAdapter = adapter

        //without data binding
        //binding.recyclerView.adapter = adapter

        return binding.root
    }

}