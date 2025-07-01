package ru.vood.context.receivers.example.contextreceiversexample.rest

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class Service_1(val service_2: Service_2) {

    fun callNext() {
        service_2.callNext()
    }

}

@Service
class Service_2(val service_3: Service_3) {

    fun callNext() {
        service_3.callNext()
    }

}

@Service
class Service_3() {

    fun callNext() {
        LOGGER.info("Service_3_1")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Service_3::class.java)
    }
}