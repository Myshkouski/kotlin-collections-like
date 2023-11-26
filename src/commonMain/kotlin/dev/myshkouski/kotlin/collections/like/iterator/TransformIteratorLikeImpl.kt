package dev.myshkouski.kotlin.collections.like.iterator

private class TransformIteratorLikeImpl<T, U>(
    private val iteratorLike: IteratorLike<T>,
    private val transform: TransformFunction<T, U>,
) : IteratorLike<U> {
    override fun hasNext(): Boolean = iteratorLike.hasNext()
    override fun next(): U = transform(iteratorLike.next())
}

private typealias TransformFunction<T, U> = (T) -> U

fun <T, U> IteratorLike<T>.map(block: TransformFunction<T, U>): IteratorLike<U> = TransformIteratorLikeImpl(this, block)
