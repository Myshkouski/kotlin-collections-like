package dev.myshkouski.kotlin.collections.like.map

actual fun <K, V> mutableMapLikeOf(vararg pairs: PairLike<K, V>): MutableMapLike<K, V> {
    return MutableMapLikeImpl(*pairs.toJsTuples())
}

actual fun <K, V> mutableMapLikeOf(): MutableMapLike<K, V> {
    return MutableMapLikeImpl()
}
