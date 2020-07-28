package com.wadektech.hilt.utils

interface PojoMapper<Pojo, Posts> {

    fun  mapFromPojo(pojo: Pojo) : Posts

    fun  mapToPojo(posts: Posts) : Pojo

}