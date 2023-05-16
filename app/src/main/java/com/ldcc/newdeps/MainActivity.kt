package com.ldcc.newdeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 *  https://developer.android.com/guide/components/fundamentals?hl=ko
 *
 *  Android?
 *  - MultiUser Linux System (각 앱에 Linux ID를 할당 -> 권한 설정)
 *  - 각 프로세스는 자체적인 Virtual Machine을 갖고 있기 때문에 한 앱의 코드는 다른 앱과는 격리된 상태에서 실행
 *
 *  Android 4대 Component
 *  - Activity
 *  - Service
 *  - Broadcast Receiver
 *  - Content Resolver
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}