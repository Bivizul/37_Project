package aaa.bivizul.a37project.ui.howdoep

import aaa.bivizul.a37project.domain.model.Howdoeg
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface HowdoepModel {

    val models: Value<Model>
    val state: StateFlow<Howdoeg?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}