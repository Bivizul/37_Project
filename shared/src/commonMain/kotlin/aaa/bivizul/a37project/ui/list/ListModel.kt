package aaa.bivizul.a37project.ui.list

import aaa.bivizul.a37project.domain.model.Howdoes
import kotlinx.coroutines.flow.StateFlow

interface ListModel {

    val state: StateFlow<List<Howdoes>?>

    fun onClickListItemModel(id: Int)

}