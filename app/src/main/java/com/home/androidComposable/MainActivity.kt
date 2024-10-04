package com.home.androidComposable

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.home.androidComposable.data.MessageModel
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

// Material Design được xây dựng dựa trên 3 trụ cột:
// Color (Màu), Typography (Kiểu chữ) và Shape
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                MessageCard(message = MessageModel("Nhoc Tax", " I am Android Developer"))
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
            Column {
                Row {
                    Text(text = "Author:")
                    Text(
                        text = message.author,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Row {
                    Text(text = "Body:")
                    Text(
                        text = message.body,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        style = MaterialTheme.typography.bodyMedium
                    )
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
}
