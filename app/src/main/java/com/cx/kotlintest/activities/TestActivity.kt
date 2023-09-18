package com.cx.kotlintest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cx.kotlintest.ConstantCX
import com.cx.kotlintest.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val data = intent.getStringExtra(ConstantCX.IntentTag.JUMP_NO_PARAM)
        tv_test_activity.text = data ?: "nothing"
    }
}