package dev.myshkouski.kotlin.collections.like.iterator

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * [Iterator]-like interface, exportable to JS.
 * @param T
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
interface IteratorLike<out T> {
    fun hasNext(): Boolean
    fun next(): T
}

/**
 * Create iterable from this [IteratorLike].
 * Should not be exported to JS.
 *
 * @param T
 */
fun <T> IteratorLike<T>.toIterable(): Iterable<T> = Iterable {
    iterator {
        while (hasNext()) {
            yield(next())
        }
    }
}
