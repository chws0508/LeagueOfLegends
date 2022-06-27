package com.example.leagueoflegends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        GlobalScope.launch(Dispatchers.IO){
            try{
                val userInfo=RetrofitBuilder.api.getUserInfo("cae972a519mshcbcda86e738a84ap18b31ajsne0b21cbb3c8e","love-calculator.p.rapidapi.com","Alice","James").execute().body()
                Log.d("response", "Great!! successful!! ${userInfo?.percentage}  ${userInfo?.fname} ${userInfo?.sname} ${userInfo?.result}")
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    e.printStackTrace()
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
