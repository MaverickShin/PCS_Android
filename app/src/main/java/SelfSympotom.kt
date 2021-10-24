package com.example.test1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MovementMethod
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.petsystemtest4.R

// 자가진단 - 문진표
class SelfSymptom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self)

        // 스피너 선언
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val title_tv = findViewById<TextView>(R.id.title_tv)
        val name_tv = findViewById<TextView>(R.id.name_tv)
        val content_tv = findViewById<TextView>(R.id.content_tv)

        // 어댑터 설정 - resource - array.xml에 있는 아이템 목록을 추가한다.
        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.typeList, android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = ArrayAdapter.createFromResource(this, R.array.symptionList, android.R.layout.simple_spinner_item)
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    // 선택안함
                    0 -> {
                        title_tv.setText("증상 부위를 선택해주세요!")
                        name_tv.setText("")
                        content_tv.setText("")
                    }

                    // 귀
                    1 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.ear_text)
                    }

                    // 눈
                    2 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.eye_text)
                    }
                    // 구강
                    3 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.teeth_text)
                    }
                    // 다리
                    4 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.leg_text)
                    }

                    // 머리(목, 코)
                    5 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.head_text)
                    }

                    // 복부
                    6 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.stomach_text)
                    }

                    // 행동
                    7 -> {
                        title_tv.setText(spinner2.selectedItem.toString())
                        name_tv.setText("")
                        content_tv.setText(R.string.behavior_text)
                    }

                    // 일치하는게 없는 경우
                    else -> {
                        title_tv.setText("메뉴")
                        name_tv.setText("")
                        content_tv.setText("")
                    }
                }
            }
        }
    }
}