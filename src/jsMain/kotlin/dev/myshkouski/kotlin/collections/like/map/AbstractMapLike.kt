package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.IteratorLike
import dev.myshkouski.kotlin.collections.like.iterator.asIteratorLike
import dev.myshkouski.kotlin.collections.like.iterator.map
import js.collections.JsMap
import js.core.JsTuple2
import js.iterable.toArray

sealed class AbstractMapLike<K, V>(vararg values: JsTuple2<K, V>) : MapLike<K, V> {
    protected val map: JsMap<K, V> = JsMap(values)

    override val size: Int
        get() = map.size

    override val keys: IteratorLike<K>
        get() = map.keys().asIteratorLike()
    override val values: IteratorLike<V>
        get() = map.values().asIteratorLike()
    override val entries: IteratorLike<PairLike<K, V>>
        get() = map.entries().asIteratorLike().map { it.toDictionaryEntry() }

    internal fun entriesAsArray(): Array<out JsTuple2<K, V>> = map.entries().toArray()

    override fun get(key: K): V? = map[key]
    override fun has(key: K): Boolean = map.has(key)
}

private fun <K, V> JsTuple2<K, V>.toDictionaryEntry(): PairLike<K, V> = PairLikeImpl(component1(), component2())

