package ru.vood.context.receivers.example.contextreceiversexample.rest_2

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.DealContext
import ru.vood.context.receivers.example.contextreceiversexample.rest.SomeData

@Service
class BRestClient(val webClient: WebClient) : BIRestClient {



    context(bs: BusinessContext, dc: DealContext)
    override fun callSecond(): SomeData {

//    fun callSecond1(): SomeData {
//         fun callSecond(): SomeData {
        val traceId1 = bs.traceId

        val runBlocking = runBlocking {
            webClient
                .get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/seconds")
                        .build()
                }
                .headers { headers ->
                    headers.apply {
                        add("TRACE_ID", traceId1)
                        add("DEAL_ID", dc.dealId)
                    }
                }
                .retrieve()
                .awaitBody<String>()
        }
        return Json.decodeFromString<SomeData>(runBlocking)
    }
}
