package com.home.androidComposable

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.home.androidComposable.data.MessageModel
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(message = MessageModel("Nhoc Tax", " I am Android Developer"))
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
                painter = painterResource(id = android.R.drawable.ic_dialog_map),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Set Shape for image. This is circle
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Row {
                    Text(text = "Author: ")
                    Text(text = message.author)
                }
                Spacer(modifier = Modifier.width(2.dp))
                Row {
                    Text(text = "Body: ")
                    Text(text = message.body)
                }
            }
        }
    }

    // Chú thích @Preview cho phép bạn xem trước các hàm có khả năng kết hợp trong Android Studio
    // mà không cần phải tạo và cài đặt ứng dụng trên thiết bị Android hoặc trình mô phỏng
    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(message = MessageModel("Nhoc Tax", " I am Android Developer"))
    }
}
