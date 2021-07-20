package nl.parlio.authorization.jose

import java.security.KeyPair
import java.security.KeyPairGenerator
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

object KeyGeneratorUtils {

    fun generateSecretKey(): SecretKey {
        return try {
            KeyGenerator.getInstance("HmacSha256").generateKey()
        } catch (ex: Exception) {
            throw IllegalStateException(ex)
        }
    }

    fun generateRsaKey(): KeyPair {
        return try {
            val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
            keyPairGenerator.initialize(2048)
            keyPairGenerator.generateKeyPair()
        } catch (ex: Exception) {
            throw IllegalStateException(ex)
        }
    }

}