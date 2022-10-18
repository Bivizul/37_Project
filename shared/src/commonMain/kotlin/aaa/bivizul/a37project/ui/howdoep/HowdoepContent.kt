package aaa.bivizul.a37project.ui.howdoep

import aaa.bivizul.a37project.domain.model.Howdoevar
import aaa.bivizul.a37project.domain.util.getHowdoeact
import aaa.bivizul.a37project.domain.util.sigHowdoeoff
import aaa.bivizul.a37project.ui.howdoewidget.Howdoecp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun HowdoepContent(
    component: HowdoepModel,
    modifier: Modifier = Modifier
) {

    val howdoeg by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    howdoeg?.howdoeg?.let {
        if (it == Howdoevar.HDNO.hd) {
            component.onReplace()
        } else if (it == Howdoevar.HDNP.hd) {
            sigHowdoeoff()
            component.onReplace()
        } else {
            getHowdoeact(model.activity, it)
        }
    }
    Howdoecp(modifier = modifier)
}