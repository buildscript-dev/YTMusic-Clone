package com.example.ytmusic.data.local

import androidx.annotation.RawRes
import com.example.ytmusic.R

data class Song(
    val title: String? = null,
    val artist: String? = null,
    val imageUrl: String? = null,
    val duration: Long? = null,
    val albEp : String? = null,
    @RawRes val audioResId: Int? = null,
    @RawRes val videoResId: Int? = null,
    val audioUrl: String? = null,
    val videoUrl: String? = null,
    val isLocal: Boolean? = null,
    val view: String? = null
)


val songList = listOf(
    Song(
        title = "Starboy",
        artist = "The Weeknd",
        audioResId = R.raw.musicstar,
        videoResId = R.raw.starboy,
        imageUrl = "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/a6/6e/bf/a66ebf79-5008-8948-b352-a790fc87446b/19UM1IM04638.rgb.jpg/592x592bb.webp",
        duration = 215000L,
        albEp = "EP",
        view = "5.2M views"
    ),
    Song(
        title = "Destiny",
        artist = "Jerry",
        audioUrl = "https://docs.google.com/uc?export=download&id=1vPrf71NN7Qvck-tqvnxM5NJYzNHr4jdw",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "780K views"
    ),
    Song(
        title = "My Prime",
        artist = "Navaan Sandhu",
        audioUrl = "https://docs.google.com/uc?export=download&id=1OJUp8dyxJA4FC7bG0v9OgqJ2qzlR608y",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "1.1M views"
    ),
    Song(
        title = "999",
        artist = "Jerry",
        audioUrl = "https://docs.google.com/uc?export=download&id=1CmPQXAZKDtrnFzkLv73paKIUFcAmVlV5",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "640K views"
    ),
    Song(
        title = "One of One",
        artist = "Jerry",
        audioUrl = "https://docs.google.com/uc?export=download&id=1IDnFXTeHVPsQT5Nk-Qq218bFz9OvTWeV",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "720K views"
    ),
    Song(
        title = "Payal",
        artist = "Yo Yo Honey Singh",
        audioUrl = "https://docs.google.com/uc?export=download&id=1J2K1LD2Vis5fbVspMcwkKZX693o7u4OD",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "4.3M views"
    ),
    Song(
        title = "Shape of You",
        artist = "Ed Sheeran",
        audioUrl = "https://docs.google.com/uc?export=download&id=1c1fGg9s4XvufRNx2SmUFxiKMZ9ZPsoIE",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "6.8M views"
    ),
    Song(
        title = "Starboy (Alt)",
        artist = "The Weeknd",
        audioUrl = "https://docs.google.com/uc?export=download&id=YOUR_AUDIO_FILE_ID",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "5.2M views"
    ),
    Song(
        title = "Wavy",
        artist = "Twinbeatz",
        audioUrl = "https://docs.google.com/uc?export=download&id=1RFTCKUzStZJcgJG_stQrqTiXMSllqL7b",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        imageUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L,
        view = "850K views"
    )
)
