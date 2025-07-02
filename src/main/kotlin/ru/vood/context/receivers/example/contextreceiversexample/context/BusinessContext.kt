package ru.vood.context.receivers.example.contextreceiversexample.context

data class BusinessContext(val traceId: String) : IBusinessContext


data class DealContext(val dealId: String) : IBusinessContext


