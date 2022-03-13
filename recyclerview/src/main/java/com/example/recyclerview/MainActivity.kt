package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    var TAG: String = "로그"

    var modelList = ArrayList<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"MainActivity - onCreate(),called")
        Log.d(TAG,"MainActivity - this.modelList.size : ${this.modelList.size}")
        for (i in 1..10){
            val myModel = MyModel(name = "김도현 $i",profilImage = "")
            this.modelList.add(myModel)
        }
        Log.d(TAG,"MainActivity - this.modelList.size : ${this.modelList.size}")

        //어답터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter()

        myRecyclerAdapter.submitList(this.modelList)

        // 리사이클러 뷰 설정
        my_recycler_view.apply {
            layoutManeger = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)

            //어답터 장착
            adapter = myRecyclerAdapter
        }
    }
}