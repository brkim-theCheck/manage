package com.thecheck.manage.component;
/*
 * @author brKim
 * @date 2020/10/26
 * @desc
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String uri = "/manage";

        if(savedRequest != null) {
            uri = savedRequest.getRedirectUrl();

            requestCache.removeRequest(request, response);

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> [ RETURN URI : " + uri + " ] ");
        }

        Enumeration<String> list = request.getSession().getAttributeNames();
        while(list.hasMoreElements()) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> [ Session list : " +  list.nextElement() + " ] ");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", authentication.getPrincipal());
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("{\"success\" : true}");
        response.getWriter().flush();

        response.sendRedirect(uri);
    }
}
