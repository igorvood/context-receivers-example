package ru.vood.context.receivers.example.contextreceiversexample.context

import kotlinx.coroutines.withContext
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

//fun <BC, R: IBusinessContext> BC.withBusiness(block: suspend BC.() -> R ){
//
//    with("Q"){}
//}

@OptIn(ExperimentalContracts::class)
public inline fun <T: IBusinessContext, R> withBusiness(receiver: T, block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return receiver.block()
}