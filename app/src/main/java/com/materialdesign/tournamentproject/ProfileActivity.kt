package com.materialdesign.tournamentproject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupViews()
        setupBottomNavigation()
        loadProfileData()
    }

    private fun setupViews() {
        val btnEditProfile = findViewById<Button>(R.id.btnEditProfile)
        val btnMyTournaments = findViewById<Button>(R.id.btnMyTournaments)
        val btnMyTeams = findViewById<Button>(R.id.btnMyTeams)

        btnEditProfile.setOnClickListener {
            Toast.makeText(this, "Edit profile clicked", Toast.LENGTH_SHORT).show()

        }

        btnMyTournaments.setOnClickListener {
            Toast.makeText(this, "My tournaments clicked", Toast.LENGTH_SHORT).show()

        }

        btnMyTeams.setOnClickListener {
            Toast.makeText(this, "My teams clicked", Toast.LENGTH_SHORT).show()

        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_profile

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_tournaments -> {
                    startActivity(MainActivity.createIntent(this))
                    finish()
                    true
                }
                R.id.nav_teams -> {
                    startActivity(TeamsActivity.createIntent(this))
                    finish()
                    true
                }
                R.id.nav_profile -> {

                    true
                }
                else -> false
            }
        }
    }

    private fun loadProfileData() {

        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val tvMemberSince = findViewById<TextView>(R.id.tvMemberSince)

        tvUserName.text = "Huseyn Hasanzade"
        tvUserEmail.text = "h4sanzade@gmail.com"
        tvMemberSince.text = "Member since: Jan 2024"
    }

    companion object {
        fun createIntent(context: android.content.Context) = android.content.Intent(context, ProfileActivity::class.java)
    }
}