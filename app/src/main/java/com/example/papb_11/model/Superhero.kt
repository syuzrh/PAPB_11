package com.example.papb_11.model

data class Superhero(
	val result: List<ResultItem?>? = null
)

data class ResultItem(
	val image: String? = null,
	val id: Int? = null,
	val title: String? = null
)

