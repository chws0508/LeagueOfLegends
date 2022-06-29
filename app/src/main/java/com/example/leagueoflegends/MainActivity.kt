package com.example.leagueoflegends

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.leagueoflegends.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.URL
import java.nio.channels.Channel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var championInfoList: ChampionListResponse?=null
    private var nodeList: List<Node>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            lifecycleOwner=this@MainActivity
            activity=this@MainActivity
        }

        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                binding.loadingBar.visibility= View.VISIBLE
            }
            try {
                RetrofitBuilder.api.getChampionList(
                    "cae972a519mshcbcda86e738a84ap18b31ajsne0b21cbb3c8e",
                    "league-of-legends-champions.p.rapidapi.com",
                    0,
                    10
                ).execute().let { response ->
                    championInfoList=response.body()
                    nodeList=championInfoList?.champions

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    e.printStackTrace()
                }
            }
//            try{
//                RetrofitBuilder.api.getChampion(
//                    "cae972a519mshcbcda86e738a84ap18b31ajsne0b21cbb3c8e",
//                    "league-of-legends-champion-meta.p.rapidapi.com",
//                ).execute().let {
//                    response ->
//
//                }
//
//            }catch (e:Exception){
//
//            }
            withContext(Dispatchers.Main){
                binding.loadingBar.visibility=View.INVISIBLE
                Log.d("response",championInfoList.toString())
                binding.recyclerView.adapter=ChampionListRecyclerViewAdpater(applicationContext,nodeList)

            }
        }
    }
    }

