package nl.parlio.authorization.utils

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken

object SecurityUtil {

    @JvmStatic
    fun getAuthoritiesString(): String {
        val currentAuthentication = SecurityContextHolder.getContext().authentication
        return currentAuthentication.authorities.joinToString(separator = " ") {
            it?.toString() ?: "Complex(${it.javaClass.simpleName})"
        }
    }

    @JvmStatic
    fun isGitHubAuth(): Boolean {
        val currentAuthentication = SecurityContextHolder.getContext().authentication
        if (currentAuthentication !is OAuth2AuthenticationToken) {
            return false
        }
        return currentAuthentication.authorizedClientRegistrationId == "github"
    }

}
