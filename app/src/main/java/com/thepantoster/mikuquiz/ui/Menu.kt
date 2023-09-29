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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thepantoster.mikuquiz.R
import com.thepantoster.mikuquiz.ui.theme.DarkBlue
import com.thepantoster.mikuquiz.ui.theme.LightBlue
import com.thepantoster.mikuquiz.ui.theme.WeirdBlue
import com.thepantoster.mikuquiz.ui.theme.startButtonFamily
import com.thepantoster.mikuquiz.ui.theme.titleFamily

@Composable
fun MenuLayout(gameStart: () -> Unit, modifier: Modifier = Modifier) {
    Box (
        Modifier
            .background(color = LightBlue)
            .width(1080.dp)
            .clickable { gameStart() }
    ){
        GameTitle()
        StartButton()
        MikuImage()
    }
}



@Composable
fun GameTitle(modifier: Modifier = Modifier){
    Text(
        modifier = Modifier.padding(vertical = 20.dp),
        text = stringResource(R.string.app_name),
        fontFamily = titleFamily,
        fontSize = 80.sp,
        lineHeight = 70.sp,
        color = DarkBlue,
        textAlign = TextAlign.Center
    )
}

@Composable
fun StartButton(modifier: Modifier = Modifier){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 200.dp),
        text = "- Tap to start -",
        fontFamily = startButtonFamily,
        fontSize = 30.sp,
        lineHeight = 30.sp,
        letterSpacing = 3.sp,
        color = WeirdBlue,
        textAlign = TextAlign.Center
    )
}


@Composable
fun MikuImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.miku_git)
    Image(
        modifier = Modifier,
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    VocaloidQuizTheme {
        MenuLayout(gameStart={})
    }
}