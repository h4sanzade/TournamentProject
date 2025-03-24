package com.materialdesign.tournamentproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeamsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        setupViews()
        setupBottomNavigation()
        loadTeams()
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.recyclerTeams)
        recyclerView.layoutManager = LinearLayoutManager(this)
        teamAdapter = TeamAdapter(createSampleTeams())
        recyclerView.adapter = teamAdapter

        val fabAddTeam = findViewById<FloatingActionButton>(R.id.fabAddTeam)
        fabAddTeam.setOnClickListener {
            Toast.makeText(this, "Add new team", Toast.LENGTH_SHORT).show()

        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_teams

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_tournaments -> {
                    startActivity(MainActivity.createIntent(this))
                    finish()
                    true
                }
                R.id.nav_teams -> {

                    true
                }
                R.id.nav_profile -> {
                    startActivity(ProfileActivity.createIntent(this))
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun loadTeams() {
        teamAdapter.updateData(createSampleTeams())
    }

    private fun createSampleTeams(): List<Team> {
        return listOf(
            Team(
                id = 1,
                name = "Barcelona FC",
                members = 25,
                coach = "Joan Peñarroya",
                founded = "1899 "
            ),
            Team(
                id = 2,
                name = "Real Madrid",
                members = 25,
                coach = "Chus Mateo",
                founded = "1902"
            ),
            Team(
                id = 3,
                name = "Manchester United",
                members = 27,
                coach = "Rúben Amorim",
                founded = "1878"
            )
        )
    }

    companion object {
        fun createIntent(context: android.content.Context) = android.content.Intent(context, TeamsActivity::class.java)
    }
}