package com.example.campuseventexplorer

data class CampusEvent(
    val id: Long,
    val title: String,
    val category: String,
    val location: String,
    val time: String,
    val description: String
)

val campusEvents = listOf(
    CampusEvent(
        id = 1L,
        title = "Mobile Development Meetup",
        category = "Technology",
        location = "CAS 214",
        time = "Tuesday, October 13, 6:30 PM",
        description = "Meet other students interested in mobile development. Discuss Android, Kotlin, app design, and current projects."
    ),
    CampusEvent(
        id = 2L,
        title = "Career Fair",
        category = "Career",
        location = "George Sherman Union",
        time = "Wednesday, October 14, 11:00 AM",
        description = "Explore internship and full-time opportunities, meet recruiters, and learn about different career paths."
    ),
    CampusEvent(
        id = 3L,
        title = "Photography Walk",
        category = "Arts",
        location = "BU Beach",
        time = "Thursday, October 15, 4:00 PM",
        description = "Join fellow students for a relaxed photography walk. Bring a camera or use your phone to capture campus life."
    ),
    CampusEvent(
        id = 4L,
        title = "Coding Competition",
        category = "Technology",
        location = "Engineering Research Building",
        time = "Friday, October 16, 5:00 PM",
        description = "Work individually or with friends to solve programming challenges and practice problem-solving skills."
    ),
    CampusEvent(
        id = 5L,
        title = "Yoga on Campus",
        category = "Wellness",
        location = "FitRec Studio",
        time = "Saturday, October 17, 10:00 AM",
        description = "Take a break from studying with a beginner-friendly yoga session focused on movement and relaxation."
    ),
    CampusEvent(
        id = 6L,
        title = "Research Poster Session",
        category = "Academic",
        location = "Metcalf Science Center",
        time = "Monday, October 19, 2:00 PM",
        description = "Discover student research projects, ask questions, and learn about ongoing work across academic disciplines."
    ),
    CampusEvent(
        id = 7L,
        title = "Board Game Night",
        category = "Social",
        location = "GSU Back Court",
        time = "Tuesday, October 20, 7:00 PM",
        description = "Meet other students for an informal evening of board games, conversation, and friendly competition."
    ),
    CampusEvent(
        id = 8L,
        title = "Sustainability Workshop",
        category = "Environment",
        location = "Photonics Center",
        time = "Wednesday, October 21, 3:30 PM",
        description = "Discuss practical ways to reduce waste, conserve resources, and make everyday campus life more sustainable."
    )
)