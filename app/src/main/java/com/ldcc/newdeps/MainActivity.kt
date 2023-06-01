package com.ldcc.newdeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/**
 *  build-logic
 *  https://proandroiddev.com/single-source-of-truth-for-your-build-scripts-72d584534949
 *
 *  build script의 보일러 플레이트 코드를 줄이면서 진행하는 것이 요즘 큰 주제이다.
 *
 *  - plugin : plugin 사용 관련 정보만 담음
 *  - dependencies : 많이 변동이 많은 곳(이곳 관리가 중요할 수 있음)
 *
 *  Modularization이 적용되면서 모듈마다의 종속성(버전)관리가 중요해졌음 => version Catalog를 추천
 *
 *  version catalog : 의존성 리스트, 의존성 정의해 놓으면 사용자가 선택하는 형태
 *    - 의존성 쉽게 주입 가능
 *    - 빌드 중앙 관리 가능
 *    - 의존성 그룹으로 관리 가능
 *    - 그룹화를 통해 맞춤형 버전 관리 가능
 *
 *  1. gradle 밑에 libs.version.toml 파일 제작
 *    1-1. [versions] : version 선언
 *    1-2. [libraries] : alias 선언
 *    1-3. [bundles] : dependency bundles 선언
 *    1-4. [plugins] : plugin 선언
 *
 *  group은 간단하게 2개로 나눌 수 있음
 *  - android-specific
 *  - 3-rd party (kotlin-specific)
 *
 *  buildSrc는 out-of-date가 자주되어 빌드시 문제가 조금 있음
 *
 *
 *
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

//class MainActivity : AppCompatActivity() { // 액티비티
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}


class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestView()
        }
    }
}

@Composable
fun TestView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "test view!",
            color = Color.Black
        )

        Text(
            text = "is Appear!",
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun TestPreview() {
    TestView()
}