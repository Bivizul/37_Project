package aaa.bivizul.a37project.ui.item

import aaa.bivizul.a37project.data.repository.HowdoesRepository
import aaa.bivizul.a37project.domain.model.Howdoes
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemComponent(
    componentContext: ComponentContext,
    howdoesRepository: HowdoesRepository,
    howdoeItemId: Int,
) : ItemModel, ComponentContext by componentContext {

    private val _models = MutableValue(ItemModel.Model(selectedHowdoeItemId = howdoeItemId))
    override val models: Value<ItemModel.Model> = _models

    override val state: StateFlow<List<Howdoes>?> =
        howdoesRepository.howdoesList

}