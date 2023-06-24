package com.ldcc.newdeps.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ldcc.designsystem.component.NewDepsNavigationBar
import com.ldcc.designsystem.component.NewDepsNavigationBarItem
import com.ldcc.newdeps.navigation.NewDepsNavHost
import com.ldcc.newdeps.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewDepsApp() {
    val navHostController = rememberNavController()
    val backStackEntry by navHostController.currentBackStackEntryAsState()

    val snackbarHostState = remember { SnackbarHostState() } // question : 이건 왜 달아주는거지?

    Scaffold(
        modifier = Modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            AppBottomBar(
                destination = TopLevelDestination.values().toList(),
                onNavigateToDestination = { destination ->
                    navHostController.navigate(destination.route) {
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                currentDestination = backStackEntry?.destination
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            NewDepsNavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navHostController,
                snackBarHostState = snackbarHostState,
            )
        }
    }
}

@Composable
private fun AppBottomBar(
    destination: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NewDepsNavigationBar(
        modifier = modifier,
    ) {
        destination.forEach { destination ->
            val isSelected = currentDestination?.route == destination.route

            NewDepsNavigationBarItem(
                selected = isSelected,
                onClick = { onNavigateToDestination(destination) },
                unselectedIcon = destination.unselectedIcon,
                selectedIcon = destination.selectedIcon,
                labelId = destination.iconTextId,
                alwaysShowLabel = false,
            )
        }
    }
}