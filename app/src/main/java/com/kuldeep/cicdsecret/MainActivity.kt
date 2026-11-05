package com.kuldeep.cicdsecret

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuldeep.cicdsecret.ui.theme.CICDSecretTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CICDSecretTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecretStatusScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun SecretStatusScreen(modifier: Modifier=Modifier)
{
    val apiKey = BuildConfig.DEMO_API_KEY
    val isConfigured = apiKey.isNotEmpty()
    Column(
        modifier=Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= androidx.compose.ui.Alignment.CenterHorizontally,
    ) {
        Text(
            text = "APPLICATION ID",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Gray
        )
        Text(
            text = BuildConfig.APPLICATION_ID,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Secret Status",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Gray
        )
        if(isConfigured){
            Text(
                text = "Configured",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Green
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "API Key: ${massKey(apiKey)}",
                style = MaterialTheme.typography.bodyMedium
            )
        }else{
            Text(
                text = "Not Configured",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red
            )
        }
    }
}
private fun massKey(key: String): String{
 return if (key.length>6){
     "${key.take(n=3)}...${key.takeLast(n=3)}"
 }else {
     "**"
 }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CICDSecretTheme {
        SecretStatusScreen(modifier = Modifier)
    }
}