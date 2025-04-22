package com.example.student_management.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutListener implements LogoutSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(LogoutListener.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        if (authentication != null) {
            logger.info("User {} has logged out", authentication.getName());
        }
        response.sendRedirect("/login?logout");
    }
}
