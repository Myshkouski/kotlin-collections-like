package dev.myshkouski.kotlin.collections.like.map

/**
 * Default [MapLike] implementation.
 * Property [map] is created by [kotlin.collections.mapOf].
 *
 * @param K map key type
 * @param V map value type
 *
 * @param pairs [K] to [V] pairs
 */
internal class DefaultMapLikeImpl<K, V>(vararg pairs: Pair<K, V>) : DefaultAbstractMapLike<K, V>() {
    override val map: Map<K, V> = mapOf(*pairs)
}
