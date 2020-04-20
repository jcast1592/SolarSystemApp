package com.javo_soft.solarsystemapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javo_soft.solarsystemapp.R
import com.javo_soft.solarsystemapp.model.Planet
import kotlinx.android.synthetic.main.item_planet.view.*

class PlanetListAdapter(var planets: ArrayList<Planet>): RecyclerView.Adapter<PlanetListAdapter.PlanetViewHolder>() {

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
                planet_type.text = planet.type
                planet_orbital_period.text = planet.orbitalPeriod?.toString()
            }

        }
    }

}