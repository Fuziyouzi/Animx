package com.example.animex.data.source.models

import com.example.animex.core.Mapper
import com.example.animex.domain.models.AnimeAttributes

data class Attributes(
    val abbreviatedTitles: List<String>,
    val ageRating: String,
    val ageRatingGuide: String,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImage,
    val coverImageTopOffset: Int,
    val createdAt: String,
    val endDate: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val favoritesCount: Int,
    val nsfw: Boolean,
    val popularityRank: Int,
    val posterImage: PosterImage,
    val ratingFrequencies: RatingFrequencies,
    val ratingRank: Int,
    val showType: String,
    val slug: String,
    val startDate: String,
    val status: String,
    val subtype: String,
    val synopsis: String,
    val tba: String,
    val titles: Titles,
    val updatedAt: String,
    val userCount: Int,
    val youtubeVideoId: String
): Mapper<AnimeAttributes> {

    override fun to(): AnimeAttributes = AnimeAttributes(
        ageRating = ageRating,
        ageRatingGuide = ageRatingGuide,
        averageRating = averageRating,
        canonicalTitle = canonicalTitle,
        coverImage = coverImage.original,
        createdAt = createdAt,
        endDate = endDate,
        episodeCount = episodeCount,
        episodeLength = episodeLength,
        popularityRank = popularityRank,
        posterImage = posterImage.original,
        ratingRank = ratingRank,
        showType = showType,
        slug = slug,
        startDate = startDate,
        status = status,
        subtype = subtype,
        synopsis = synopsis,
        tba = tba,
        titles = titles.en,
        updatedAt = updatedAt,
        youtubeVideoId = youtubeVideoId
    )
}