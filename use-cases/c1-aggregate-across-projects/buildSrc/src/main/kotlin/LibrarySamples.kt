import java.io.Serializable

data class LibrarySamples(
    val library: String,
    val samples: List<LibrarySample> = emptyList()
) : Serializable

data class LibrarySample(
    val name: String,
    val code: String
) : Serializable