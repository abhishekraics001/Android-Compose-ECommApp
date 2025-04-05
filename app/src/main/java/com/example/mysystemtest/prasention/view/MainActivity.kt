package com.example.mysystemtest.prasention.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysystemtest.domain.model.Item
import com.example.mysystemtest.R
import com.example.mysystemtest.data.utils.ResponseResult
import com.example.mysystemtest.di.KoinModules
import com.example.mysystemtest.domain.model.DashboardModel
import com.example.mysystemtest.prasention.view.adapter.SectionAdapterNew
import com.example.mysystemtest.prasention.view.viewHolder.SpacesItemDecoration
import com.example.mysystemtest.prasention.viewModel.DashboardViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Inject ViewModel using Koin
    private val dashboardViewModel: DashboardViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // KoinModules.inject()

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Optional: Customize the toolbar
        supportActionBar?.apply {
            title = "Category"
            setDisplayHomeAsUpEnabled(false) // To add back button
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(SpacesItemDecoration(0)) // Adjust the spacing as per your design


        // Assuming you have parsed the JSON and created the sections list
        var sections = mutableListOf<DashboardModel>()
          /* DashboardModel("banner", listOf(
               Item("Jacket", "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg"),
               Item("Hat", "https://images.pexels.com/photos/984619/pexels-photo-984619.jpeg")
            )),
            DashboardModel("horizontalFreeScroll", listOf(
                Item("Laptop", "https://images.pexels.com/photos/7974/pexels-photo.jpg"),
                Item("Hat", "https://images.pexels.com/photos/984619/pexels-photo-984619.jpeg"),
                Item("Sunglasses", "https://images.pexels.com/photos/343720/pexels-photo-343720.jpeg"),
                Item("Watch", "https://images.pexels.com/photos/277390/pexels-photo-277390.jpeg"),
                Item("Jacket", "https://images.pexels.com/photos/789812/pexels-photo-789812.jpeg"),
                Item("Hat", "https://images.pexels.com/photos/984619/pexels-photo-984619.jpeg")
            )), DashboardModel("verticalFreeScroll", listOf(
                Item("Camera", "https://images.pexels.com/photos/225157/pexels-photo-225157.jpeg"),
            )),
            DashboardModel("splitBanner", listOf(
                 Item("Camera", "https://images.pexels.com/photos/225157/pexels-photo-225157.jpeg"),
                 Item("Perfumes", "https://images.pexels.com/photos/264819/pexels-photo-264819.jpeg"),
                 Item("Hat", "https://images.pexels.com/photos/984619/pexels-photo-984619.jpeg"),
                 Item("Sunglasses", "https://images.pexels.com/photos/225157/pexels-photo-225157.jpeg"),
             )),

             DashboardModel("banner", listOf(
                 Item("Bagpack", "https://images.pexels.com/photos/532803/pexels-photo-532803.jpeg"),
                 Item("Bagpack", "https://images.pexels.com/photos/532803/pexels-photo-532803.jpeg")
             ))
        )*/

        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = false

        recyclerView.adapter = SectionAdapterNew(sections)
        recyclerView.setHasFixedSize(true)





        // Call ViewModel's fetch method
        dashboardViewModel.fetchSections()

        // Observe StateFlow from the ViewModel
        lifecycleScope.launch {
            dashboardViewModel.sectionsState.collect { responseResult ->
                when (responseResult) {
                    is ResponseResult.Loading -> {
                        println("API Loading")
                        // Show loading
                    }
                    is ResponseResult.Success -> {
                        println("API Success : ${responseResult.data}")
                        // Update UI with data
                         sections = (responseResult.data as List<DashboardModel>).toMutableList()

                        recyclerView.adapter = SectionAdapterNew(sections)
                        // Handle the data in your UI
                    }
                    is ResponseResult.Error -> {
                        println("API Error: ${responseResult.message}")
                        // Handle error
                    }
                }
            }
        }

    }
}