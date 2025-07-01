package ru.vood.context.receivers.example.contextreceiversexample.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(val restClient: RestClient) {

    @GetMapping("/one")
    fun req_1(): SomeData {
        return restClient.callSecond()
    }

    @GetMapping("/second")
    fun req_2(
        @RequestHeader("TRACE_ID", required = true) traceId: String,
    ): SomeData {
        return SomeData("second $traceId")
    }

}