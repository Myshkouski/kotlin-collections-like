package dev.myshkouski.kotlin.collections.like.iterator

import js.iterable.IterableIterator

private class IteratorLikeImpl<T>(
    private val iterator: Iterator<T>
) : IteratorLike<T> {
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): T = iterator.next()
}

fun <T> IterableIterator<T>.asIteratorLike(): IteratorLike<T> = IteratorLikeImpl(iterator())
