package ru.vood.context.receivers.example.contextreceiversexample.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {

    @GetMapping("/one")
    fun req_1(): SomeData {

        return SomeData("one")
    }
}