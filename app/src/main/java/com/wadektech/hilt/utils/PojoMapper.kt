package com.wadektech.hilt.utils

interface PojoMapper<Entity, DomainModel> {

    fun  mapFromEntity(entity: Entity) : DomainModel

    fun  mapToEntity(domainModel: DomainModel) : Entity

}