

val projectState = extensions.getByType(com.example.projectdata.ProjectData::class.java)

// Add project-specific data
projectState.put("language", "Kotlin")
projectState.put("version", "1.0.0")
