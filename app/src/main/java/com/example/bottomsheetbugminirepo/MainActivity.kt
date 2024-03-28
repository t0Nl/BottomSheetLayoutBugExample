package com.example.bottomsheetbugminirepo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bottomsheetbugminirepo.ui.theme.BottomSheetBugMiniRepoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetBugMiniRepoTheme {
                // A surface container using the 'background' color from the theme
                val bottomSheetState = rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden,
                    skipHalfExpanded = true
                )
                val scope = rememberCoroutineScope()
                var bottomSheetAltModeEnabled by remember {
                    mutableStateOf(true)
                }


                HSModalBottomSheetLayout(
                    sheetState = bottomSheetState,
                    sheetContent = {
                        BottomSheetContent(
                            bottomSheetAltModeEnabled = bottomSheetAltModeEnabled
                        )
                    },
                    content = {
                        MainContent(
                            scope = scope,
                            openTextSheet = {
                                bottomSheetAltModeEnabled = false
                                scope.launch {
                                    bottomSheetState.show()
                                }
                            },
                            openHeartsSheet = {
                                bottomSheetAltModeEnabled = true
                                scope.launch {
                                    bottomSheetState.show()
                                }
                            }
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HSModalBottomSheetLayout(
    sheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
    BackHandler(sheetState.isVisible) {
        coroutineScope.launch {
            sheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = sheetContent,
        sheetShape = MaterialTheme.shapes.small,
        sheetBackgroundColor = MaterialTheme.colors.background,
        sheetContentColor = MaterialTheme.colors.primary,
        scrimColor = MaterialTheme.colors.surface.copy(alpha = .5f),
        content = content,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent(
    scope: CoroutineScope,
    openTextSheet: () -> Unit,
    openHeartsSheet: () -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(false, {})

    Surface(
        modifier = Modifier,
        color = backgroundColor,
        contentColor = MaterialTheme.colors.primary
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    bottom = 16.dp,
                ),
            ) {
                item {
                    Text("Rest of the UI")
                    Spacer(Modifier.height(20.dp))
                    Button(onClick = { openTextSheet() }) {
                        Text("Click to show Text Sheet")
                    }
                    Spacer(Modifier.height(20.dp))
                    Button(onClick = { openHeartsSheet() }) {
                        Text("Click to show Hearts Sheet")
                    }
                }
            }
        }
    }
}

@Composable
fun BottomSheetContent(
    bottomSheetAltModeEnabled: Boolean,
) {
    if (bottomSheetAltModeEnabled) {
        Column(modifier = Modifier) {

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            }
        }
    } else {
        Column(modifier = Modifier) {

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text("Click to show sheet")
                Text("Click to show sheet")
                Text("Click to show sheet")
                Text("Click to show sheet")
                Text("Click to show sheet")
                Text("Click to show sheet")
            }
        }
    }
}
