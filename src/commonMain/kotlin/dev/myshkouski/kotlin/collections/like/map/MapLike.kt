package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.IteratorLike
import dev.myshkouski.kotlin.collections.like.iterator.toIterable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Interface for generic map-like data structures.
 *
 * @param K type for keys
 * @param V type for values
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
interface MapLike<K, out V> {
    val size: Int
    val keys: IteratorLike<K>
    val values: IteratorLike<V>
    val entries: IteratorLike<PairLike<K, V>>

    operator fun get(key: K): V?
    fun has(key: K): Boolean
}

expect fun <K, V> mapLikeOf(vararg pairs: PairLike<K, V>): MapLike<K, V>
expect fun <K, V> mapLikeOf(vararg pairs: Pair<K, V>): MapLike<K, V>

expect fun <K, V> MapLike<K, V>.toMapLike(): MapLike<K, V>

fun <K, V> MapLike<K, V>.toMap(): Map<K, V> {
    return entries.toIterable().associate { it.toPair() }
}

fun <K, V> Map<K, V>.toMapLike(): MapLike<K, V> {
    return mapLikeOf(*entries.map { it.toPair() }.toTypedArray())
}
