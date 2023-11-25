package dev.myshkouski.kotlin.collections.like

/**
 * Generic interface for mutable collection
 * that allows to [put] some value with type [T] into it.
 *
 * @param T
 * @constructor Create empty Destination
 */
interface Destination<in T> {
    /**
     * Put [value] into collection
     *
     * @param value
     */
    fun put(value: T)
}
