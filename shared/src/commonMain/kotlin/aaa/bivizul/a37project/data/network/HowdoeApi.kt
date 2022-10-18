package aaa.bivizul.a37project.data.network

import aaa.bivizul.a37project.domain.model.Howdoe
import aaa.bivizul.a37project.domain.model.Howdoeg
import aaa.bivizul.a37project.domain.model.Howdoes
import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEBASEURL
import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEGURL
import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEITEMURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class HowdoeApi {

    val howdoehc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    private fun HttpRequestBuilder.howdoebase(path: String) {
        url {
            takeFrom(HOWDOEBASEURL)
            encodedPath = path
        }
    }

    suspend fun getHowdoeItem(): List<Howdoes> {
        val gethowdoeitemurl = HOWDOEITEMURL
        val howdoehr = howdoehc.get { howdoebase(gethowdoeitemurl) }
        val gethowdoeitembody = howdoehr.body<List<Howdoes>>()
        return gethowdoeitembody
    }

    suspend fun getHowdoeg(howdoe: Howdoe): Howdoeg {
        val gethowdoeurl = HOWDOEGURL
        val howdoehr = howdoehc.post {
            howdoebase(gethowdoeurl)
            contentType(Json)
            setBody(howdoe)
        }
        val gethowdoebody = howdoehr.body<Howdoeg>()
        return gethowdoebody
    }

}