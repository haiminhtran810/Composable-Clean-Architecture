package com.home.androidComposable.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.home.androidComposable.R
import com.home.androidComposable.screen.components.StandardToolbar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.home.androidComposable.ui.theme.MovieTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    HomeScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            StandardToolbar(
                showBackArrow = false,
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Column {
                        Image(
                            painterResource(id = R.drawable.pokemon),
                            contentDescription = null,
                            modifier =
                            Modifier
                                .size(90.dp)
                                .padding(8.dp)
                        )
                    }
                }
            )
        }
    ) { innnerPadding ->
        PullToRefreshBox(
            isRefreshing = false,
            onRefresh = { },
            modifier = Modifier.padding(innnerPadding)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    FilmCategory(
                        items = listOf(
                            stringResource(id = R.string.tab_movies),
                            stringResource(id = R.string.tab_tv_shows)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

    }
}

@Composable
fun FilmCategory(
    items: List<String>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        items.forEach { item ->
            val primaryColor = MaterialTheme.colorScheme.primary
            Text(
                text = item, modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MovieTheme {
        HomeScreenContent()
    }
}