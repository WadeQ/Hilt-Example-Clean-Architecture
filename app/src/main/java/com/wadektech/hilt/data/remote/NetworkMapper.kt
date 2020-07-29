package com.wadektech.hilt.data.remote

import com.wadektech.hilt.data.domainModel.Posts
import com.wadektech.hilt.data.local.LocalPosts
import com.wadektech.hilt.utils.PojoMapper
import javax.inject.Inject


class NetworkMapper
@Inject
constructor() : PojoMapper<RemotePosts, Posts> {

    override fun mapFromEntity(entity: RemotePosts): Posts {
        return Posts(
            id = entity.id,
            userId = entity.userId,
            body = entity.body,
            title = entity.title
        )
    }

    override fun mapToEntity(domainModel: Posts): RemotePosts {
        return RemotePosts(
            id = domainModel.id,
            userId = domainModel.userId,
            body = domainModel.body,
            title = domainModel.title
        )
    }

    fun mapFromEntityList(remotePosts:  List<RemotePosts>) : List<Posts>{
        return remotePosts.map { mapFromEntity(it) }
    }
}






