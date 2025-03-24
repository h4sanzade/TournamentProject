package com.materialdesign.tournamentproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TournamentAdapter(private var tournaments: List<Tournament>) :
    RecyclerView.Adapter<TournamentAdapter.TournamentViewHolder>() {

    class TournamentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTournamentName: TextView = itemView.findViewById(R.id.tvTournamentName)
        val tvTournamentDate: TextView = itemView.findViewById(R.id.tvTournamentDate)
        val tvTournamentType: TextView = itemView.findViewById(R.id.tvTournamentType)
        val btnTeams: Button = itemView.findViewById(R.id.btnTeams)
        val btnMatches: Button = itemView.findViewById(R.id.btnMatches)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tournament, parent, false)
        return TournamentViewHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentViewHolder, position: Int) {
        val tournament = tournaments[position]

        holder.tvTournamentName.text = tournament.name
        holder.tvTournamentDate.text = tournament.dateRange
        holder.tvTournamentType.text = tournament.type


        holder.btnTeams.setOnClickListener {
            Toast.makeText(holder.itemView.context,
                "View teams for ${tournament.name}",
                Toast.LENGTH_SHORT).show()
            // TODO: Navigate to teams screen for this tournament
        }

        holder.btnMatches.setOnClickListener {
            Toast.makeText(holder.itemView.context,
                "View matches for ${tournament.name}",
                Toast.LENGTH_SHORT).show()
            // TODO: Navigate to matches screen for this tournament
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,
                "Tournament details: ${tournament.name}",
                Toast.LENGTH_SHORT).show()
            // TODO: Navigate to tournament details screen
        }
    }

    override fun getItemCount() = tournaments.size

    fun updateData(newTournaments: List<Tournament>) {
        tournaments = newTournaments
        notifyDataSetChanged()
    }
}