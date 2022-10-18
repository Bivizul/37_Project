package aaa.bivizul.a37project.android

import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEOSAI
import android.app.Application
import com.onesignal.OneSignal

class A37PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(HOWDOEOSAI)

    }

}