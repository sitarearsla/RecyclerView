package com.sitare.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.sitare.recyclerview.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle : DetailFragmentArgs by navArgs()
        val incomingPerson = bundle.personName

       // binding.telephoneTextView.text = incomingPerson.telephone
       // binding.personNameTextView.text = incomingPerson.name

        //with data binding
        binding.person = incomingPerson

        return binding.root
    }
}