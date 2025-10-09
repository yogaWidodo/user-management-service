package com.batch15.usermanagementservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp


@Entity
@Table(name = "mst_user")
data class MasterUserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", insertable = false, updatable = false)
    val id: Int = 0,

    @Column(name = "username")
    var username: String,

    @Column(name = "password" ,nullable = false)
    var password: String,

    @Column(name = "fullname", nullable = false)
    val fullName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = true)
    val role: MasterRoleEntity? = null,

    @CreationTimestamp
    @Column(name = "created_at",  nullable = false)
    val createdAt : Timestamp? = null,

    @Column(name = "created_by", nullable = false)
    val createdBy : String = "SYSTEM",

    @UpdateTimestamp
    val updateAt: Timestamp? = null,

    @Column(name = "is_delete", nullable = false)
    var isDeleted: Boolean = false,
)
