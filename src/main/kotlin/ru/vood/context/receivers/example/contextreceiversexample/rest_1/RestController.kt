package ru.vood.context.receivers.example.contextreceiversexample.rest_1

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.DealContext
import ru.vood.context.receivers.example.contextreceiversexample.context.withBusiness
import ru.vood.context.receivers.example.contextreceiversexample.rest.SomeData

@RestController
class ARestControllerEx(
    val restClient: ARestClient,
    val service_1: AService_1

) {

    @GetMapping("/oner")
    fun req_1(): SomeData {
        service_1.callNext()

        return with(restClient) {
            withBusiness(BusinessContext("QWERTY")) {
                withBusiness(DealContext("REAL")) {
//                val callSecond = callSecond(restClient.webClient)
                    callSecond()
                }
            }
        }
    }

    @GetMapping("/secondr")
    fun req_2(
        @RequestHeader("TRACE_ID", required = true) traceId: String,
    ): ResponseEntity<SomeData> {

        val ok = ResponseEntity
            .status(HttpStatus.OK)
            .headers { httpHeaders -> httpHeaders.set("TRACE_ID", traceId) }
            .body(SomeData("secondr $traceId"))


        return ok
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ARestControllerEx::class.java)
    }
}