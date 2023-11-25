package dev.myshkouski.kotlin.collections.like.map

import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal val dataPairs: Array<Pair<Int, String>>
    get() = (1..2).map {
        it to (1..it).joinToString("")
    }.toTypedArray()

internal val dataPairLikeArray: Array<PairLike<Int, String>>
    get() = dataPairs.map { (key, value) ->
        pairLikeOf(key, value)
    }.toTypedArray()

internal fun assertMapLike(mapLike: MapLike<Int, String>) {
    assertTrue(mapLike.has(1))
    assertTrue(mapLike.has(2))

    assertEquals("1", mapLike[1])
    assertEquals("12", mapLike[2])

    assertEquals(2, mapLike.size)
}
