package ru.vood.context.receivers.example.contextreceiversexample.rest

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class RestClient (val webClient: WebClient) {
}
