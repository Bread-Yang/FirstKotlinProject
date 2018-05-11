package com.robin.firstkotlinproject.data

import com.robin.firstkotlinproject.data.lastfm.LastFmService
import com.robin.firstkotlinproject.data.lastfm.entity.*
import com.robin.firstkotlinproject.data.mock.FakeCall
import com.robin.firstkotlinproject.data.repository.dataset.CloudAlbumDataSet
import com.robin.firstkotlinproject.domain.model.mapper.AlbumMapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

/**
 * Created by Robin Yang on 11/24/17.
 */
@RunWith(MockitoJUnitRunner::class)
class CloudAlbumDataSetTest {

    @Mock
    lateinit var lastFmService: LastFmService

    lateinit var cloudAlbumDataSet: CloudAlbumDataSet
    lateinit var lastFmResponse: LastFmResponse
    lateinit var knownAlbumDetail: LastFmAlbumDetail
    lateinit var unknownAlbumDetail: LastFmAlbumDetail
    lateinit var album: LastFmAlbum
    lateinit var artist: LastFmArtist
    lateinit var topAlbums: LastFmTopAlbums
    lateinit var albums: List<LastFmAlbum>

    private val albumMapper = AlbumMapper()
    private val albumMbid = "album mbid"
    private val artistMbid: String = "artist mbid"
    private val artistName: String = "artist name"

    @Before
    fun setup() {
        cloudAlbumDataSet = CloudAlbumDataSet(lastFmService)

        artist = LastFmArtist(artistName, artistMbid, "artist url", emptyList(), null, null)
        album = LastFmAlbum("album name", albumMbid, "album url",
                artist, emptyList(), LastFmTracklist(emptyList()))
        knownAlbumDetail = LastFmAlbumDetail("album name", albumMbid, "album url", "album artist",
                "album release date", emptyList(), LastFmTracklist(emptyList()))
        unknownAlbumDetail = LastFmAlbumDetail("", null, "", "", "", emptyList(), LastFmTracklist(emptyList()))

        albums = listOf(album)
        topAlbums = LastFmTopAlbums(listOf(album))

        lastFmResponse = LastFmResponse(LastFmResult(LastFmArtistMatches(emptyList())), artist,
                topAlbums, LastFmArtistList(emptyList()), knownAlbumDetail)

        `when`(lastFmService.requestAlbum(albumMbid)).thenReturn(FakeCall(Response.success(lastFmResponse), null))
        `when`(lastFmService.requestAlbums(anyString(), anyString())).thenReturn(FakeCall(Response.success(lastFmResponse), null))
    }

    @Test
    fun testRequestAlbum_knownAlbum() {
        // when
        val album = cloudAlbumDataSet.requestAlbum(albumMbid)

        // then
        verify(lastFmService).requestAlbum(albumMbid)
        assertEquals(albumMapper.transform(lastFmResponse.album), album)
    }

    @Test
    fun testRequestAlbum_unknownAlbum() {
        // Given
        val unknownAlbumResponse = LastFmResponse(LastFmResult(LastFmArtistMatches(emptyList())), artist, topAlbums,
                LastFmArtistList(emptyList()), unknownAlbumDetail)
        `when`(lastFmService.requestAlbum(albumMbid)).thenReturn(FakeCall(Response.success(unknownAlbumResponse), null))

        // when
        val album = cloudAlbumDataSet.requestAlbum(albumMbid)

        // then
        verify(lastFmService).requestAlbum(albumMbid)
        assertNull(album)
    }

    @Test
    fun testRequestTopAlbums_byArtistMbid() {
        // when
        val albums = cloudAlbumDataSet.requestTopAlbums(artistMbid, null)

        // then
        verify(lastFmService).requestAlbums(artistMbid, "")
        assertEquals(albumMapper.transform(lastFmResponse.topAlbums.albums), albums)
    }

    @Test
    fun testRequestTopAlbums_byArtistName() {
        // when
        val albums = cloudAlbumDataSet.requestTopAlbums(null, artistName)

        // then
        verify(lastFmService).requestAlbums("", artistName)
        assertEquals(albumMapper.transform(lastFmResponse.topAlbums.albums), albums)
    }

    @Test
    fun testRequestTopAlbums_byArtistNameAndMbid() {
        // when
        val albums = cloudAlbumDataSet.request
    }
}