package aaa.bivizul.a37project.data.repository

import aaa.bivizul.a37project.data.network.HowdoeApi
import aaa.bivizul.a37project.domain.model.Howdoe
import aaa.bivizul.a37project.domain.model.Howdoeg
import aaa.bivizul.a37project.domain.util.howdoeIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HowdoeRepository {

    private val howdoeApi = HowdoeApi()
    private val howdoejob = SupervisorJob()
    private val howdoescope = CoroutineScope(howdoeIoDispatcher + howdoejob)

    private val _howdoeg = MutableStateFlow<Howdoeg?>(null)
    val howdoeg: StateFlow<Howdoeg?> = _howdoeg.asStateFlow()

    fun getHowdoeg(howdoe: Howdoe) {
        howdoescope.launch {
            val response = howdoeApi.getHowdoeg(howdoe)
            _howdoeg.emit(response)
        }
    }

}