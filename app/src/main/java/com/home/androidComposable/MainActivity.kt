package com.home.androidComposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "Nhoc Tax")
        }
    }

    // Để một hàm có thể kết hợp, hãy thêm chú thích @Composable
    @Composable
    fun MessageCard(name: String) {
        // Bạn thực hiện việc này bằng cách xác định một khối nội dung
        // và gọi hàm có khả năng kết hợp Text Khối setContent xác định bố cục của hoạt động mà trong đó.
        Text(text = "Hello $name")
    }

    // Chú thích @Preview cho phép bạn xem trước các hàm có khả năng kết hợp trong Android Studio
    // mà không cần phải tạo và cài đặt ứng dụng trên thiết bị Android hoặc trình mô phỏng
    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(name = "Nhoc Tax")
    }
}
