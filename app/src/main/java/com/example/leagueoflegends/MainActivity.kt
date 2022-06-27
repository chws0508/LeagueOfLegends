package com.example.leagueoflegends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.leagueoflegends.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import java.nio.channels.Channel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val liveText = MutableLiveData<String>()
    private lateinit var championInfo: ChampionInfo
    private var championInfoList: List<ChampionInfo>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            lifecycleOwner=this@MainActivity
            activity=this@MainActivity
        }
        liveText.value="ChampionList"

        liveText.observe(this){
            liveText.value=it
        }



        GlobalScope.launch(Dispatchers.IO) {
            try {
                RetrofitBuilder.api.getUserInfo(
                    "cae972a519mshcbcda86e738a84ap18b31ajsne0b21cbb3c8e",
                    "league-of-legends-champion-meta.p.rapidapi.com",
                ).execute().let { response ->
                    championInfoList=response.body()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    e.printStackTrace()
                }
            }
            withContext(Dispatchers.Main){
                withTimeout(30000L) {
                    if (isActive) {
                        for (i: Int in 0..championInfoList!!.size) {
                            championInfo = championInfoList!![i]

                            delay(3000L)
                            liveText.value=championInfo.name.toString()

                            Log.d(
                                "response",
                                "Great!! successful!! ${championInfo?.name}  ${championInfo?.kda} ${championInfo?.role} ${championInfo?.winRate}"
                            )
                        }
                    }
                }
        }


        }


//        RetrofitBuilder.api.getUserInfo("cae972a519mshcbcda86e738a84ap18b31ajsne0b21cbb3c8e","love-calculator.p.rapidapi.com","Alice","James").enqueue(object :Callback<UserInfo> {
//            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
//                val userInfo = response.body()
//                Log.d("response", "Great!! successful!! ${userInfo?.percentage}  ${userInfo?.fname} ${userInfo?.sname} ${userInfo?.result}")
//            }
//
//            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
//                Log.d("error", t.message.toString())
//            }
//
//        })
    }
}
