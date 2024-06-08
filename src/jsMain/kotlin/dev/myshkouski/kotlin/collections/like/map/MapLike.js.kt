package dev.myshkouski.kotlin.collections.like.map

actual fun <K, V> mapLikeOf(): MapLike<K, V> = DefaultMapLikeImpl()
