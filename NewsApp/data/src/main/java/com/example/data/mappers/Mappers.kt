package com.example.data.mappers

import com.example.data.remote.model.ArticleDTO
import com.example.data.remote.model.ArticlesDTO
import com.example.data.remote.model.SourceDTO
import com.example.domain.model.Article
import com.example.domain.model.Source


fun ArticlesDTO.toDomain(): List<Article> {
    return articles.map {
        it.toDomain()
    }
}

fun ArticleDTO.toDomain(): Article {
    return Article(
        author = author ?: "",
        content = content ?: "",
        description = description ?: "",
        publishedAt = publishedAt ?: "",
        source = source?.toDomain() ?: Source("", ""),
        title = title ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: ""
    )
}

fun SourceDTO.toDomain(): Source {
    return Source(
        id = id ?: "",
        name = name ?: ""
    )
}