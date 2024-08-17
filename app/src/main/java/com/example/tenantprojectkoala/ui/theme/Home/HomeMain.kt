package com.example.tenantprojectkoala.ui.theme.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Homemain(navController: NavController) {

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "You Are Welcome",
            fontSize = 35.sp,
            color = Color.Green,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.LineThrough,

            modifier = Modifier
                .background(Color.Black)
                .padding(50.dp)
                .fillMaxWidth()

        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview(){
    Homemain(rememberNavController())
}