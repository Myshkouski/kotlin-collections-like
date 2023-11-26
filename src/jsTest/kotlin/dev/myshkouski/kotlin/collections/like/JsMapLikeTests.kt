package dev.myshkouski.kotlin.collections.like

import dev.myshkouski.kotlin.collections.like.map.IntMapLike
import dev.myshkouski.kotlin.collections.like.map.StringMapLike
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class JsMapLikeTests {
    @Test
    fun intMapLike() {
        val mapLike = IntMapLike(
            1 to "one",
            2 to "two"
        )

        assertTrue(mapLike.has(1))
        assertEquals("one", mapLike[1])
        assertTrue(mapLike.has(2))
        assertEquals("two", mapLike[2])
        assertEquals(2, mapLike.size)
    }

    @Test
    fun stringMapLike() {
        val mapLike = StringMapLike(
            "one" to 1,
            "two" to 2,
        )

        assertTrue(mapLike.has("one"))
        assertEquals(1, mapLike["one"])
        assertTrue(mapLike.has("two"))
        assertEquals(2, mapLike["two"])
        assertEquals(2, mapLike.size)
    }
}
