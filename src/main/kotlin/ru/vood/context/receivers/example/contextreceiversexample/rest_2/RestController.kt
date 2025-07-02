package ru.vood.context.receivers.example.contextreceiversexample.rest_2

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
class BRestControllerEx(
    val restClient: BRestClient,
    val service_1: BService_1

) {

    @GetMapping("/ones")
    fun req_1(): SomeData {
//        service_1.callNext()

        return with(restClient) {
            withBusiness(BusinessContext("QWERTY")) {
                withBusiness(DealContext("REAL")) {
                    service_1.callNext()
                    callSecond()
                }
            }
        }
    }

    @GetMapping("/seconds")
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
        private val LOGGER = LoggerFactory.getLogger(BRestControllerEx::class.java)
    }
}