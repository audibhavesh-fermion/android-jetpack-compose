package com.fermion.android.base.view.component


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fermion.android.base.R
import com.fermion.android.base.view.navigation.currentRoute


@Composable
fun ExitAlertDialog(
    routeName: String,
    navController: NavController,
    cancel: (isOpen: Boolean) -> Unit,
    ok: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }
    if (currentRoute(navController = navController) == routeName && openDialog.value) {
        AlertDialog(
            onDismissRequest = {
            },
            // below line is use to display title of our dialog
            // box and we are setting text color to white.
            title = {
                Text(
                    text = stringResource(R.string.close_the_app),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            },
            text = {
                Text(text = stringResource(R.string.do_you_want_to_exit_the_app), fontSize = 16.sp)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        ok()
                    }) {
                    Text(
                        stringResource(R.string.yes),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        cancel(false)
                    }) {
                    Text(
                        stringResource(R.string.no),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black)
                    )
                }
            },
        )
    }
}


@Composable
fun MessageDialog(
    message: String,
    boxTitle: String = "",
    routeName: String,
    navController: NavController,
    cancel: (isOpen: Boolean) -> Unit,
    ok: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }
    if (currentRoute(navController = navController) == routeName && openDialog.value) {
        AlertDialog(
            onDismissRequest = {
            },
            // below line is use to display title of our dialog
            // box and we are setting text color to white.
            title = {
                Text(
                    text = if (boxTitle.isNotEmpty()) boxTitle else stringResource(R.string.message),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            },
            text = {
                Text(text = message, fontSize = 16.sp)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        ok()
                    }) {
                    Text(
                        stringResource(R.string.ok),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        cancel(false)
                    }) {
                    Text(
                        stringResource(R.string.close),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black)
                    )
                }
            },
        )
    }
}