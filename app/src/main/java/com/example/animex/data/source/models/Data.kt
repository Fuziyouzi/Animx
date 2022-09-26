package com.example.animex.data.source.models

import com.example.animex.core.Mapper
import com.example.animex.domain.models.Anime

data class Data(
    val attributes: Attributes,
    val id: String,
    val links: Links,
    val relationships: Relationships,
    val type: String
): Mapper<Anime> {

    override fun to(): Anime = Anime(
        data = attributes.to(),
        id = id,
        type = type

    )
}