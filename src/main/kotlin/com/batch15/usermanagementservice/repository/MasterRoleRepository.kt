package com.batch15.usermanagementservice.repository

import com.batch15.usermanagementservice.domain.entity.MasterRoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MasterRoleRepository: JpaRepository<MasterRoleEntity, Int> {
}