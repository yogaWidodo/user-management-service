package com.batch15.usermanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class UsermanagementserviceApplication


fun main(args: Array<String>) {
	runApplication<UsermanagementserviceApplication>(*args)
}
