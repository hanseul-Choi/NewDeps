package com.ldcc.newdeps.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import kr.chs.feature.test1.navigation.test1Screen
import kr.chs.feature.test2.navigation.test2Screen

@Composable
internal fun NewDepsNavHost(
    modifier: Modifier,
    navController: NavHostController,
    snackBarHostState: SnackbarHostState
) {
    val coroutineScope = rememberCoroutineScope() // question : 왜 코루틴 스코프를 remember 시키지? -> error msg 를 담음

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestination.Test1.route,
    ) {
        test1Screen()
        test2Screen()
    }
}