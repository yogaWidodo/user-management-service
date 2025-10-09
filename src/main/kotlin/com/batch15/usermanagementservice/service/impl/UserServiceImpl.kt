package com.batch15.usermanagementservice.service.impl

import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResGetUserByIdsDTO
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResUser
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResUserByID
import com.batch15.usermanagementservice.domain.entity.MasterUserEntity
import com.batch15.usermanagementservice.exception.CustomException
import com.batch15.usermanagementservice.repository.MasterUserRepository
import com.batch15.usermanagementservice.service.UserService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val masterUserRepository: MasterUserRepository,
    private val httpServletRequest: HttpServletRequest
) : UserService {
    override fun findAllUser(): List<ResUser> {
        val users = masterUserRepository.findUserByIsdeleted(false)
        return users.map { user ->
            ResUser(
                id = user.id,
                userName = user.username,
                fullName = user.fullName,
                createdAt = user.createdAt!!,
                createdBy = user.createdBy,
                roleName = user.role!!.name
            )
        }
    }

    override fun findUserById(id: Int): ResUserByID? {
        val user: MasterUserEntity? = masterUserRepository.findById(id).orElseThrow {
            Exception("User not found with id $id")
        }
        return user?.let {
            ResUserByID(
                id = it.id,
                userName = it.username,
                fullName = it.fullName,
                roleName = it.role?.name,
                createdAt = it.createdAt!!,
                createdBy = it.createdBy,
                updateAt = it.updateAt.toString()
            )
        }
    }

    override fun softDeleteUser(id: Int): WebResponse<String> {
        val authority = httpServletRequest.getHeader("Authority")
        if (authority!= "admin"){
            throw CustomException(
                "FORBIDDEN",
                HttpStatus.FORBIDDEN.value()
            )
        }
        val user = masterUserRepository.findById(id).orElseThrow {
            CustomException(
                "User not found with id $id",
                code = 404
            )
        }
        user.isDeleted = true
        masterUserRepository.save(user)
        return WebResponse(
            data = "User with id $id has been soft deleted",
            message = "Soft delete user successfully"
        )
    }

    override fun getUserByUniqueIds(ids: List<Int>): List<ResGetUserByIdsDTO> {
        return masterUserRepository.findUserByIds(ids).map {
            ResGetUserByIdsDTO(
                userId = it.id,
                fullName = it.fullName
            )
        }
    }
}