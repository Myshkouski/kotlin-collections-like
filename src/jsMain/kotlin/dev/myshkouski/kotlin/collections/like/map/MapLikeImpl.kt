package dev.myshkouski.kotlin.collections.like.map

import js.core.JsTuple2

@OptIn(ExperimentalJsExport::class)
@JsExport
class MapLikeImpl<K, V>(vararg values: JsTuple2<K, V>) : AbstractMapLike<K, V>(*values)

private fun <K, V> Pair<K, V>.toJsTuple2(): JsTuple2<K, V> = arrayOf(first, second).unsafeCast<JsTuple2<K, V>>()
internal fun <K, V> Array<out Pair<K, V>>.toJsTuples(): Array<JsTuple2<K, V>> = Array(size) { get(it).toJsTuple2() }

actual fun <K, V> mapLikeOf(vararg pairs: Pair<K, V>): MapLike<K, V> = MapLikeImpl(*pairs.toJsTuples())

private fun <K, V> PairLike<K, V>.toJsTuple2(): JsTuple2<K, V> = arrayOf(key, value).unsafeCast<JsTuple2<K, V>>()
internal fun <K, V> Array<out PairLike<K, V>>.toJsTuples(): Array<out JsTuple2<K, V>> = Array(size) { get(it).toJsTuple2() }

actual fun <K, V> mapLikeOf(vararg pairs: PairLike<K, V>): MapLike<K, V> = MapLikeImpl(*pairs.toJsTuples())


