package ru.vood.context.receivers.example.contextreceiversexample.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.withBusiness

@RestController
class RestController(val restClient: RestClient) {

    @GetMapping("/one")
    fun req_1(): SomeData {
        val withBusiness = withBusiness(BusinessContext("qwewq")) {

            val message = this@withBusiness
            println(message)
            val callSecond = callSecond(restClient.webClient)
            callSecond
        }
        return withBusiness
    }

    @GetMapping("/second")
    fun req_2(
        @RequestHeader("TRACE_ID", required = true) traceId: String,
    ): SomeData {
        return SomeData("second $traceId")
    }

}