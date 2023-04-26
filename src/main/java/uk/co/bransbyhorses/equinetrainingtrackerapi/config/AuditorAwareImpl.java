package uk.co.bransbyhorses.equinetrainingtrackerapi.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApplicationConstants;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = getUsernameFromRequestToken();
        if(username == null) {
            return Optional.empty();
        }
        return Optional.of(username);
    }

    public String getUsernameFromRequestToken() {
        // fetch username from request jwt to audit database
        JwtAuthenticationToken accessToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return accessToken.getTokenAttributes()
                .get(ApplicationConstants.COGNITO_USERNAME_ATTRIBUTE)
                .toString();
    }
}
