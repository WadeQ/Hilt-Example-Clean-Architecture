package com.wadektech.hilt.data.local

import com.wadektech.hilt.data.Posts
import com.wadektech.hilt.utils.PojoMapper
import javax.inject.Inject

class LocalCacheMapper
@Inject
constructor(): PojoMapper<LocalPosts, Posts> {
    override fun mapFromPojo(pojo: LocalPosts): Posts {
       return Posts(
           id = pojo.id,
           title = pojo.title,
           body = pojo.body,
           userId = pojo.userId
       )
    }

    override fun mapToPojo(posts: Posts): LocalPosts {
        return LocalPosts(
            id = posts.id,
            title = posts.title,
            body = posts.body,
            userId = posts.userId
        )
    }

    fun mapFromPojoList(pojos : List<LocalPosts>): List<Posts>{
        return  pojos.map { mapFromPojo(it) }
    }
}