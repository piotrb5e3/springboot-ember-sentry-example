package pw.a0bit.weather.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

class NoRedirectStrategy implements RedirectStrategy {
 
    @Override
    public void sendRedirect(HttpServletRequest request,
            HttpServletResponse response, String url) throws IOException {
        // no redirect

    }

}