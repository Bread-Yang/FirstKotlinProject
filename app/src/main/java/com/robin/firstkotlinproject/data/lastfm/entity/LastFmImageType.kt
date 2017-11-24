package com.robin.firstkotlinproject.data.lastfm.entity

/**
 * Created by Robin Yang on 11/23/17.
 */
enum class LastFmImageType(val type: String) {

    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    EXTRALARGE("extralarge"),
    MEGA("mega");

    fun findByName(name: String): LastFmImageType? {
        return values().firstOrNull { it.type == name }
    }
}