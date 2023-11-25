package dev.myshkouski.kotlin.collections.like.iterator

private class IteratorLikeImpl<T>(
    private val iterator: Iterator<T>
) : IteratorLike<T> {
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): T = iterator.next()
}

fun <T> Iterable<T>.iteratorLike(): IteratorLike<T> = IteratorLikeImpl(iterator())
