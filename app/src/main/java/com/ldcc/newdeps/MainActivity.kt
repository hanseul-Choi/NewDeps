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
 *  Android 4대 Component : 사용자가 앱에 들어올 수 있는 진입점
 *  - Activity (사용자 상호작용 진입점 - 사용자 화면)
 *  - Service (백그라운드 앱을 실행하기 위한 다목적 진입점 - UI 제공 x - 음악재생)
 *  - Broadcast Receiver (사용자의 플로우 밖에서 이벤트를 앱에 전달하도록 지시 - 알림)
 *  - Content Resolver (영구 저장 위치에 저장 가능한 앱 데이터 관리 - 시스템에서 URI를 전달, URI를 통해 데이터 접근)
 *
 *  어떤 앱이든 다른 앱의 구성요소를 시작할 수 있다. (Intent를 밝혀야 가능)
 *
 *  androidx?
 *  android?
 *  AppCompat?
 */
class MainActivity : AppCompatActivity() { // 액티비티
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}