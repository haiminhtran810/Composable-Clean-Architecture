package com.home.androidComposable.screen.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.home.androidComposable.R
import com.home.androidComposable.screen.components.StandardToolbar
import com.home.androidComposable.ui.theme.MovieTheme

@Composable
fun SearchScreen(navController: NavController, modifier: Modifier = Modifier) {
    SearchScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenContent() {
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = true,
                title = {
                    Text(text = stringResource(id = R.string.tab_title_search))
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

        }

    }
}


@Preview
@Composable
fun SearchScreenPreview() {
    MovieTheme {
        SearchScreenContent()
    }
}