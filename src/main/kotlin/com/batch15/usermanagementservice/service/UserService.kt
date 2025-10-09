package com.batch15.usermanagementservice.service

import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResGetUserByIdsDTO
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResUser
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResUserByID

interface UserService {

    fun findAllUser(): List<ResUser>
    fun findUserById(id: Int): ResUserByID?
    fun softDeleteUser(id: Int): WebResponse<String>
    fun getUserByUniqueIds(ids: List<Int>) : List<ResGetUserByIdsDTO>

}