package com.home.androidComposable.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.home.androidComposable.R
import com.home.androidComposable.screen.account.AccountScreen
import com.home.androidComposable.screen.favorite.FavoriteScreen
import com.home.androidComposable.screen.home.HomeScreen
import com.home.androidComposable.screen.search.SearchScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    viewModel.getPopular()
    val navItemList = listOf(
        NavItem(stringResource(id = R.string.tab_title_home), Icons.Default.Home, 0),
        NavItem(stringResource(id = R.string.tab_title_search), Icons.Default.Search, 0),
        NavItem(stringResource(id = R.string.tab_title_favorite), Icons.Default.Favorite, 0),
        NavItem(stringResource(id = R.string.tab_title_account), Icons.Default.AccountBox, 0),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if (navItem.badgeCount > 0)
                                    Badge() {
                                        Text(text = navItem.badgeCount.toString())
                                    }
                            }) {
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            }

                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex
        )
    }
}

@Composable
fun ContentScreen(navController: NavController, modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
        0 -> HomeScreen(navController)
        1 -> SearchScreen(navController)
        2 -> FavoriteScreen(navController)
        3 -> AccountScreen(navController)
    }
}