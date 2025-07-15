package com.example.ytmusic.presentation.ui.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explicit
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


data class AlbumForYou(
    val imageUrl: String,
    val title: String,
    val artists: String,
    val albEp: String
)


val albumForYouList = listOf(
    AlbumForYou(
        title = "Wavy (feat. Twinbeatz)",
        imageUrl = "https://is1-ssl.mzstatic.com/image/thumb/Music221/v4/51/79/4c/51794c30-7dfb-e04f-dca1-30a26d233718/198588844908.jpg/592x592bb.webp",
        artists = "Karan Aujla",
        albEp = "Album"
    ),
    AlbumForYou(
        title = "Kesariya – Brahmāstra",
        imageUrl = "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/9f/13/ca/9f13ca3b-e533-03e0-f19a-f0aaa774581d/196589311191.jpg/592x592bb.webp",
        artists = "Arijit Singh",
        albEp = "Album"
    ),
    AlbumForYou(
        title = "Apna Bana Le – Bhediya",
        imageUrl = "https://c.saavncdn.com/815/Bhediya-Hindi-2023-20230927155213-500x500.jpg",
        artists = "Sachin-Jigar",
        albEp = "Ep"
    ),
    AlbumForYou(
        title = "Tujh Mein Rab Dikhta Hai",
        imageUrl = "https://c.saavncdn.com/344/Rab-Ne-Bana-Di-Jodi-Hindi-2008-500x500.jpg",
        artists = "Roop Kumar Rathod",
        albEp = "Album"
    ),
    AlbumForYou(
        title = "Malang – Malang",
        imageUrl = "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/1a/db/e0/1adbe03a-4256-94fe-a432-1c70119a61f0/849486012318_cover.jpg/592x592bb.webp",
        artists = "Ved Sharma",
        albEp = "Ep"
    ),
    AlbumForYou(
        title = "Desi Kalakaar",
        imageUrl = "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/b3/b5/d9/b3b5d986-7f6d-a860-b8aa-769e1eef1a92/8902894356299_cover.jpg/592x592bb.webp",
        artists = "Yo Yo Honey Singh",
        albEp = "Album"
    ),
    AlbumForYou(
        title = "Brown Rang",
        imageUrl = "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/7f/86/32/7f8632d0-dab1-2d58-af27-dfa7206a9cc9/8902633269552.jpg/592x592bb.webp",
        artists = "Yo Yo Honey Singh",
        albEp = "EP"
    )
)
@Composable
fun AlbumsForList() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Albums for you",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Color.DarkGray,
                    shape = CircleShape
                )
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .clickable {}
        ) {
            Text("Play all", color = Color.White, fontSize = 14.sp)
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 14.dp)
    ) {
        items(albumForYouList) { albumList ->
            Column(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(200.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    AsyncImage(
                        model = albumList.imageUrl,
                        contentDescription = albumList.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Icon(
                        imageVector = Icons.Default.MoreHoriz,
                        contentDescription = "More Options",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    )
                }

                Text(
                    text = albumList.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Row {
                    Icon(imageVector = Icons.Default.Explicit, contentDescription = "E MobileData", tint = Color.LightGray)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "${albumList.albEp} • ${albumList.artists}",
                        fontSize = 14.sp,
                        color = Color.LightGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    ) }
            }
        }
    }
}