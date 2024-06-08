package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

actual fun <K, V> mapLikeOf(): MapLike<K, V> = DefaultMapLikeImpl()

actual fun <K, V> mapLikeOf(vararg pairs: Pair<K, V>): MapLike<K, V> = DefaultMapLikeImpl(*pairs)

actual fun <K, V> mapLikeOf(vararg pairs: PairLike<K, V>): MapLike<K, V> = DefaultMapLikeImpl(*pairs.asIterable().toPairs())

actual fun <K, V> MapLike<K, V>.toMapLike(): MapLike<K, V> {
    val pairs = entries.toIterable().toPairs()
    return mapLikeOf(*pairs)
}

private fun <K, V> Iterable<PairLike<K, V>>.toPairs(): Array<Pair<K, V>> = map { it.toPair() }.toTypedArray()
