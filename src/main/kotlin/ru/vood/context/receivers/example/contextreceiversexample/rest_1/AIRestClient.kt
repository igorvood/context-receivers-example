package ru.vood.context.receivers.example.contextreceiversexample.rest_1

import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext
import ru.vood.context.receivers.example.contextreceiversexample.context.DealContext
import ru.vood.context.receivers.example.contextreceiversexample.rest.SomeData

interface AIRestClient {
    context(BusinessContext, DealContext)
    fun callSecond(): SomeData
}