package com.saaas.app.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private const val PRODUCTION = "prod"
private const val X_FORWARDED_PROTO = "x-forwarded-proto"
private const val HTTPS = "https"


@Profile(PRODUCTION)
@Configuration
class HttpsRedirectConfiguration {

    @Bean
    fun httpsEnforcerFilter(): Filter? {
        return HttpsEnforcer()
    }
}

class HttpsEnforcer : Filter {
    private var filterConfig: FilterConfig? = null

    override fun init(filterConfig: FilterConfig?) {
        this.filterConfig = filterConfig
    }

    override fun doFilter(servletRequest: ServletRequest,
                          servletResponse: ServletResponse,
                          filterChain: FilterChain) {
        val request = servletRequest as HttpServletRequest
        val response = servletResponse as HttpServletResponse
        if (request.getHeader(X_FORWARDED_PROTO)?.indexOf(HTTPS) != 0) {
            val requestURI = request.requestURI ?: String()
            val queryString = request.queryString ?: String()
            val serverName = request.serverName
            response.sendRedirect("https://$serverName$requestURI$queryString")
            return
        }
        filterChain.doFilter(request, response)
    }

    override fun destroy() {
    }
}