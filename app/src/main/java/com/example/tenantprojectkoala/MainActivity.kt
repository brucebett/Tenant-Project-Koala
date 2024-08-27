package com.example.tenantprojectkoala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tenantprojectkoala.navigation.AppNavHost
import com.example.tenantprojectkoala.ui.theme.TenantProjectKoalaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TenantProjectKoalaTheme {
                AppNavHost()
            }

        }
    }
}

