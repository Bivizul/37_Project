package aaa.bivizul.a37project.data.repository

import aaa.bivizul.a37project.data.network.HowdoeApi
import aaa.bivizul.a37project.domain.model.Howdoes
import aaa.bivizul.a37project.domain.util.howdoeIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HowdoesRepository {

    private val howdoeApi = HowdoeApi()
    private val howdoejob = SupervisorJob()
    private val howdoescope = CoroutineScope(howdoeIoDispatcher + howdoejob)

    private val _howdoeItemList = MutableStateFlow<List<Howdoes>?>(null)
    val howdoesList: StateFlow<List<Howdoes>?> = _howdoeItemList.asStateFlow()

    init {
        getHowdoeItem()
    }

    fun getHowdoeItem() {
        howdoescope.launch {
            val response = howdoeApi.getHowdoeItem()
            _howdoeItemList.emit(response)
        }
    }

}