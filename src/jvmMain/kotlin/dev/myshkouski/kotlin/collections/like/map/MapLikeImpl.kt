package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

private class MapLikeImpl<K, V>(vararg pairs: Pair<K, V>) : AbstractMapLike<K, V>() {
    override val map: Map<K, V> = mapOf(*pairs)
}

actual fun <K, V> mapLikeOf(vararg pairs: Pair<K, V>): MapLike<K, V> = MapLikeImpl(*pairs)

private fun <K, V> Iterable<PairLike<K, V>>.toPairs(): Array<Pair<K, V>> = map { it.toPair() }.toTypedArray()

actual fun <K, V> mapLikeOf(vararg pairs: PairLike<K, V>): MapLike<K, V> = MapLikeImpl(*pairs.asIterable().toPairs())

actual fun <K, V> MapLike<K, V>.toMapLike(): MapLike<K, V> {
    val pairs = entries.toIterable().toPairs()
    return mapLikeOf(*pairs)
}
