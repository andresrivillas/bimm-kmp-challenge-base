package com.bimm.takehomeassignmnent.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bimm.takehomeassignmnent.ui.shopList.ShopListScreen
import com.bimm.takehomeassignmnent.initKoin
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        initKoin {
            androidContext(applicationContext)
        }
        setContent {
            ShopListScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    ShopListScreen()
}