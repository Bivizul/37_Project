package aaa.bivizul.a37project.ui.list

import aaa.bivizul.a37project.data.repository.HowdoesRepository
import aaa.bivizul.a37project.domain.model.Howdoes
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ListComponent(
    componentContext: ComponentContext,
    howdoesRepository: HowdoesRepository,
    private val onClickListItem: (id: Int) -> Unit,
) : ListModel, ComponentContext by componentContext {

    override val state: StateFlow<List<Howdoes>?> = howdoesRepository.howdoesList

    override fun onClickListItemModel(id: Int) {
        onClickListItem(id)
    }
}