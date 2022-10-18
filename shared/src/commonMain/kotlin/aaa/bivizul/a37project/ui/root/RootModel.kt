package aaa.bivizul.a37project.ui.root

import aaa.bivizul.a37project.ui.item.ItemModel
import aaa.bivizul.a37project.ui.list.ListModel
import aaa.bivizul.a37project.ui.main.MainModel
import aaa.bivizul.a37project.ui.settings.SettingsModel
import aaa.bivizul.a37project.ui.howdoep.HowdoepModel
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootModel {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class HowdoepChild(val component: HowdoepModel) : Child()
        class MainChild(val component: MainModel) : Child()
        class ListChild(val component: ListModel) : Child()
        class ItemChild(val component: ItemModel) : Child()
        class SettingsChild(val component: SettingsModel) : Child()
    }

}