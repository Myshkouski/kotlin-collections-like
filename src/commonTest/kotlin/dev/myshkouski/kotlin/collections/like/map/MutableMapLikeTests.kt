package dev.myshkouski.kotlin.collections.like.map

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MutableMapLikeTests {
    @Test
    fun createMutableMapLikeFromPairArray() {
        val mapLike = mutableMapLikeOf(*dataPairs)
        assertMapLike(mapLike)
    }

    @Test
    fun createMutableMapLikeFromPairLikeArray() {
        val mapLike = mutableMapLikeOf(*dataPairLikeArray)
        assertMapLike(mapLike)
    }

    @Test
    fun setToMutableMapLike() {
        val mapLike = mutableMapLikeOf(*dataPairLikeArray)
        val sizeBeforeDelete = mapLike.size
        mapLike[3] = "123"
        assertTrue { mapLike.has(3) }
        assertEquals("123", mapLike[3])
        assertEquals(sizeBeforeDelete + 1, mapLike.size)
    }

    @Test
    fun putIntoMutableMapLike() {
        val mapLike = mutableMapLikeOf(*dataPairLikeArray)
        val sizeBeforeDelete = mapLike.size
        mapLike.put(pairLikeOf(3, "123"))
        assertEquals("123", mapLike[3])
        assertTrue { mapLike.has(3) }
        assertEquals(sizeBeforeDelete + 1, mapLike.size)
    }

    @Test
    fun deleteFromMutableMapLike() {
        val mapLike = mutableMapLikeOf(*dataPairLikeArray)
        val sizeBeforeDelete = mapLike.size
        mapLike.delete(1)
        assertFalse(mapLike.has(1))
        assertEquals(sizeBeforeDelete - 1, mapLike.size)
    }
}
