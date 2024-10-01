package com.purple.myapporientation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.back_app),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            if (maxWidth < maxHeight) {
                // Portrait mode
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoginBox(email, password, { email = it }, { password = it })
                }
            } else {
                // Landscape mode
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.5f)
                            .padding(end = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        LoginBox(email, password, { email = it }, { password = it })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.5f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.promotion_app),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(48.dp)
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
fun PreviewLoginScreenPortrait() {
    LoginScreen()
}

@Preview(
    name = "Phone Landscape",
    device = "spec:width=891dp,height=411dp,dpi=420",
    showBackground = true
)
@Composable
fun PreviewLoginScreenLandscape() {
    LoginScreen()

}