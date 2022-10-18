package aaa.bivizul.a37project.ui.root

import aaa.bivizul.a37project.data.repository.HowdoeRepository
import aaa.bivizul.a37project.data.repository.HowdoesRepository
import aaa.bivizul.a37project.ui.item.ItemComponent
import aaa.bivizul.a37project.ui.item.ItemModel
import aaa.bivizul.a37project.ui.list.ListComponent
import aaa.bivizul.a37project.ui.list.ListModel
import aaa.bivizul.a37project.ui.main.MainComponent
import aaa.bivizul.a37project.ui.main.MainModel
import aaa.bivizul.a37project.ui.settings.SettingsComponent
import aaa.bivizul.a37project.ui.settings.SettingsModel
import aaa.bivizul.a37project.ui.howdoep.HowdoepComponent
import aaa.bivizul.a37project.ui.howdoep.HowdoepModel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class RootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : RootModel, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val howdoeRepository = HowdoeRepository()
    val howdoesRepository = HowdoesRepository()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.HowdoepConfig,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, RootModel.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): RootModel.Child =
        when (config) {
            is Config.HowdoepConfig -> RootModel.Child.HowdoepChild(
                setHowdoep(componentContext)
            )
            is Config.MainConfig -> RootModel.Child.MainChild(
                setMain(componentContext)
            )
            is Config.ListConfig -> RootModel.Child.ListChild(
                setList(componentContext)
            )
            is Config.ItemConfig -> RootModel.Child.ItemChild(
                setItem(componentContext, config)
            )
            is Config.SettingsConfig -> RootModel.Child.SettingsChild(
                setSettings(componentContext)
            )
        }

    private fun setHowdoep(
        componentContext: ComponentContext
    ): HowdoepModel = HowdoepComponent(
        componentContext = componentContext,
        context = context,
        howdoeRepository = howdoeRepository,
        onReplaceToMain = {
            navigation.replaceCurrent(Config.MainConfig)
        }
    )

    private fun setMain(
        componentContext: ComponentContext
    ): MainModel = MainComponent(
        componentContext = componentContext,
        onClickList = {
            navigation.push(Config.ListConfig)
        },
        onClickSettings = {
            navigation.push(Config.SettingsConfig)
        }
    )

    private fun setList(
        componentContext: ComponentContext
    ): ListModel = ListComponent(
        componentContext = componentContext,
        howdoesRepository = howdoesRepository,
        onClickListItem = { itemId ->
            navigation.push(Config.ItemConfig(itemId = itemId))
        },
    )

    private fun setItem(
        componentContext: ComponentContext,
        config: Config.ItemConfig
    ): ItemModel = ItemComponent(
        componentContext = componentContext,
        howdoesRepository = howdoesRepository,
        howdoeItemId = config.itemId
    )

    private fun setSettings(
        componentContext: ComponentContext
    ): SettingsModel = SettingsComponent(
        componentContext = componentContext,
    )

    private sealed class Config : Parcelable {
        @Parcelize
        object HowdoepConfig : Config()

        @Parcelize
        object MainConfig : Config()

        @Parcelize
        object ListConfig : Config()

        @Parcelize
        data class ItemConfig(val itemId: Int) : Config()

        @Parcelize
        object SettingsConfig : Config()
    }
}