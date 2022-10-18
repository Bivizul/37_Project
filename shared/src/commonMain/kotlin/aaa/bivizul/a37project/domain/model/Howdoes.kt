package aaa.bivizul.a37project.domain.model

@kotlinx.serialization.Serializable
data class Howdoes(
    val id: Int,
    val howdoetit: String,
    val howdoedesc: String,
    val howdoein: List<Howdoein>,
)