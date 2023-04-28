package uk.co.bransbyhorses.equinetrainingtrackerapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApplicationConstants;

@Configuration
public class SecurityConfiguration {

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix(ApplicationConstants.ROLE_PREFIX);
        grantedAuthoritiesConverter.setAuthoritiesClaimName(ApplicationConstants.COGNITO_GROUPS_ATTRIBUTE);

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
}
