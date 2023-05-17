@file:OptIn(ExperimentalMaterial3Api::class)

package kgb.plum.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kgb.plum.app.R
import kgb.plum.app.ui.theme.ShoppingAppTheme
import kgb.plum.app.viewmodel.MainViewModel

@Preview
@Composable
fun MainScreenPreview(){
    ShoppingAppTheme {
        MainScreen()
    }
}


@Composable
fun MainScreen(){
    val viewModel = hiltViewModel<MainViewModel>()
    val navController = rememberNavController()
    Scaffold (
        topBar = {
            Header(viewModel)
        },
        bottomBar = {
            MainBottomNavigationBar(navController)
        },
    ){
        it
        MainNavigationScreen(navController)
    }
}

@Composable
fun Header(viewModel: MainViewModel) {
    TopAppBar(
        title = {
            Text("ShoppingApp")
        },
        actions = {
            IconButton(
                onClick = {
                    viewModel.openSearchForm()
                },
                modifier = Modifier.padding(end = 4.dp)
            ){
                Icon(Icons.Filled.Search, "Search")
            }
        }
    )
}

@Composable
fun MainBottomNavigationBar(navController: NavHostController) {

    val bottomNavigationItems = listOf(
        MainNavigationItem.Main,
        MainNavigationItem.Category,
        MainNavigationItem.MyPage
    )

    NavigationBar(
        containerColor = Color(0xffff0000),
        contentColor = Color(0xff00ff00)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach {item ->
            NavigationBarItem(
                icon = {
                       Column(
                           horizontalAlignment = Alignment.CenterHorizontally
                       ){
                           Icon(painterResource(id = item.res), item.name)
                           Text(item.name)
                       }
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState  = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainNavigationScreen(navController : NavHostController) {
    NavHost(navController = navController, startDestination = MainNavigationItem.Main.route) {
        composable(route = MainNavigationItem.Main.route){
            Text("This is Main")
        }
        composable(route = MainNavigationItem.Category.route){
            Text("This is Category")
        }
        composable(route = MainNavigationItem.MyPage.route){
            Text("This is MyPage")
        }
    }
}