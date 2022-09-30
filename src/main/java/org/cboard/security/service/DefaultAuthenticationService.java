package org.cboard.security.service;

import org.cboard.dto.User;
import org.cboard.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by yfyuan on 2016/12/14.
 */
public class DefaultAuthenticationService implements AuthenticationService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Override
    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            LOG.info("context is null");
            return null;
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            LOG.info("authentication is null");
            return null;
        }
        User user = (User) authentication.getPrincipal();
        if (user == null) {
            LOG.info("user is null");
            return null;
        }
        return user;
    }

}
