package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter( urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // Pour enlever le probleme du charset en UTF-8 qui provoquait une erreur 500 sur les jsp
        ((HttpServletRequest)servletRequest).setCharacterEncoding( "UTF-8" );
        filterChain.doFilter( servletRequest, servletResponse );

    }
}
