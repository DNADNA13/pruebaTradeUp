package dev.luischang.appdpa.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.luischang.appdpa.data.model.OfferModel
import dev.luischang.appdpa.presentation.auth.LoginScreen
import dev.luischang.appdpa.presentation.auth.RegisterScreen
import dev.luischang.appdpa.presentation.home.ExploreOffersScreen
import dev.luischang.appdpa.presentation.home.HomeScreen
import dev.luischang.appdpa.presentation.home.MisPropuestasScreen
import dev.luischang.appdpa.presentation.home.OfferDetailScreen
import dev.luischang.appdpa.presentation.permissions.GalleryPermissionScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "explore_offers")
    {
        composable("register") { RegisterScreen(navController) }
        composable("login") { LoginScreen(navController) }

        composable("home") {
            DrawerScaffold(navController) {
                HomeScreen()
            }
        }
        composable ("permissions") {
            DrawerScaffold(navController) {
                GalleryPermissionScreen()
            }
        }
        composable ("favorites") {
            DrawerScaffold(navController) {
                Text("Proximamente pantalla favoritos.....")
            }
        }
        composable("explore_offers") {
            DrawerScaffold(navController) {
                ExploreOffersScreen(navController)
            }
        }
        composable("offer_detail") {
            val offer = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<OfferModel>("offer") //OfferModel debe ser Serializable o Parcelable, para poder pasarlo entre pantallas.

            offer?.let {
                DrawerScaffold(navController) {
                    OfferDetailScreen(navController, offer = it)
                }
            }
        }
        composable("mis_propuestas") {
            MisPropuestasScreen(navController)
        }

    }
}