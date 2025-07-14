import android.R.attr.contentDescription
import android.R.attr.tint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Shuffle
import androidx.compose.material.icons.outlined.ThumbDown
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp


@Composable
fun PlayerScreen() {
    var selectedTab by remember { mutableStateOf("Song") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left Icon
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow Down",
                tint = Color.Gray
            )

            // Middle: Tab Selector Box
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.DarkGray)
            ) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    // "Song" Tab
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(
                                if (selectedTab == "Song") Color.LightGray else Color.DarkGray
                            )
                            .clickable { selectedTab = "Song" }
                            .padding(vertical = 6.dp, horizontal = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Song",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    // "Video" Tab
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(
                                if (selectedTab == "Video") Color.LightGray else Color.DarkGray
                            )
                            .clickable { selectedTab = "Video" }
                            .padding(vertical = 6.dp, horizontal = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Video",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Right Icons
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Cast,
                    contentDescription = "Cast",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 8.dp))
                }


               IconButton(onClick = {}) {Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Options",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 8.dp)
                )
               }
            }
        }

        //Video/Song Album



        // title
        Text("One of One",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.padding(top =20.dp, start = 20.dp))

        //artist Name
        Text("Jerry",
            color = Color.LightGray,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 4.dp, start = 20.dp))


        //Like/Dislike Button
        Box(modifier = Modifier
            .padding(18.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.DarkGray)
            .wrapContentSize()){
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp,),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Outlined.ThumbUp,
                        contentDescription  = "Like",
                        tint = Color.LightGray,)
                }

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(Color.LightGray)
                )

                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Outlined.ThumbDown,
                        contentDescription  = "Dislike",
                        tint = Color.LightGray)
                }
            }
        }

        //slider


        //time lamos



        //play/pause/skip buttons

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround) {
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Outlined.Shuffle,
                    contentDescription = "Like",
                    tint = Color.LightGray)
            }
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.SkipPrevious,
                    contentDescription = "Like",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp))

            }
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Rounded.PlayCircle,
                    contentDescription = "Like",
                    tint = Color.White,
                    modifier = Modifier.size(90.dp))
            }
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.SkipNext,
                    contentDescription = "Like",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp))

            }
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.Repeat,
                    contentDescription = "Like",
                    tint = Color.LightGray)
            }
        }

        //Suggesstion

        Row(modifier = Modifier.fillMaxWidth()
            .padding(vertical = 30.dp,
                horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            SelectionContainer {
                Text("UP NEXT",
                    fontSize = 15.sp,
                    color = Color.LightGray)
            }
            SelectionContainer {
                Text("LYRICS",
                    fontSize = 15.sp,
                    color = Color.LightGray)
            }
            SelectionContainer {
                Text("RELATED",
                    fontSize = 15.sp,
                    color = Color.LightGray)
            }


        }










    }
}
