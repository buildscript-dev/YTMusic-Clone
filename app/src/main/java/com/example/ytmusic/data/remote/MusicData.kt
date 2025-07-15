package com.example.ytmusic.data.remote


data class SongItem(
    val title: String? = null,
    val artist: String? = null,
    val audioUrl: String? = null,     // MP3 URL (can be null)
    val videoUrl: String? = null,     // MP4 URL (can be null)
    val coverArtUrl: String? = null,  // Album image URL
    val duration: Long? = null        // Duration in millis
)

val songList = listOf(
    SongItem(
        title = "Starboy",
        artist = "The Weeknd",
        audioUrl = "https://docs.google.com/uc?export=download&1AOSCcKc1lkpwqWLggQaCfWuo8_9yL53t",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
    SongItem(
        title = "Destiny",
        artist = "Jerry",
        audioUrl = "https://docs.google.com/uc?export=download&id=1vPrf71NN7Qvck-tqvnxM5NJYzNHr4jdw",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
   SongItem(
        title = "My Prime",
        artist = "Navaan Sandhu",
        audioUrl = "https://docs.google.com/uc?export=download&id=1OJUp8dyxJA4FC7bG0v9OgqJ2qzlR608y",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
SongItem(
        title = "999",
        artist = "Jerry",
        audioUrl = "https://docs.google.com/uc?export=download&id=1CmPQXAZKDtrnFzkLv73paKIUFcAmVlV5",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
SongItem(
        title = "One of One",
        artist = "Jerry",
        audioUrl = "https://docs.google.com/uc?export=download&id=1IDnFXTeHVPsQT5Nk-Qq218bFz9OvTWeV",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
SongItem(
        title = "Payal",
        artist = "Yo Yo Honey Singh",
        audioUrl = "https://docs.google.com/uc?export=download&id=1J2K1LD2Vis5fbVspMcwkKZX693o7u4OD",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
SongItem(
        title = "Shape of You",
        artist = "Ed Sheeran",
        audioUrl = "https://docs.google.com/uc?export=download&id=1c1fGg9s4XvufRNx2SmUFxiKMZ9ZPsoIE",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
SongItem(
        title = "Starboy",
        artist = "The Weeknd",
        audioUrl = "https://docs.google.com/uc?export=download&id=YOUR_AUDIO_FILE_ID",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    ),
SongItem(
        title = "Wavy",
        artist = "Twinbeatz",
        audioUrl = "https://docs.google.com/uc?export=download&id=1RFTCKUzStZJcgJG_stQrqTiXMSllqL7b",
        videoUrl = "https://docs.google.com/uc?export=download&id=YOUR_VIDEO_FILE_ID",
        coverArtUrl = "https://i.imgur.com/starboy.jpg",
        duration = 215000L
    )
)
