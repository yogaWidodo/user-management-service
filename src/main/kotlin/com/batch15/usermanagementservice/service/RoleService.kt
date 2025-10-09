package com.batch15.usermanagementservice.service

import com.batch15.usermanagementservice.domain.dto.res.resRole.ResRole

interface RoleService {
    fun getAllRoles(): List<ResRole>
}