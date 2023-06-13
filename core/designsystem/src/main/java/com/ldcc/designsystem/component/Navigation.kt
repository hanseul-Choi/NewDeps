package com.ldcc.designsystem.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 *  NavigationRailItem
 *
 *  @param selected 아이템 선택 여부 확인
 *  @param onClick 아이템 클릭 시 제공되는 콜백
 *  @param icon 아이템 아이콘 정보
 *  @param modifier 아이템의 Modifier
 *  @param selectedIcon 선택되었을 때, 아이콘
 *  @param enabled enable 상태 관리 변수, false이면 클릭이 안되고 disable의 UI가 표시됨
 *  @param label 아이템의 텍스트 레이블
 *  @param alwaysShowLabel 텍스트 레이블을 항상 보여줄 것인지 표기
 */
@Composable
fun NewDepsNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = NewDepsNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = NewDepsNavigationDefaults.navigationContentColor(),
            selectedTextColor = NewDepsNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = NewDepsNavigationDefaults.navigationContentColor(),
            indicatorColor = NewDepsNavigationDefaults.navigationIndicatorColor()
        )
    )
}

@Composable
fun NewDepsNavigationRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = NewDepsNavigationDefaults.navigationContentColor(),
        header = header,
        content = content
    )
}

object NewDepsNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
