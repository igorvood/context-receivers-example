package ru.vood.context.receivers.example.contextreceiversexample.rest_1

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AService_1(val service_2: AService_2) {

    fun callNext() {
        service_2.callNext()
    }

}

@Service
class AService_2(val service_3: AService_3) {

    fun callNext() {
        service_3.callNext()
    }

}

@Service
class AService_3() {

    fun callNext() {
        LOGGER.info("Service_3_1")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(AService_3::class.java)
    }
}