package com.ldcc.newdeps.navigation

import com.ldcc.designsystem.icon.AppIcons
import com.ldcc.designsystem.icon.IconWrapper
import com.ldcc.designsystem.icon.IconWrapper.ImageVectorIcon
import kr.chs.feature.test1.navigation.test1NavigationRoute
import kr.chs.feature.test2.navigation.test2NavigationRoute
import kr.chs.feature.test1.R as test1R
import kr.chs.feature.test2.R as test2R

/**
 *  question : enum class와 sealed class -> 왜 sealed class로 하면 안되는가? (nowInAndroid도 enum으로 함..)
 *
 *  enum : Single Instance, 최초로 설정한 값 이외로 변경이 어려움
 *  sealed class : 여러 개의 Instance, 자기 자신을 상속시켜 서브 타입을 제한함, 기본적으로 abstract class
 *  sealed interface : sealed interface를 구현하는데에 꼭 동일한 파일에 있을 필요가 없음 (실드 클래스는 동일한 파일에 있어야함) - 실드 클래스 생성자를 개별로 가짐
 */
enum class TopLevelDestination(
    val route: String,
    val selectedIcon: IconWrapper,
    val unselectedIcon: IconWrapper,
    val iconTextId: Int,
) {
    Test1(
        test1NavigationRoute,
        ImageVectorIcon(AppIcons.SearchFilled),
        ImageVectorIcon(AppIcons.Search),
        test1R.string.test1_icon_text
    ),

    Test2(
        test2NavigationRoute,
        ImageVectorIcon(AppIcons.FavoriteFilled),
        ImageVectorIcon(AppIcons.Favorite),
        test2R.string.test2_icon_text
    )
}