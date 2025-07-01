package ru.vood.context.receivers.example.contextreceiversexample.rest

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.withBusiness

@RestController
class RestControllerEx(
    val restClient: RestClient,
    val service_1: Service_1

) {

    @GetMapping("/one")
    fun req_1(): SomeData {
        service_1.callNext()

        return with(restClient) {
            withBusiness(BusinessContext("QWERTY")) {
//                val callSecond = callSecond(restClient.webClient)
                callSecond1()
            }
        }
    }

    @GetMapping("/second")
    fun req_2(
        @RequestHeader("TRACE_ID", required = true) traceId: String,
    ): ResponseEntity<SomeData> {

        val ok = ResponseEntity
            .status(HttpStatus.OK)
            .headers { httpHeaders -> httpHeaders.set("TRACE_ID", traceId) }
            .body(SomeData("second $traceId"))


        return ok
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(RestControllerEx::class.java)
    }
}