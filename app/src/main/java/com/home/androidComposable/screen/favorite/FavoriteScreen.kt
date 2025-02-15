package com.home.androidComposable.screen.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.home.androidComposable.R
import com.home.androidComposable.screen.components.StandardToolbar
import com.home.androidComposable.ui.theme.MovieTheme

@Composable
fun FavoriteScreen(navController: NavController, modifier: Modifier = Modifier) {
    FavoriteScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreenContent() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = {
                    Text(
                        text = stringResource(id = R.string.tab_title_favorite),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(250.dp),
                painter = painterResource(id = R.drawable.pokemon),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {
    MovieTheme {
        FavoriteScreenContent()
    }
}