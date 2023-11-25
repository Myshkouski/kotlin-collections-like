package dev.myshkouski.kotlin.collections.like.map

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
interface PairLike<out K, out V> {
    val key: K
    val value: V
}

operator fun <K, V> PairLike<K, V>.component1(): K = key
operator fun <K, V> PairLike<K, V>.component2(): V = value

fun <K, V> PairLike<K, V>.toPair(): Pair<K, V> = key to value
