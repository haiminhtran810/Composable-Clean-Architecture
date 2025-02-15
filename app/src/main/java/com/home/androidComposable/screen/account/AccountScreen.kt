package com.home.androidComposable.screen.account

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.home.androidComposable.R
import com.home.androidComposable.ui.theme.MovieTheme

@Composable
fun AccountScreen(navController: NavController, modifier: Modifier = Modifier) {
    AccountScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreenContent() {
    Scaffold(
        topBar = {
            Image(
                painterResource(id = R.drawable.pokemon), contentDescription = "App Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(8.dp)
            )
        }
    ) { innerPadding ->
        val context = LocalContext.current
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(context.accountItems()) { index, item ->
                AccountItems(accountItem = item,
                    onClick = {
                        when (item.title) {
                            context.getString(R.string.account_theme) -> {

                            }

                            context.getString(R.string.account_about) -> {

                            }

                            context.getString(R.string.account_rate_us) -> {

                            }

                            context.getString(R.string.account_share) -> {

                            }

                            context.getString(R.string.account_get_in_touch) -> {

                            }
                        }
                    })
            }
        }
    }
}

@Composable
fun AccountItems(accountItem: AccountItem, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = accountItem.icon),
                contentDescription = accountItem.title
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = accountItem.title,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

private fun Context.accountItems() = listOf(
    AccountItem(
        title = getString(R.string.account_theme),
        icon = R.drawable.pokemon
    ),
    AccountItem(
        title = getString(R.string.account_about),
        icon = R.drawable.pokemon
    ),
    AccountItem(
        title = getString(R.string.account_rate_us),
        icon = R.drawable.pokemon
    ),
    AccountItem(
        title = getString(R.string.account_share),
        icon = R.drawable.pokemon
    ),
    AccountItem(
        title = getString(R.string.account_get_in_touch),
        icon = R.drawable.pokemon
    )
)

@Preview
@Composable
fun AccountScreenPreview() {
    MovieTheme {
        AccountScreenContent()
    }
}