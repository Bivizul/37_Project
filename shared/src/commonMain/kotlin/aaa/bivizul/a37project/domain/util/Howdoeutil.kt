package aaa.bivizul.a37project.domain.util

import kotlin.coroutines.CoroutineContext

internal expect val howdoeIoDispatcher: CoroutineContext
internal expect val howdoeUiDispatcher: CoroutineContext

internal expect fun getHowdoemm(): String
internal expect fun getHowdoesim(howdoecon: Any): String
internal expect fun getHowdoeid(howdoecon: Any): String
internal expect fun getHowdoel(): String
internal expect fun getHowdoet(): String
internal expect fun getHowdoedlg(howdoecon: Any)
internal expect fun checkHowdoenet(howdoecon: Any): Boolean
internal expect fun sigHowdoeoff()
internal expect fun getHowdoeact(howdoeact: Any, howdoeurl: String)