package aaa.bivizul.a37project.ui.main

import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEAN
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(
    component: MainModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(16.dp).fillMaxSize(),
    ) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Settings",
            modifier = modifier
                .clickable { component.onClickSettingsModel() }
                .align(Alignment.TopEnd),
        )
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = HOWDOEAN,
                modifier = modifier,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Next page > > >",
                modifier = modifier
                    .clickable { component.onClickListModel() },
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center
            )
        }
    }
}