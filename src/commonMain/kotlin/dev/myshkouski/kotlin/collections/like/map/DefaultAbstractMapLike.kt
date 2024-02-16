package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.IteratorLike
import dev.myshkouski.kotlin.collections.like.iterator.iteratorLike
import dev.myshkouski.kotlin.collections.like.iterator.map

internal abstract class DefaultAbstractMapLike<K, out V> : MapLike<K, V> {
    protected abstract val map: Map<K, V>

    override val size: Int
        get() = map.size
    override val keys: IteratorLike<K>
        get() = map.keys.iteratorLike()
    override val values: IteratorLike<V>
        get() = map.values.iteratorLike()
    override val entries: IteratorLike<PairLike<K, V>>
        get() = map.entries.iteratorLike().map { it.toMapEntryLike() }

    override fun has(key: K): Boolean = map.containsKey(key)

    override fun get(key: K): V? = map[key]
}

private fun <K, V> Map.Entry<K, V>.toMapEntryLike(): PairLike<K, V> = PairLikeImpl(key, value)
