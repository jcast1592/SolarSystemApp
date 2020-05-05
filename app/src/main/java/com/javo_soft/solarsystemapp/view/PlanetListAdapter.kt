package com.javo_soft.solarsystemapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.javo_soft.solarsystemapp.R
import com.javo_soft.solarsystemapp.model.Planet
import kotlinx.android.synthetic.main.item_planet.view.*

class PlanetListAdapter(var planets: ArrayList<Planet>): RecyclerView.Adapter<PlanetListAdapter.PlanetViewHolder>() {

    fun updatePlanetList(newPlanetsList: List<Planet>) {
        planets.clear()
        planets.addAll(newPlanetsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder = PlanetViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planet, parent, false)
    )

    override fun getItemCount(): Int = planets.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.bind(planets[position])
    }

    class PlanetViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(planet: Planet) {
            itemView.apply {
                planet_name.text = planet.name
                planet_type.text = resources.getString(R.string.type_of_planet_text, planet.type)
                planet_orbital_period.text = resources.getString(R.string.orbital_period_in_days, planet.orbitalPeriod?.toString())
                setOnClickListener {
                    Navigation.findNavController(it).navigate(PlanetsListFragmentDirections.actionPlanetsListFragmentToPlanetDetailFragment())
                }
            }

        }
    }

}
