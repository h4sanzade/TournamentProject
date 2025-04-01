# Tournament Pro

Tournament Pro is a comprehensive Android application designed to help users manage sports tournaments, teams, and player profiles. The app provides an intuitive Material Design UI for creating and managing tournaments, tracking teams, and maintaining user profiles.

## Features

 Tournament Management
- View all tournaments with filtering options (All, Active, Upcoming, Completed)
- Tournament details including name, date range, and tournament type
- Access teams and matches for each tournament
- Create new tournaments with the floating action button

 Team Management
- Browse all teams with detailed information
- View team members count and coach information
- Access team statistics and member details
- Create new teams with the floating action button

 User Profile
- Personal profile management
- View membership details
- Quick access to user's tournaments and teams
- Profile editing functionality


 Tech Stack

- **Language**: Kotlin
- **UI Framework**: Android Material Design Components
- **Architecture**: Activity-based navigation with RecyclerViews for list displays
- **Navigation**: Bottom navigation bar for main screens
- **Layout**: ConstraintLayout with CardViews for modern UI

 Project Structure

```
com.materialdesign.tournamentproject/
├── activities/
│   ├── MainActivity.kt (Tournament list screen)
│   ├── TeamsActivity.kt (Teams list screen)
│   └── ProfileActivity.kt (User profile screen)
├── adapters/
│   ├── TournamentAdapter.kt (Adapter for tournament items)
│   └── TeamAdapter.kt (Adapter for team items)
├── models/
│   ├── Tournament.kt (Data class for tournament information)
│   └── Team.kt (Data class for team information)
└── layouts/
    ├── activity_main.xml (Tournament screen layout)
    ├── activity_teams.xml (Teams screen layout)
    ├── activity_profile.xml (Profile screen layout)
    ├── item_tournament.xml (Tournament list item layout)
    └── item_team.xml (Team list item layout)
```

## Implementation Details

 Bottom Navigation
The app uses Material Design's BottomNavigationView to navigate between the three main screens: Tournaments, Teams, and Profile.

 Tournament Filtering
The Tournament screen includes filter buttons to sort tournaments by status (All, Active, Upcoming, Completed).

 RecyclerView Implementation
Both Tournament and Team screens use RecyclerView with custom adapters to display items in a scrollable list with CardView items.

 Data Models
Simple data classes are used to represent:
- Tournament data (id, name, date range, type, status)
- Team data (id, name, members count, coach, founded date)

 Future Improvements

- Implement matches screen and functionality
- Add database integration with Room persistence library
- Implement user authentication
- Add tournament creation and editing screens
- Implement team member management
- Add statistics tracking for teams and players
- Implement search functionality



- [Material Design Components](https://material.io/develop/android)
- [CircleImageView by hdodenhof](https://github.com/hdodenhof/CircleImageView)
