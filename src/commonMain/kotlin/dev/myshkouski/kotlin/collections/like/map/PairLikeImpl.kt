package dev.myshkouski.kotlin.collections.like.map

internal class PairLikeImpl<K, V>(
    override val key: K,
    override val value: V
) : PairLike<K, V>

fun <K, V> pairLikeOf(key: K, value: V): PairLike<K, V> = PairLikeImpl(key, value)
