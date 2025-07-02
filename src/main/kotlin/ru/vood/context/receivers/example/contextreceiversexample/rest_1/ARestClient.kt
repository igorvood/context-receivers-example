package ru.vood.context.receivers.example.contextreceiversexample.rest_1

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.DealContext
import ru.vood.context.receivers.example.contextreceiversexample.rest.SomeData

@Service
class ARestClient(val webClient: WebClient) : AIRestClient {

    fun otherFun() {}

    context(BusinessContext, DealContext)
    override fun callSecond(): SomeData {

//    fun callSecond1(): SomeData {
//         fun callSecond(): SomeData {
        val traceId1 = traceId

        val runBlocking = runBlocking {
            webClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/secondr")
                        .build()
                }
                .headers { headers ->
                    headers.apply {
                        add("TRACE_ID", traceId1)
                        add("DEAL_ID", dealId)
                    }
                }
                .retrieve()
                .awaitBody<String>()
        }
        return Json.decodeFromString<SomeData>(runBlocking)
    }
}
