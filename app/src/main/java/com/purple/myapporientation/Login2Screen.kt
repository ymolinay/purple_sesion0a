package com.purple.myapporientation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Login2Screen() {

    val context = LocalContext.current
    val isLandscape = context.isLandscape()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.back_app),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .then(
                    if (isLandscape) {
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    } else {
                        Modifier
                            .fillMaxSize()
                    }
                )
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .then(
                            if (isLandscape) {
                                Modifier
                                    .weight(.6f)
                                    .padding(start = 72.dp)
                            } else {
                                Modifier
                                    .padding(bottom = 48.dp)
                                    .padding(horizontal = 24.dp)
                            }
                        )
                ) {
                    LoginBox(email, password, { email = it }, { password = it })
                }
                if (isLandscape) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(.4f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.promotion_app),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(48.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.Magenta)
                                .padding(3.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    name = "Phone Portrait",
    device = "spec:width=411dp,height=891dp,dpi=420",
    showBackground = true
)
@Composable
fun PreviewLogin2ScreenPortrait() {
    Login2Screen()
}

@Preview(
    name = "Phone Landscape",
    device = "spec:width=891dp,height=411dp,dpi=420",
    showBackground = true
)
@Composable
fun PreviewLogin2ScreenLandscape() {
    Login2Screen()
}