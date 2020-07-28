package com.wadektech.hilt.data.remote

import com.wadektech.hilt.data.Posts
import com.wadektech.hilt.utils.PojoMapper
import javax.inject.Inject


class NetworkMapper
@Inject
constructor() : PojoMapper<RemotePosts,Posts> {
    override fun mapFromPojo(pojo: RemotePosts): Posts {
        return Posts(
            id = pojo.id,
            title = pojo.title,
            body = pojo.body,
            userId = pojo.userId
        )
    }

    override fun mapToPojo(posts: Posts): RemotePosts {
       return RemotePosts(
           id = posts.id,
           title = posts.title,
           body = posts.body,
           userId = posts.userId
       )
    }

    fun mapFromPojoList(pojos : List<RemotePosts>) : List<Posts>{
        return pojos.map { mapFromPojo(it) }
    }
}






