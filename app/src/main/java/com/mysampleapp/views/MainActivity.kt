package com.mysampleapp.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mysampleapp.network.APIService
import com.mysampleapp.network.RetrofitInstance
import com.mysampleapp.repository.CountryRepositoryImpl
import com.mysampleapp.ui.theme.MyAppTheme
import com.mysampleapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    // Manually instantiate the repository and ViewModel
    private val apiService: APIService = RetrofitInstance.retrofit.create(APIService::class.java)
    private val countryRepository = CountryRepositoryImpl(apiService)
    private val mainViewModel: MainViewModel by lazy { MainViewModel(countryRepository) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                CountryListScreen(mainViewModel)
            }
        }
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
    MyAppTheme() {
        Greeting("Android")
    }
}