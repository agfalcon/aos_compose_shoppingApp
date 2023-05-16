package kgb.plum.app.ui

import androidx.annotation.DrawableRes
import kgb.plum.app.R

sealed class MainNavigationItem(var name: String, var route: String, @DrawableRes var res: Int) {
    object Main: MainNavigationItem(name = "Main", route = "Main", res = R.drawable.baseline_home_24)
    object Category: MainNavigationItem(name = "Category", route = "Category", res = R.drawable.baseline_category_24)
    object MyPage: MainNavigationItem(name = "MyPage", route = "MyPage", res = R.drawable.baseline_account_circle_24)
}