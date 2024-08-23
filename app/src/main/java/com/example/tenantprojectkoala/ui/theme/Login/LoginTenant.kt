package com.example.tenantprojectkoala.ui.theme.Login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tenantprojectkoala.R
import com.example.tenantprojectkoala.ui.theme.Blue
import com.example.tenantprojectkoala.ui.theme.Green
import com.example.tenantprojectkoala.ui.theme.Home.Homemain

@Composable
fun TenantLogin(navController: NavController,
                  text: String,
                  textColor: Color,
                  gradient: Brush,
                  onClick: () -> Unit) {
    var email by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value = "")
    }

    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        Image(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .height(220.dp)
            .scale(1.7f),
            painter = painterResource(id = R.drawable.logintenant) ,
            contentDescription = "Logo")

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter Email") },
            placeholder = { Text(text = "Please Enter Password") },
            value = email,
            onValueChange ={
                    newName->email=newName
            } )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter Password") },
            placeholder = { Text(text = "Please Enter Password") },
            value = password,
            onValueChange ={
                    newPassword->password=newPassword
            } )

        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .height(140.dp)
            .width(200.dp)
            .padding(10.dp),

//            border = BorderStroke(3.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(5.dp),
//            elevation = ButtonDefaults.buttonElevation(
//                defaultElevation = 8.dp,
//                pressedElevation = 12.dp
//            ),
            onClick = { onClick() }


        )
        {
            Box(
                modifier = Modifier
                    .background(gradient)
                    .padding(horizontal = 9.dp, vertical = 15.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "LOGIN",
                    color = textColor,
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                )
            ) {
                append("Don't Have An Account Yet....? ")

            }

            pushStringAnnotation(
                tag = "REGISTER.",
                annotation = "REGISTER."
            )
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    letterSpacing = 1.8.sp
                )
            ) {
                append("REGISTER.")
            }
            pop()
        }

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "REGISTER.",
                    start = offset,
                    end = offset
                )[0].let { annotation ->
                    Log.d("Clicked", annotation.item)
                }
            },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center
            )
        )




    }

}


@Composable
fun ForgotPassword2Text(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        val annotatedText = buildAnnotatedString {
            // Forgot Password text
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    letterSpacing = 1.5.sp,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ) {
                append("Forgot Password...? ")
            }

            pushStringAnnotation(
                tag = "CLICK HERE.",
                annotation = "CLICK HERE."
            )
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.5.sp,
                    fontSize = 25.sp,
                )
            ) {
                append("CLICK HERE.")
            }
            pop()
        }

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "CLICK HERE.",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    // Handle Forgot Password click
                    Log.d("Clicked", "Forgot Password clicked")
                }
            },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center
            )
        )
    }
}



@Preview (showSystemUi = true, showBackground = true)
@Composable
fun TenantloginPreview() {
    TenantLogin(
        rememberNavController(),
        text = "Button",
        textColor = Color.Black,
        gradient = Brush.horizontalGradient(
            colors = listOf(Blue, Green)
        )) {}
    ForgotPassword2Text()

}

