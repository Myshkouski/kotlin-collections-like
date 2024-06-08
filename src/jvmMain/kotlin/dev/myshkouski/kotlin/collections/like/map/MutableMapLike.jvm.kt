package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

actual fun <K, V> mutableMapLikeOf(): MutableMapLike<K, V> {
    return DefaultMutableMapLikeImpl()
}
actual fun <K, V> mutableMapLikeOf(vararg pairs: Pair<K, V>): MutableMapLike<K, V> = DefaultMutableMapLikeImpl(*pairs)
actual fun <K, V> mutableMapLikeOf(vararg pairs: PairLike<K, V>): MutableMapLike<K, V> = DefaultMutableMapLikeImpl(*pairs.map { it.toPair() }.toTypedArray())

actual fun <K, V> MapLike<K, V>.toMutableMapLike(): MutableMapLike<K, V> = DefaultMutableMapLikeImpl(*entries.toIterable().map { it.toPair() }.toTypedArray())
