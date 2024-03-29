package dev.myshkouski.kotlin.collections.like.map

import js.array.JsTuple2

@OptIn(ExperimentalJsExport::class)
@JsExport
class IntMapLike<K: Int?, V>(vararg values: JsTuple2<K, V>) : AbstractMapLike<K, V>(*values) {
    @JsExport.Ignore
    constructor(vararg values: Pair<K, V>): this(*values.toJsTuples())
}
