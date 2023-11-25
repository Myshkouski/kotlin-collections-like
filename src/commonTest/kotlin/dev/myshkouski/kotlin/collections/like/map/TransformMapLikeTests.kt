package dev.myshkouski.kotlin.collections.like.map

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs

class TransformMapLikeTests {
    @Test
    fun mapLiketoKotlinMap() {
        val mapLike = mapLikeOf(*dataPairs)

        val map = mapLike.toMap()

        assertEquals(2, map.size)

        assertEquals("1", map[1])
        assertEquals("12", map[2])
    }

    @Test
    fun kotlinMapToMapLike() {
        val map = mapOf(*dataPairs)
        val mapLike = map.toMapLike()
        assertMapLike(mapLike)
    }

    @Test
    fun mapLikeToMapLike() {
        val mapLike = mapLikeOf(*dataPairs)
        val other = mapLike.toMapLike()
        assertMapLike(other)
        assertFalse { mapLike === other }
    }

    @Test
    fun mapLikeToMutableMapLike() {
        val mapLike = mapLikeOf(*dataPairs)
        val other = mapLike.toMutableMapLike()
        assertIs<MutableMapLike<*, *>>(other)
        assertMapLike(other)
        assertFalse { mapLike === other }
    }
}