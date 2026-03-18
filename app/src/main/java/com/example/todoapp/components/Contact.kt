package com.example.todoapp.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R


@Composable
fun Contact(name: String, phone: String){
    Row{
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Foto de contacto",
            modifier = Modifier.size(64.dp) )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(
                text = name,
                fontSize = 20.sp,
            )
            Text(
                text = phone,
                fontSize = 20.sp,

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview(){
    Contact("Yonatan", "123456789")

}