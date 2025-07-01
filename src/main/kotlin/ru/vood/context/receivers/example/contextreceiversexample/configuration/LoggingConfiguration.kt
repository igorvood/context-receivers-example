package ru.vood.context.receivers.example.contextreceiversexample.configuration

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.Correlation
import org.zalando.logbook.HttpLogWriter
import org.zalando.logbook.Precorrelation

@Configuration
open class LoggingConfiguration {

    @Bean
    open fun restTemplate(): HttpLogWriter{
        return RestLogWriter()
    }
}

class RestLogWriter: HttpLogWriter{
    override fun write(precorrelation: Precorrelation, request: String) {
        LOGGER.info("==============================================================================================")
        LOGGER.info("Request\n$request")

    }

    override fun write(correlation: Correlation, response: String) {
        LOGGER.info("==============================================================================================")
        LOGGER.info("Response\n$response")
    }


    companion object{
        private val LOGGER = LoggerFactory.getLogger(RestLogWriter::class.java)
    }
}