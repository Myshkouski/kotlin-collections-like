package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.Destination
import dev.myshkouski.kotlin.collections.like.iterator.IteratorLike
import js.array.JsTuple2

@OptIn(ExperimentalJsExport::class)
@JsExport
class MutableMapLikeImpl<K, V>(vararg values: JsTuple2<K, V>) : AbstractMapLike<K, V>(*values), MutableMapLike<K, V> {
    override fun set(key: K, value: V) {
        map[key] = value
    }

    override fun delete(key: K) {
        map.delete(key)
    }
}

actual fun <K, V> mutableMapLikeOf(vararg pairs: PairLike<K, V>): MutableMapLike<K, V> = MutableMapLikeImpl(*pairs.toJsTuples())

actual fun <K, V> mutableMapLikeOf(vararg pairs: Pair<K, V>): MutableMapLike<K, V> = MutableMapLikeImpl(*pairs.toJsTuples())

private fun <T> IteratorLike<T>.collectTo(destination: Destination<T>) {
    while (hasNext()) {
        val value = next()
        destination.put(value)
    }
}

actual fun <K, V> MapLike<K, V>.toMutableMapLike(): MutableMapLike<K, V> {
    val destination: MutableMapLike<K, V> = MutableMapLikeImpl()
    entries.collectTo(destination)
    return destination
}

actual fun <K, V> MapLike<K, V>.toMapLike(): MapLike<K, V> = toMutableMapLike()
