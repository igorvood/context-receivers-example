package ru.vood.context.receivers.example.contextreceiversexample.rest

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class RestClient (val webClient: WebClient) {

    fun callSecond(): SomeData {
        val runBlocking = runBlocking {
            webClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/second")
                        .build()
                }
                .headers { headers ->
                    headers.apply { add("TRACE_ID", "1") }

                }
                .retrieve()
                .awaitBody<String>()
        }
        return Json.decodeFromString<SomeData>(runBlocking)
    }
}
