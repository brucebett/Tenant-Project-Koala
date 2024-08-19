//package com.example.tenantprojectkoala.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.tenantprojectkoala.ui.theme.Blue
//import com.example.tenantprojectkoala.ui.theme.Green
//import com.example.tenantprojectkoala.ui.theme.Home.Homemain
//import com.example.tenantprojectkoala.ui.theme.Orange
//
//@Composable
//fun AppNavHost(
//    navController: NavHostController =rememberNavController(),
//    startDestination: String = ROUTE_HOME_MAIN
//){
//NavHost(navController = navController, startDestination = startDestination) {
//    composable(ROUTE_HOME_MAIN){ Homemain(navController,
//            text = "Button",
//            textColor = Color.White,
//            gradient = Brush.verticalGradient(colors = listOf(Blue, Orange, Green)
//            )
//    }
//}
//}
//
