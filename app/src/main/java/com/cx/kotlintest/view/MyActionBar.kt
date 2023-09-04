package com.cx.kotlintest.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.cx.kotlintest.R
import kotlinx.android.synthetic.main.layout_action_bar.view.*

class MyActionBar(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_action_bar, this)
        bt_left.setOnClickListener {
            // 强制转换
            val activity = context as Activity
            activity.finish()
        }
        bt_right.setOnClickListener {
            Toast.makeText(context, "响应点击事件", Toast.LENGTH_SHORT).show()
        }
    }
}