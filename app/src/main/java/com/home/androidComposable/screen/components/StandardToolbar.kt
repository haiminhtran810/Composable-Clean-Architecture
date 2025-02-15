package com.home.androidComposable.screen.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.home.androidComposable.ui.theme.MovieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardToolbar(
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    onBackArrowClicked: () -> Unit = {},
    navAction: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier,
        title = title,
        navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = onBackArrowClicked) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.background
//        )
    )
}

@Preview
@Composable
fun StandardToolbarReview(){
    MovieTheme {
        StandardToolbar(
            showBackArrow = true,
            title = {
                Text(text = "About")
            }
        )
    }
}