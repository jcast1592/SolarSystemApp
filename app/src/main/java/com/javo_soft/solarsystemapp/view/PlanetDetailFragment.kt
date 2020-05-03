package com.javo_soft.solarsystemapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.javo_soft.solarsystemapp.R
import com.javo_soft.solarsystemapp.viewmodel.PlanetDetailViewModel
import kotlinx.android.synthetic.main.fragment_planet_detail.*

/**
 * A simple [Fragment] subclass.
 */
class PlanetDetailFragment : Fragment() {

    private lateinit var viewModel: PlanetDetailViewModel
    private var planetId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlanetDetailViewModel::class.java)
        viewModel.fetch()
        arguments?.let {
            planetId = PlanetDetailFragmentArgs.fromBundle(it).planetId
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.planetLiveData.observe(viewLifecycleOwner, Observer { planet ->
            planet?.let {
                planet_name.text = it.name
                planet_description.text = it.description
                planet_satellite.text = it.satellites.toString()
                planet_radius.text = it.radius.toString()
            }

        })
    }

}
