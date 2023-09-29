package com.thepantoster.mikuquiz.ui

import android.service.autofill.OnClickAction
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
import androidx.compose.foundation.layout.height
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
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.rememberNavController
import com.thepantoster.mikuquiz.MainActivity
import kotlin.math.roundToInt

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
    var visible = remember { MutableTransitionState(false).apply {
        // Start the animation immediately.
        targetState = true
    } }
    val density = LocalDensity.current
    AnimatedVisibility(
        visibleState = visible,
        enter = slideInHorizontally{
            with(density){200.dp.roundToPx()}
        },
        exit = slideOutHorizontally{
            with(density){200.dp.roundToPx()}
        }) {
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
    var started by remember { mutableIntStateOf(0) }
    val pxToMove = with(LocalDensity.current) {
        300.dp.toPx().roundToInt()
    }
    val offset by animateIntOffsetAsState(
        targetValue = when (started) {
            0 -> IntOffset(x = (-pxToMove), y = 0)
            1 -> IntOffset.Zero
            else -> {
                IntOffset(x = pxToMove, y = 0)
            }},
        label = "mikuOffset"
    )
    val image = painterResource(R.drawable.miku_git)
    Image(
        modifier = Modifier
            .offset { offset }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                started++
            },
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