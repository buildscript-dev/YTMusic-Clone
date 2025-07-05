package com.example.ytmusic.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

data class Album(val name: String, val imageUrl: String)

val albums = listOf(
    Album("Ykwim (feat. Karan Aujla)", "https://i.scdn.co/image/ab67616d0000b2732b80d11fbe7e1a4c9e065be5"),
    Album("Wavy (feat. Twinbeatz)", "https://i1.sndcdn.com/artworks-kUuYyWr06EK2xRCO-Q9PPaQ-t500x500.jpg"),
    Album("Kesariya – Brahmāstra","https://c.saavncdn.com/165/Kesariya-From-Brahmastra-Hindi-2022-20220717131023-500x500.jpg"),
    Album("Apna Bana Le – Bhediya", "https://c.saavncdn.com/815/Bhediya-Hindi-2023-20230927155213-500x500.jpg"),
    Album("Tujh Mein Rab Dikhta Hai – Rab Ne Bana Di Jodi","https://c.saavncdn.com/344/Rab-Ne-Bana-Di-Jodi-Hindi-2008-500x500.jpg"),
    Album("Malang – Malang", "https://c.saavncdn.com/985/Malang-Hindi-2020-20200207142805-500x500.jpg"),
    Album("Chaleya – Jawan", "https://c.saavncdn.com/670/Jawan-Hindi-2023-20230921100719-500x500.jpg"),
    Album("Ghungroo – War", "https://c.saavncdn.com/171/Ghungroo-From-War--Hindi-2019-20190904054758-500x500.jpg"),
    Album("Raataan Lambiyan – Shershaah", "https://c.saavncdn.com/246/Shershaah-Hindi-2021-20210810161034-500x500.jpg"),
    Album("Tera Ban Jaunga – Kabir Singh", "https://c.saavncdn.com/579/Tera-Ban-Jaunga-From-Kabir-Singh--Hindi-2019-20190618030927-500x500.jpg"),
    Album("Kal Ho Naa Ho – Title Track", "https://c.saavncdn.com/061/Kal-Ho-Naa-Ho-Hindi-2003-20221028171450-500x500.jpg"),
    Album("Galliyan – Ek Villain", "https://c.saavncdn.com/634/Galliyan-From-Ek-Villain--Hindi-2014-20220921051039-500x500.jpg"),
    Album("Tere Vaaste – Zara Hatke Zara Bachke", "https://c.saavncdn.com/132/Zara-Hatke-Zara-Bachke-Hindi-2023-20230601094658-500x500.jpg"), Album("Ykwim (feat. Karan Aujla)", "https://i.scdn.co/image/ab67616d0000b2732b80d11fbe7e1a4c9e065be5"), Album("Ykwim (feat. Karan Aujla)", "https://i.scdn.co/image/ab67616d0000b2732b80d11fbe7e1a4c9e065be5"),
    Album("Wavy (feat. Twinbeatz)", "https://i1.sndcdn.com/artworks-kUuYyWr06EK2xRCO-Q9PPaQ-t500x500.jpg"),
    Album("Kesariya – Brahmāstra","https://c.saavncdn.com/165/Kesariya-From-Brahmastra-Hindi-2022-20220717131023-500x500.jpg"),
    Album("Apna Bana Le – Bhediya", "https://c.saavncdn.com/815/Bhediya-Hindi-2023-20230927155213-500x500.jpg"),
    Album("Tujh Mein Rab Dikhta Hai – Rab Ne Bana Di Jodi","https://c.saavncdn.com/344/Rab-Ne-Bana-Di-Jodi-Hindi-2008-500x500.jpg"),
    Album("Malang – Malang", "https://c.saavncdn.com/985/Malang-Hindi-2020-20200207142805-500x500.jpg"),
    Album("Chaleya – Jawan", "https://c.saavncdn.com/670/Jawan-Hindi-2023-20230921100719-500x500.jpg"),
    Album("Ghungroo – War", "https://c.saavncdn.com/171/Ghungroo-From-War--Hindi-2019-20190904054758-500x500.jpg"),
    Album("Raataan Lambiyan – Shershaah", "https://c.saavncdn.com/246/Shershaah-Hindi-2021-20210810161034-500x500.jpg"),
    Album("Tera Ban Jaunga – Kabir Singh", "https://c.saavncdn.com/579/Tera-Ban-Jaunga-From-Kabir-Singh--Hindi-2019-20190618030927-500x500.jpg"),
    Album("Kal Ho Naa Ho – Title Track", "https://c.saavncdn.com/061/Kal-Ho-Naa-Ho-Hindi-2003-20221028171450-500x500.jpg"),
    Album("Galliyan – Ek Villain", "https://c.saavncdn.com/634/Galliyan-From-Ek-Villain--Hindi-2014-20220921051039-500x500.jpg"),
    Album("Tere Vaaste – Zara Hatke Zara Bachke", "https://c.saavncdn.com/132/Zara-Hatke-Zara-Bachke-Hindi-2023-20230601094658-500x500.jpg")
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DashAlbums(albums: List<Album>) {
    val itemsPerPage = 9
    val pages = albums.chunked(itemsPerPage)
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
//                .aspectRatio(1f) // make it square like yours
        ) { page ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(pages[page]) { album ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .size(100.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            AsyncImage(
                                model = album.imageUrl,
                                contentDescription = album.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = album.name,
                            fontSize = 12.sp,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        // Dot Indicators
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.padding(top = 12.dp),
            activeColor = Color.White,
            inactiveColor = Color.Gray
        )
    }
}

