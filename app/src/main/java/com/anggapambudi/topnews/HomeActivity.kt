package com.anggapambudi.topnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.anggapambudi.topnews.adapter.TopNewsRecyclerViewAdapter
import com.anggapambudi.topnews.databinding.ActivityHomeBinding
import com.anggapambudi.topnews.model.ArticlesItem
import com.anggapambudi.topnews.model.GetTopNewsResponse
import com.anggapambudi.topnews.retrofit.TopNewsService
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private val list = ArrayList<ArticlesItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)

        TopNewsService.instance.getTopNews().enqueue(object : Callback<GetTopNewsResponse>{
            override fun onResponse(
                call: Call<GetTopNewsResponse>,
                response: Response<GetTopNewsResponse>
            ) {
                val data = response.body()?.articles
                data?.let { list.addAll(listOf(it)) }

                binding.tvRecyclerview.layoutManager = LinearLayoutManager(this@HomeActivity)
                binding.tvRecyclerview.adapter = TopNewsRecyclerViewAdapter(this@HomeActivity, list)

            }

            override fun onFailure(call: Call<GetTopNewsResponse>, t: Throwable) {
                toast("Periksa koneksi anda")
            }

        })

    }
}