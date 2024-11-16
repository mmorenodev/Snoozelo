package dev.mmoreno.snoozelo.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.mmoreno.snoozelo.R
import dev.mmoreno.snoozelo.navigation.DestinationType

@Composable
fun SnoozeloTopAppBar(
    destinationType: DestinationType
) {
    when (destinationType) {
        is DestinationType.PrimaryDestination -> {
            SnoozeloPrimaryTopAppBar(
                stringResource(R.string.your_alarms_screen_title)
            )
        }

        is DestinationType.SecondaryDestination -> {
            SnoozeloSecondaryAppBar(
                onNavigationIconClick = destinationType.onNavigationIconClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnoozeloPrimaryTopAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(title) },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnoozeloSecondaryAppBar(
    onNavigationIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Close, null)
            }
        },
        actions = {

        })
}