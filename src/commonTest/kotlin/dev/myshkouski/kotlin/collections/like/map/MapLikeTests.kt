package dev.myshkouski.kotlin.collections.like.map

import dev.myshkouski.kotlin.collections.like.iterator.toIterable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MapLikeTests {
    @Test
    fun createMapLikeFromPairArray() {
        val mapLike = mapLikeOf(*dataPairs)
        assertMapLike(mapLike)
    }

    @Test
    fun createFromMapEntryLikeArray() {
        val mapLike = mapLikeOf(*dataPairLikeArray)
        assertMapLike(mapLike)
    }

    @Test
    fun keys() {
        val mapLike = mapLikeOf(*dataPairLikeArray)
        val keys = mapLike.keys.toIterable().toList()
        assertEquals(mapLike.size, keys.size)
        keys.forEach {
            assertTrue(mapLike.has(it))
        }
    }

    @Test
    fun values() {
        val mapLike = mapLikeOf(*dataPairLikeArray)
        val values = mapLike.values.toIterable().toList()
        assertEquals(mapLike.size, values.size)
    }

    @Test
    fun entries() {
        val mapLike = mapLikeOf(*dataPairLikeArray)
        val entries = mapLike.entries.toIterable().toList()
        assertEquals(mapLike.size, entries.size)
        entries.forEach { (key, value) ->
            assertTrue(mapLike.has(key))
            assertEquals(value, mapLike[key])
        }
    }
}
