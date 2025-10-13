package com.batch15.usermanagementservice.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil(
    @Value("\${jwt.secret-key}")
    private val secretKey: String,
    @Value("\${jwt.expired-in}")
    private val expiredIn: Int
) {
    fun generateToken(userId: Int, roleName: String): String {
        // key minimum 256 bit / 32 byte
        val signatureAlgorithm = SignatureAlgorithm.HS256
        val signingKey = Keys.hmacShaKeyFor(secretKey.toByteArray())

        val exp = Date(System.currentTimeMillis() + 864_000_00 * expiredIn)

        return Jwts.builder()
            .setSubject(userId.toString())
            .claim("userId", userId.toString())
            .claim("authority", roleName)
            .signWith(signingKey, signatureAlgorithm)
            .setExpiration(exp)
            .compact()
    }
}