package com.batch15.usermanagementservice.repository

import com.batch15.usermanagementservice.domain.entity.MasterUserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MasterUserRepository : JpaRepository<MasterUserEntity, Int> {
    fun findByUsername(username: String): MasterUserEntity?

    @Query("SELECT m FROM MasterUserEntity m WHERE m.isDeleted = :isDeleted", nativeQuery = false)
    fun findUserByIsdeleted(isDeleted: Boolean): List<MasterUserEntity>

    @Query(
        """
            select m.* from mst_user m where m.id IN (:ids)
            and m.is_delete = false
        """, nativeQuery = true
    )
    fun findUserByIds(ids: List<Int>): List<MasterUserEntity>
}