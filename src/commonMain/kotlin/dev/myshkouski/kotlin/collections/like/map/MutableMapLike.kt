package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.Destination

interface MutableMapLike<K, V> : MapLike<K, V>, Destination<PairLike<K, V>> {
    operator fun set(key: K, value: V)
    override fun put(value: PairLike<K, V>) = set(value.key, value.value)
    fun delete(key: K)
}

expect fun <K, V> mutableMapLikeOf(vararg pairs: PairLike<K, V>): MutableMapLike<K, V>
expect fun <K, V> mutableMapLikeOf(vararg pairs: Pair<K, V>): MutableMapLike<K, V>

expect fun <K, V> MapLike<K, V>.toMutableMapLike(): MutableMapLike<K, V>
