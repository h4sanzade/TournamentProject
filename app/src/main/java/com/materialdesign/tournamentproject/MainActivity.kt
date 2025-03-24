package com.materialdesign.tournamentproject
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tournamentAdapter: TournamentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupBottomNavigation()
        loadTournaments()
    }

    private fun setupViews() {

        recyclerView = findViewById(R.id.recyclerTournaments)
        recyclerView.layoutManager = LinearLayoutManager(this)
        tournamentAdapter = TournamentAdapter(createSampleTournaments())
        recyclerView.adapter = tournamentAdapter


        val btnAll = findViewById<MaterialButton>(R.id.btnAll)
        val btnActive = findViewById<MaterialButton>(R.id.btnActive)
        val btnUpcoming = findViewById<MaterialButton>(R.id.btnUpcoming)
        val btnCompleted = findViewById<MaterialButton>(R.id.btnCompleted)


        btnAll.setOnClickListener { filterTournaments("all") }
        btnActive.setOnClickListener { filterTournaments("active") }
        btnUpcoming.setOnClickListener { filterTournaments("upcoming") }
        btnCompleted.setOnClickListener { filterTournaments("completed") }


        val fabAddTournament = findViewById<FloatingActionButton>(R.id.fabAddTournament)
        fabAddTournament.setOnClickListener {
            Toast.makeText(this, "Add new tournament", Toast.LENGTH_SHORT).show()
            // TODO: Open add tournament screen
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_tournaments -> {

                    true
                }
                R.id.nav_teams -> {

                    Toast.makeText(this, "Teams section clicked", Toast.LENGTH_SHORT).show()
                    // TODO: Navigate to teams screen
                    true
                }
                R.id.nav_profile -> {

                    Toast.makeText(this, "Profile section clicked", Toast.LENGTH_SHORT).show()
                    // TODO: Navigate to profile screen
                    true
                }
                else -> false
            }
        }
    }

    private fun loadTournaments() {

        tournamentAdapter.updateData(createSampleTournaments())
    }

    private fun filterTournaments(filter: String) {

        val filteredList = when (filter) {
            "all" -> createSampleTournaments()
            "active" -> createSampleTournaments().filter { it.status == "Active" }
            "upcoming" -> createSampleTournaments().filter { it.status == "Upcoming" }
            "completed" -> createSampleTournaments().filter { it.status == "Completed" }
            else -> createSampleTournaments()
        }
        tournamentAdapter.updateData(filteredList)
    }

    private fun createSampleTournaments(): List<Tournament> {
        return listOf(
            Tournament(
                id = 1,
                name = "2025 Champions League",
                dateRange = "Jan 10 - Feb 15, 2025",
                type = "League",
                status = "Active"
            ),
            Tournament(
                id = 2,
                name = "Winter Cup 2025",
                dateRange = "Mar 1 - Apr 20, 2025",
                type = "Elimination",
                status = "Upcoming"
            )
        )
    }
}