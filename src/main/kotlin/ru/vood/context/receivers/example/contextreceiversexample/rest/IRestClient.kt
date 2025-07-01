package ru.vood.context.receivers.example.contextreceiversexample.rest

import ru.vood.context.receivers.example.contextreceiversexample.context.BusinessContext

interface IRestClient {

    fun BusinessContext.callSecond(): SomeData
}