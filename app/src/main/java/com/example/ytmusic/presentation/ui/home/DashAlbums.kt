package com.example.ytmusic.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

data class Album(val name: String, val imageUrl: String)

val albums = listOf(
    Album("Ykwim (feat. Karan Aujla)","https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/c1/4c/c2/c14cc284-e963-761e-210e-ca7b239b30f9/859753069389_cover.jpg/592x592bb.webp",),
    Album("Wavy (feat. Twinbeatz)", "https://is1-ssl.mzstatic.com/image/thumb/Music221/v4/51/79/4c/51794c30-7dfb-e04f-dca1-30a26d233718/198588844908.jpg/592x592bb.webp",),
    Album("Kesariya – Brahmāstra","https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/9f/13/ca/9f13ca3b-e533-03e0-f19a-f0aaa774581d/196589311191.jpg/592x592bb.webp"),
    Album("Apna Bana Le – Bhediya", "https://c.saavncdn.com/815/Bhediya-Hindi-2023-20230927155213-500x500.jpg"),
    Album("Tujh Mein Rab Dikhta Hai – Rab Ne Bana Di Jodi","https://c.saavncdn.com/344/Rab-Ne-Bana-Di-Jodi-Hindi-2008-500x500.jpg"),
    Album("Malang – Malang", "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/1a/db/e0/1adbe03a-4256-94fe-a432-1c70119a61f0/849486012318_cover.jpg/592x592bb.webp"),
    Album("Desi Kalakaar", "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/b3/b5/d9/b3b5d986-7f6d-a860-b8aa-769e1eef1a92/8902894356299_cover.jpg/592x592bb.webp"),
    Album("Brown Rang", "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/7f/86/32/7f8632d0-dab1-2d58-af27-dfa7206a9cc9/8902633269552.jpg/592x592bb.webp"),
    Album("Don't Look", "https://is1-ssl.mzstatic.com/image/thumb/Music123/v4/e2/df/8f/e2df8f12-9599-1c34-9b40-f7dc8e4d71fb/859731512777_cover.jpg/592x592bb.webp"),
    Album("Mexico", "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/f8/a9/26/f8a926d7-aae8-46a2-739d-5d1795f2fdf5/8905285022148.jpg/592x592bb.webp"),
    Album("Panjabi Trap", "https://is1-ssl.mzstatic.com/image/thumb/Music118/v4/53/85/04/5385046e-8f72-e026-556e-697f44e4f3f9/artwork.jpg/592x592bb.webp"),
    Album("Starboy", "https://is1-ssl.mzstatic.com/image/thumb/Music115/v4/e2/61/f8/e261f8c1-73db-9a7a-c89e-1068f19970e0/16UMGIM67863.rgb.jpg/592x592bb.webp"),
    Album("Shape of You", "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/15/54/05/1554058b-97b5-834b-1cff-39a4fb6075d8/190295827939.jpg/592x592bb.webp"),
    Album("Believer", "https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/11/7a/b8/117ab805-6811-8929-18b9-0fad7baf0c25/17UMGIM98210.rgb.jpg/592x592bb.webp"),
    Album("On My Way", "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/c1/f1/3e/c1f13e56-448d-00f0-96d6-45fd50f97f40/886447612866.jpg/592x592bb.webp"),
    Album("Blinding Lights", "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/a6/6e/bf/a66ebf79-5008-8948-b352-a790fc87446b/19UM1IM04638.rgb.jpg/592x592bb.webp"),
    Album("Night Changes", "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/14/e4/98/14e49846-57a9-dc8d-6fa3-5e03ccf3606c/dj.ljogvxod.jpg/592x592bb.webp")

)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DashAlbums(albums: List<Album>) {
    val onClickBorder by remember { mutableStateOf(true) }
    var isBorder by remember { mutableStateOf(false) }
    val itemsPerPage = 9
    val pages = albums.chunked(itemsPerPage)
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
//                .aspectRatio(1f) // make it square like yours
        ) { page ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(pages[page]) { album ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(2.dp) // just a bit of space around each item
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
//                                .then(
//                                    if (onClickBorder) {
//                                        Modifier
//                                            .clickable {
//                                                isBorder = !isBorder // toggle border on click
//                                            }
//                                            .border(
//                                                width = if (isBorder) 4.dp else 0.dp,
//                                                color = Color.White,
//                                                shape = RoundedCornerShape(8.dp)
//                                            )
//                                    } else {
//                                        Modifier // just skip clickable and border
//                                    })
                                .aspectRatio(1f)
                                .clip(shape = RoundedCornerShape(8.dp))
                        ){AsyncImage(
                            model = album.imageUrl,
                            contentDescription = album.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                            Text(
                                text = album.name,
                                fontSize = 12.sp,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                                    .align(Alignment.BottomCenter)
                                    .background(color = Color.Black.copy(alpha = 0.3f))
                            )

                        }
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