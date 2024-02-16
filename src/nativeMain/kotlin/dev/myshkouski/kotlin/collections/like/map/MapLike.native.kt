package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

actual fun <K, V> mapLikeOf(vararg pairs: Pair<K, V>): MapLike<K, V> = DefaultMapLikeImpl(*pairs)

actual fun <K, V> mapLikeOf(vararg pairs: PairLike<K, V>): MapLike<K, V> = DefaultMapLikeImpl(*pairs.toPairs())

actual fun <K, V> MapLike<K, V>.toMapLike(): MapLike<K, V> = DefaultMapLikeImpl(*entries.toIterable().map { it.toPair() }.toTypedArray())

private fun <K, V> Array<out PairLike<K, V>>.toPairs(): Array<Pair<K, V>> = map { it.toPair() }.toTypedArray()
