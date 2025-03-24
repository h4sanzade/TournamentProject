package com.materialdesign.tournamentproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(private var teams: List<Team>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTeamName: TextView = itemView.findViewById(R.id.tvTeamName)
        val tvMembersCount: TextView = itemView.findViewById(R.id.tvMembersCount)
        val tvCoachName: TextView = itemView.findViewById(R.id.tvCoachName)
        val btnMembers: Button = itemView.findViewById(R.id.btnMembers)
        val btnStats: Button = itemView.findViewById(R.id.btnStats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]

        holder.tvTeamName.text = team.name
        holder.tvMembersCount.text = "${team.members} Members"
        holder.tvCoachName.text = "Coach: ${team.coach}"

        holder.btnMembers.setOnClickListener {
            Toast.makeText(holder.itemView.context,
                "View members of ${team.name}",
                Toast.LENGTH_SHORT).show()

        }

        holder.btnStats.setOnClickListener {
            Toast.makeText(holder.itemView.context,
                "View stats for ${team.name}",
                Toast.LENGTH_SHORT).show()

        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,
                "Team details: ${team.name}",
                Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount() = teams.size

    fun updateData(newTeams: List<Team>) {
        teams = newTeams
        notifyDataSetChanged()
    }
}