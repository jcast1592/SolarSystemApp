package com.javo_soft.solarsystemapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.javo_soft.solarsystemapp.R
import com.javo_soft.solarsystemapp.viewmodel.PlanetsListViewModel
import kotlinx.android.synthetic.main.fragment_planets_list.*

/**
 * A simple [Fragment] subclass.
 */
class PlanetsListFragment : Fragment() {

    private lateinit var viewModel: PlanetsListViewModel
    private val planetsListAdapter = PlanetListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planets_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlanetsListViewModel::class.java)
        viewModel.refresh()

        planets_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = planetsListAdapter
        }

        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.planets.observe(viewLifecycleOwner, Observer { planets ->
            planets?.let {
                planets_list.visibility =View.VISIBLE
                planetsListAdapter.updatePlanetList(planets)
            }
        })

        viewModel.errorLoading.observe(viewLifecycleOwner, Observer { isError ->
            isError?.let {
                error_message.visibility = View.VISIBLE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading?.let {
                if (it) {
                    progress_bar.visibility = View.VISIBLE
                    error_message.visibility = View.GONE
                    planets_list.visibility = View.GONE
                } else {
                    progress_bar.visibility = View.GONE
                    error_message.visibility = View.VISIBLE
                    planets_list.visibility = View.VISIBLE
                }
            }
        })
    }

}
