package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

actual fun <K, V> mapLikeOf(): MapLike<K, V> {
    return DefaultMapLikeImpl()
}

actual fun <K, V> mapLikeOf(vararg pairs: Pair<K, V>): MapLike<K, V> {
    return DefaultMapLikeImpl(*pairs)
}

actual fun <K, V> mapLikeOf(vararg pairs: PairLike<K, V>): MapLike<K, V> {
    return mapLikeOf(*pairs.toPairs())
}

actual fun <K, V> MapLike<K, V>.toMapLike(): MapLike<K, V> {
    return mapLikeOf(*entries.toIterable().toList().toTypedArray())
}

internal fun <K, V> Array<out PairLike<K, V>>.toPairs(): Array<Pair<K, V>> {
    return map { it.toPair() }.toTypedArray()
}
