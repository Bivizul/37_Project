package aaa.bivizul.a37project.ui.list

import aaa.bivizul.a37project.ui.howdoewidget.HowdoeButton
import aaa.bivizul.a37project.ui.howdoewidget.Howdoecp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val howdoeItemList by component.state.collectAsState()

    if (howdoeItemList != null) {
        howdoeItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(list) { howdoeItem ->
                    HowdoeButton(
                        onClick = { component.onClickListItemModel(id = howdoeItem.id) },
                        text = howdoeItem.howdoetit
                    )
                }
            }
        }
    } else {
        Howdoecp(modifier = modifier)
    }

}