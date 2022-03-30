package com.zawinski.common

interface ForeignMapper<I, O> {
    fun from(i: I?): O

    fun to(o: O?, foreignKey: String): I

    fun fromList(list : List<I>?) : List<O> {
        return list?.mapNotNull { from(it) } ?: listOf()
    }

    fun toList(list : List<O>?,foreignKey: String) : List<I> {
        return list?.mapNotNull { to(it,foreignKey) } ?: listOf()
    }
}