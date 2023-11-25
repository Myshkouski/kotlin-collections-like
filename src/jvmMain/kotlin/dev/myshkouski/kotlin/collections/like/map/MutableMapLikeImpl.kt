package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

private class MutableMapLikeImpl<K, V>(vararg pairs: Pair<K, V>) : AbstractMapLike<K, V>(), MutableMapLike<K, V> {
    override val map: MutableMap<K, V> = mutableMapOf(*pairs)

    override fun set(key: K, value: V) {
        map[key] = value
    }

    override fun delete(key: K) {
        map.remove(key)
    }
}

actual fun <K, V> mutableMapLikeOf(vararg pairs: Pair<K, V>): MutableMapLike<K, V> = MutableMapLikeImpl(*pairs)
actual fun <K, V> mutableMapLikeOf(vararg pairs: PairLike<K, V>): MutableMapLike<K, V> = MutableMapLikeImpl(*pairs.map { it.toPair() }.toTypedArray())

actual fun <K, V> MapLike<K, V>.toMutableMapLike(): MutableMapLike<K, V> = MutableMapLikeImpl(*entries.toIterable().map { it.toPair() }.toTypedArray())

