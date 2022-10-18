package aaa.bivizul.a37project.ui.main

import com.arkivanov.decompose.ComponentContext

class MainComponent(
    componentContext: ComponentContext,
    private val onClickList: () -> Unit,
    private val onClickSettings: () -> Unit,
) : MainModel, ComponentContext by componentContext {

    override fun onClickListModel() {
        onClickList()
    }

    override fun onClickSettingsModel() {
        onClickSettings()
    }

}