package com.home.androidComposable

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.home.androidComposable.data.MessageModel
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.home.androidComposable.data.fakeData
import androidx.compose.runtime.setValue

// 1. Composable function: Text, Image...
// 2. Layout: Column, Row, Modifier.
// 3. Material Design has 2 main: Color (Màu), Typography (Kiểu chữ) và Shape
// 4. Lists and Animation

// Unit: Lists and animations are everywhere in apps.
// In this lesson, you will learn how Compose makes it easy to create lists and fun to add animations. and register events
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                Conversation(messages = fakeData())
            }
        }
    }

    @Composable
    fun MessageCard(message: MessageModel) {
        // Hàm Column cho phép bạn sắp xếp các phần tử theo chiều dọc. Thêm Column vào hàm MessageCard.
        // Bạn có thể sử dụng Row để sắp xếp các mục theo chiều ngang và Box để nhóm các phần tử.

        // Your message layout has the right structure but its elements aren't well spaced and the image is too big!
        // To decorate or configure a composable, Compose uses modifiers
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.pokemon),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(60.dp)
                    // Set Shape for image. This is circle
                    .clip(CircleShape)
                    .border(width = 1.dp, MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(5.dp))
            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.width(5.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) {
                            Int.MAX_VALUE
                        } else {
                            1
                        },
                        color = MaterialTheme.colorScheme.primaryContainer,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }


    @Composable
    fun Conversation(messages: List<MessageModel>) {
        Column {
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                contentDescription = "Action Close",
                modifier = Modifier
                    .clickable {
                        finish()
                    }
                    .padding(5.dp, 10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn {
                items(messages) { message ->
                    MessageCard(message = message)
                }
            }
        }
    }

    // Dark theme (or night mode) can be enabled to avoid a bright display especially at night,
    // or simply to save the device battery
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        Surface {
            MessageCard(
                message = MessageModel("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
            )
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        Conversation(messages = fakeData())
    }

}
