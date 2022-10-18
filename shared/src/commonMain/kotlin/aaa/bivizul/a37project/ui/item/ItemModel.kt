package aaa.bivizul.a37project.ui.item

import aaa.bivizul.a37project.domain.model.Howdoes
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemModel {

    val models: Value<Model>

    val state: StateFlow<List<Howdoes>?>

    data class Model(
        val selectedHowdoeItemId: Int
    )

}