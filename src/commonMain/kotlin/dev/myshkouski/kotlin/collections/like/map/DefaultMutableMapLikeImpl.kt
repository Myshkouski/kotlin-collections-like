package dev.myshkouski.kotlin.collections.like.map

internal class DefaultMutableMapLikeImpl<K, V>(vararg pairs: Pair<K, V>) : DefaultAbstractMapLike<K, V>(), MutableMapLike<K, V> {
    override val map: MutableMap<K, V> = mutableMapOf(*pairs)

    override fun set(key: K, value: V) {
        map[key] = value
    }

    override fun delete(key: K) {
        map.remove(key)
    }
}
