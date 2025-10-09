package com.batch15.usermanagementservice.domain.entity

import jakarta.persistence.*


@Entity
@Table(name = "mst_role")
data class MasterRoleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    val id: Int = 0,

    @Column(name = "name", nullable = false)
    val name: String
)
