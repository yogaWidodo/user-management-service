package com.batch15.usermanagementservice.service.impl

import com.batch15.usermanagementservice.domain.dto.res.resRole.ResRole
import com.batch15.usermanagementservice.repository.MasterRoleRepository
import com.batch15.usermanagementservice.service.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(
    private val masterRoleRepository: MasterRoleRepository
) : RoleService {
    override fun getAllRoles(): List<ResRole> {
        return masterRoleRepository.findAll().map {
            ResRole(name = it.name)
        }
    }
}