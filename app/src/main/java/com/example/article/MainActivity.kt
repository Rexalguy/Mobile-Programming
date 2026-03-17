package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticlePage(
                        title = stringResource(R.string.article_title),
                        intro = stringResource(R.string.introduction),
                        body = stringResource(R.string.body),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticlePage(title: String, intro: String, body: String, modifier: Modifier = Modifier) {
    //Image header
    val image = painterResource(R.drawable.bg_compose_background);

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = "Jetpack Compose banner",
            Modifier.fillMaxWidth()
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = intro,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = body,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
    }


}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticleTheme {
        ArticlePage(title = stringResource(R.string.article_title),
            intro = stringResource(R.string.introduction),
            body = stringResource(R.string.body)
        )
    }


}