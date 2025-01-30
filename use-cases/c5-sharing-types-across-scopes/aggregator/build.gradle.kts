//plugins {
//    id("org.springframework.boot") version "3.3.1"
//}
group = "com.example"
version = "1.0.0"

plugins {
    java
    id("scoped-data-project-plugin")
}

dependencies {
    implementation ("api-build:api:1.0")
    implementation("org.apache.commons:commons-lang3:3.13.0")
}
