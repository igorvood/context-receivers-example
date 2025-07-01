package ru.vood.context.receivers.example.contextreceiversexample.rest

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext

@Service
class RestClient(val webClient: WebClient)
//    : IRestClient
{

    fun otherFun() {}

//        override fun BusinessContext.callSecond(): SomeData {
    fun BusinessContext.callSecond1(): SomeData {
//         fun callSecond(): SomeData {
        val traceId1 = this.traceId

        val runBlocking = runBlocking {
            webClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/second")
                        .build()
                }
                .headers { headers ->
                    headers.apply { add("TRACE_ID", traceId1) }
                }
                .retrieve()
                .awaitBody<String>()
        }
        return Json.decodeFromString<SomeData>(runBlocking)
    }
}
