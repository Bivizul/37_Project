package aaa.bivizul.a37project.ui.item

import aaa.bivizul.a37project.domain.model.Howdoein
import aaa.bivizul.a37project.ui.howdoewidget.Howdoecp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ItemContent(
    component: ItemModel,
    modifier: Modifier = Modifier
) {

    val howdoeItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
    val scrollState = rememberScrollState()

    if (howdoeItemList != null) {
        howdoeItemList?.let { list ->
            list[model.selectedHowdoeItemId - 1].let { item ->
                LazyColumn(
                    modifier = modifier
//                        .verticalScroll(scrollState)
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Column {
                            Text(
                                text = item.howdoetit,
                                modifier = modifier.padding(vertical = 8.dp),
                                style = MaterialTheme.typography.h4
                            )
                            Text(
                                text = item.howdoedesc,
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                    if (item.howdoein != emptyList<Howdoein>()) {
                        items(item.howdoein) {
                            Column {
                                Text(
                                    text = it.howdoesubtit,
                                    modifier = modifier.padding(vertical = 8.dp),
                                    style = MaterialTheme.typography.h5
                                )
                                Text(
                                    text = it.howdoesubdesc,
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        Howdoecp(modifier = modifier)
    }
}