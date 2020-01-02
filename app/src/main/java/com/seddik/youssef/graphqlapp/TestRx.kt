package com.seddik.youssef.graphqlapp

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import java.util.*

fun main() {
    val ep1 = "eposed1"
    val ep2 = "eposed2"
    val ep3 = "eposed3"

    val observable  = Observable.just(ep1, ep2, ep3)

    observable.subscribeBy(
        onNext = { println(it) },
        onComplete = { println("Observable completed") }
    )



}