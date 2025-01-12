package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable

actual fun <K, V> mutableMapLikeOf(): MutableMapLike<K, V> {
    return DefaultMutableMapLikeImpl()
}

actual fun <K, V> mutableMapLikeOf(vararg pairs: Pair<K, V>): MutableMapLike<K, V> {
    return DefaultMutableMapLikeImpl(*pairs)
}

actual fun <K, V> mutableMapLikeOf(vararg pairs: PairLike<K, V>): MutableMapLike<K, V> {
    return mutableMapLikeOf(*pairs.toPairs())
}

actual fun <K, V> MapLike<K, V>.toMutableMapLike(): MutableMapLike<K, V> {
    return mutableMapLikeOf(*entries.toIterable().toList().toTypedArray())
}
