package com.gold24park.instantsearch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gold24park.instantsearch.R
import com.gold24park.instantsearch.extension.onTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: ChickenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        // 검색 결과를 observe하여 Adapter에 등록
        viewModel.searchResult.observe(this, Observer {
            adapter.submitList(it)
        })

        et_search.setText("") // 처음에 모든 치킨집 리스트 보여주기 위함
    }

    private fun init() {
        adapter = ChickenAdapter()
        // RecyclerView 설정
        rv_result.adapter = adapter
        rv_result.setHasFixedSize(true)
        rv_result.layoutManager = LinearLayoutManager(this)
        // EditText 입력 값에 변화가 있으면 BroadcastChannel로 값 전송
        et_search.onTextChanged { s, start, before, count ->
            val queryText = s.toString()
            // Channel에 queryText 전송, Channel 용량을 침범하지 않았다면 true 아니면 false 리턴
            viewModel.queryChannel.offer(queryText)
        }
    }
}