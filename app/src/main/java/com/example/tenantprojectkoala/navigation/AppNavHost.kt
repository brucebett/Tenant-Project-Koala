package com.example.tenantprojectkoala.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tenantprojectkoala.ui.theme.Addhouses.UploadHouses
import com.example.tenantprojectkoala.ui.theme.Blue
import com.example.tenantprojectkoala.ui.theme.Green
import com.example.tenantprojectkoala.ui.theme.Home.HomeLandlord
import com.example.tenantprojectkoala.ui.theme.Home.HomeTenant
import com.example.tenantprojectkoala.ui.theme.Home.Homemain
import com.example.tenantprojectkoala.ui.theme.Login.LandlordLogin
import com.example.tenantprojectkoala.ui.theme.Orange
import com.example.tenantprojectkoala.ui.theme.Register.LandlordRegister
import com.example.tenantprojectkoala.ui.theme.Register.TenantRegister
import com.example.tenantprojectkoala.ui.theme.Searchhouse.ViewHouses

@Composable
fun AppNavHost(
    navController: NavHostController =rememberNavController(),
    startDestination: String = ROUTE_HOME_MAIN
){
NavHost(navController = navController, startDestination = startDestination) {
    composable(ROUTE_HOME_MAIN){ Homemain(navController = navController,
            text = "Button",
            textColor = Color.White,
            gradient = Brush.verticalGradient(colors = listOf(Blue, Green))
            ){} }

    composable(ROUTE_LANDLORD_REGISTER){ LandlordRegister(
        navController = navController,
        text = "button",
        textColor = Color.White,
        gradient = Brush.horizontalGradient(colors = listOf(Blue, Green))
        ) {}}

    composable(ROUTE_TENANT_REGISTER){ TenantRegister(navController = navController,
        text = "Button",
        textColor = Color.White,
        gradient = Brush.verticalGradient(colors = listOf(Blue, Green))
    ){} }
    composable(ROUTE_LANDLORD_LOGIN){ LandlordLogin(
        navController = navController,
        text = "button",
        textColor = Color.White,
        gradient = Brush.horizontalGradient(colors = listOf(Blue, Green))
    ) {} }

    composable(ROUTE_LANDLORD_LOGIN){ LandlordLogin(navController = navController,
            text = "Button",
            textColor = Color.White,
            gradient = Brush.verticalGradient(colors = listOf(Blue, Green))
             ){} }

    composable(ROUTE_TENANT_LOGIN){ TenantRegister(
            navController = navController,
            text = "button",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(colors = listOf(Blue, Green))
        ) {} }

    composable(ROUTE_HOME_TENANT){ HomeTenant()}

    composable(ROUTE_HOME_LANDLORD){ HomeLandlord()}

    composable(ROUTE_UPLOAD_HOUSE){ UploadHouses() }

    composable(ROUTE_VIEW_HOUSES){ ViewHouses()}

    }

}

