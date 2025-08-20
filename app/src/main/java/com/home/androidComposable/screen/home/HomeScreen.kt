package com.home.androidComposable.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.home.androidComposable.ui.theme.MovieTheme
import com.home.domain.model.movie.Movie
import org.koin.androidx.compose.koinViewModel

// UI : https://developer.android.com/develop/ui/compose/layouts/basics?hl=vi
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val homeUiState by viewModel.homeUiState.collectAsState()
    HomeScreenContent(homeUiState = homeUiState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(homeUiState: HomeUiState) {
    val popularMovies = homeUiState.popularMovies
    val topRatedMovies = homeUiState.topRatedMovies
    val upcomingMovies = homeUiState.upcomingMovies
    val nowPlayingMovies = homeUiState.nowPlayingMovies
    Scaffold(
        topBar = {}) { innerPadding ->
        PullToRefreshBox(
            isRefreshing = false, onRefresh = { }, modifier = Modifier.padding(innerPadding)
        ) {
            val listState = rememberLazyListState() // Optimized state handling
            LazyColumn(
                state = listState, contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.size(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.movie_popular_movies),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                    PagedRow(
                        movies = popularMovies, modifier = Modifier.fillMaxWidth()
                    )
                }


                item {
                    Spacer(modifier = Modifier.size(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.movie_top_rated),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                    PagedRow(
                        movies = topRatedMovies, modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    Spacer(modifier = Modifier.size(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.movie_get_upcoming),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                    PagedRow(
                        movies = upcomingMovies, modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    Spacer(modifier = Modifier.size(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.movie_get_now_playing),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                    PagedRow(
                        movies = nowPlayingMovies, modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(16.dp))
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
        modifier = modifier, horizontalArrangement = Arrangement.Center
    ) {
        items.forEach { item ->
            Text(
                text = item,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )

        }

    }
}

@Composable
fun FilmItem(
    modifier: Modifier = Modifier, imageUrl: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true).build(),
        placeholder = painterResource(R.drawable.pokemon),
        error = painterResource(id = R.drawable.pokemon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(150.dp)
            .height(200.dp)
            .clip(shape = MaterialTheme.shapes.medium)
    )
}

@Composable
fun PagedRow(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
) {
    LazyRow {
        items(
            items = movies, key = {
                it.id ?: 0
            }) { _ ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                movies.forEach { movie ->
                    FilmItem(
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp),
                        imageUrl = movie.posterPath ?: ""
                    )
                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                            .height(1.dp)
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MovieTheme {
        val homeUiState = HomeUiState()
        HomeScreenContent(homeUiState)
    }
}