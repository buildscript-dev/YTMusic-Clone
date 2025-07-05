package com.example.ytmusic.presentation.album

import android.icu.lang.UCharacter.IndicPositionalCategory.NA
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.rememberPagerState


data class QuickAlbum(
    val imageUrl: String,
    val name: String,
    val artists: String,
    val views: String,
)

val quickAlbums = listOf(
    QuickAlbum(
        imageUrl = "https://i.scdn.co/image/ab67616d0000b2732b80d11fbe7e1a4c9e065be5",
        name = "YKWIM",
        artists = "Karan Aujla, KR$NA",
        views = "2.3M views"
    ),
    QuickAlbum(
        imageUrl = "https://i1.sndcdn.com/artworks-kUuYyWr06EK2xRCO-Q9PPaQ-t500x500.jpg",
        name = "Wavy",
        artists = "Twinbeatz",
        views = "1.7M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/165/Kesariya-From-Brahmastra-Hindi-2022-20220717131023-500x500.jpg",
        name = "Kesariya",
        artists = "Arijit Singh",
        views = "12.4M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/815/Bhediya-Hindi-2023-20230927155213-500x500.jpg",
        name = "Apna Bana Le",
        artists = "Arijit Singh",
        views = "8.5M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/344/Rab-Ne-Bana-Di-Jodi-Hindi-2008-500x500.jpg",
        name = "Tujh Mein Rab Dikhta Hai",
        artists = "Roop Kumar Rathod",
        views = "9.1M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/985/Malang-Hindi-2020-20200207142805-500x500.jpg",
        name = "Malang",
        artists = "Ved Sharma",
        views = "5.2M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/670/Jawan-Hindi-2023-20230921100719-500x500.jpg",
        name = "Chaleya",
        artists = "Arijit Singh, Shilpa Rao",
        views = "10.6M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/171/Ghungroo-From-War--Hindi-2019-20190904054758-500x500.jpg",
        name = "Ghungroo",
        artists = "Arijit Singh, Shilpa Rao",
        views = "7.3M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/246/Shershaah-Hindi-2021-20210810161034-500x500.jpg",
        name = "Raataan Lambiyan",
        artists = "Jubin Nautiyal, Asees Kaur",
        views = "14.8M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/579/Tera-Ban-Jaunga-From-Kabir-Singh--Hindi-2019-20190618030927-500x500.jpg",
        name = "Tera Ban Jaunga",
        artists = "Akhil Sachdeva, Tulsi Kumar",
        views = "6.6M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/061/Kal-Ho-Naa-Ho-Hindi-2003-20221028171450-500x500.jpg",
        name = "Kal Ho Naa Ho",
        artists = "Sonu Nigam",
        views = "13.3M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/634/Galliyan-From-Ek-Villain--Hindi-2014-20220921051039-500x500.jpg",
        name = "Galliyan",
        artists = "Ankit Tiwari",
        views = "8.9M views"
    ),
    QuickAlbum(
        imageUrl = "https://c.saavncdn.com/132/Zara-Hatke-Zara-Bachke-Hindi-2023-20230601094658-500x500.jpg",
        name = "Tere Vaaste",
        artists = "Varun Jain, Sachin-Jigar",
        views = "11.1M views"
    ),
    QuickAlbum(
        imageUrl = "https://i.scdn.co/image/ab67616d0000b273e4ed164b7f35b644134b1f3a",
        name = "On My Way",
        artists = "Alan Walker",
        views = "200M+ views"
    ),
    QuickAlbum(
        imageUrl = "https://i.scdn.co/image/ab67616d0000b2737c3f9324d28e3d5e83a8c0f3",
        name = "Blinding Lights",
        artists = "The Weeknd",
        views = "1.1B views"
    ),
    QuickAlbum(
        imageUrl = "https://i.scdn.co/image/ab67616d0000b273d9b5d9c2d7f21dcf61f4ed8e",
        name = "Night Changes",
        artists = "One Direction",
        views = "550M views"
    )
)


//@Composable
//fun QuickPickAlbum(quickAlbums: List<QuickAlbum>){
//
//    LazyHorizontalGrid(modifier = Modifier.fillMaxWidth()) {
//        quick
//
//    }
//
//}