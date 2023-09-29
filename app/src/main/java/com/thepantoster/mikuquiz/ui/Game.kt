package com.thepantoster.mikuquiz.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.thepantoster.mikuquiz.ui.theme.VocaloidQuizTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thepantoster.mikuquiz.R
import com.thepantoster.mikuquiz.ui.theme.Orange
import com.thepantoster.mikuquiz.ui.theme.answersFamily
import com.thepantoster.mikuquiz.ui.theme.lightGray
import com.thepantoster.mikuquiz.ui.theme.lightYellow
import com.thepantoster.mikuquiz.ui.theme.mainYellow
import com.thepantoster.mikuquiz.ui.theme.percentFamily

@Composable
fun GameLayout(modifier: Modifier = Modifier) {
    Box (
        Modifier
            .background(color = lightYellow)
            .width(1080.dp)
            .height(1920.dp)){
        Column (
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            InfoBox()
            AnswersBox()
        }

    }
}

@Composable
fun InfoBox(modifier: Modifier = Modifier) {
    Column (
        Modifier
            .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            .background(color = lightGray)
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box{
            Text(
                modifier = Modifier.offset(4.dp, 4.dp),
                text = "Wrong",
                fontFamily = answersFamily,
                fontWeight = FontWeight.W800,
                fontSize = 67.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Wrong",
                fontFamily = answersFamily,
                fontWeight = FontWeight.W800,
                fontSize = 67.sp,
                color = Orange,
                textAlign = TextAlign.Center
            )
        }
        Box{
            Text(
                text = "100%",
                fontFamily = percentFamily,
                fontWeight = FontWeight.W800,
                fontSize = 60.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "100%",
                fontFamily = percentFamily,
                fontWeight = FontWeight.W800,
                fontSize = 61.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle.Default.copy(
                    drawStyle = Stroke(
                        miter = 10f,
                        width = 2f,
                        join = StrokeJoin.Round
                    )
                )
            )
        }
        Box {
            Text(
                text = "Good answers: 2137",
                fontFamily = answersFamily,
                fontSize = 26.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.offset(y = (-1).dp),
                text = "Good answers: 2137",
                fontFamily = answersFamily,
                fontSize = 27.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle.Default.copy(
                    drawStyle = Stroke(
                        width = 1f,
                        join = StrokeJoin.Round
                    )
                )
            )
        }
        Box {
            Text(
                text = "Total answers: 123456",
                fontFamily = answersFamily,
                fontSize = 26.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.offset(y = (-1).dp),
                text = "Total answers: 123456",
                fontFamily = answersFamily,
                fontSize = 27.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle.Default.copy(
                    drawStyle = Stroke(
                        width = 1f,
                        join = StrokeJoin.Round
                    )
                )
            )
        }
    }
}

@Composable
fun AnswersBox(modifier: Modifier = Modifier){
    Column (
        Modifier
            .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            .background(color = lightGray)
            .padding(14.dp)
            .width(IntrinsicSize.Max),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Answer(songName = "Six Trillion Years and One Night Story")
        Answer(songName = "The Disappearance Of Hatsune Miku")
        Answer(songName = "Song number 3")
        Answer(songName = "Song number 4")
    }
}

@Composable
fun Answer(songName: String, modifier: Modifier = Modifier){
    Box (
        Modifier
            .border(2.dp, Color.Black)
            .background(color = mainYellow)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = songName,
            fontFamily = answersFamily,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LenImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.len)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp)
            .offset(x = (-20).dp)
    )
}

@Composable
fun RinImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.rin)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    VocaloidQuizTheme {
        GameLayout()
    }
}