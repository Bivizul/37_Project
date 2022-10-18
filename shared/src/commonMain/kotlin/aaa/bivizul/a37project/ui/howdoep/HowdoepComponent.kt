package aaa.bivizul.a37project.ui.howdoep

import aaa.bivizul.a37project.data.repository.HowdoeRepository
import aaa.bivizul.a37project.domain.model.Howdoe
import aaa.bivizul.a37project.domain.model.Howdoeg
import aaa.bivizul.a37project.domain.util.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class HowdoepComponent(
    componentContext: ComponentContext,
    context: Any,
    howdoeRepository: HowdoeRepository,
    private val onReplaceToMain: () -> Unit
) : HowdoepModel, ComponentContext by componentContext {

    private val _models = MutableValue(HowdoepModel.Model(activity = context))
    override val models: Value<HowdoepModel.Model> = _models
    override val state: StateFlow<Howdoeg?> = howdoeRepository.howdoeg

    init {
        try {
            howdoeRepository.getHowdoeg(
                Howdoe(
                    getHowdoemm(),
                    getHowdoesim(context),
                    getHowdoeid(context),
                    getHowdoel(),
                    getHowdoet()
                )
            )
        } catch (e: Exception) {
            getHowdoedlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToMain()
    }

}