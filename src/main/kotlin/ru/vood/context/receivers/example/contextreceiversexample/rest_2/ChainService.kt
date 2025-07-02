package ru.vood.context.receivers.example.contextreceiversexample.rest_2

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.DealContext

@Service
class BService_1(val service_2: BService_2) {

    context(bs: BusinessContext, dc: DealContext)
    fun callNext() {
        service_2.callNext()
    }

}

@Service
class BService_2(val service_3: BService_3) {

    context(bs: BusinessContext, dc: DealContext)
    fun callNext() {
        service_3.callNext()
    }

}

@Service
class BService_3() {

    context(bs: BusinessContext, dc: DealContext)
    fun callNext() {
        LOGGER.info("Service_3_1")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(BService_3::class.java)
    }
}