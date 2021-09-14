package com.wadektech.hilt.data.local.models

import androidx.paging.DataSource
import com.wadektech.hilt.domain.models.Posts
import com.wadektech.hilt.utils.PojoMapper
import javax.inject.Inject

class LocalCacheMapper
@Inject
constructor(): PojoMapper<LocalPosts, Posts> {

    override fun mapFromEntity(entity: LocalPosts): Posts {
        return Posts(
            id = entity.id,
            userId = entity.userId,
            body = entity.body,
            title = entity.title
        )
    }

    override fun mapToEntity(domainModel: Posts): LocalPosts {
       return LocalPosts(
           id = domainModel.id,
           userId = domainModel.userId,
           body = domainModel.body,
           title = domainModel.title
       )
    }

    fun mapFromEntityList(entities: DataSource.Factory<Int, LocalPosts>): DataSource.Factory<Int, Posts> {
        return  entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(domainModels: List<Posts>) : List<LocalPosts>{
        return domainModels.map { mapToEntity(it) }
    }
}