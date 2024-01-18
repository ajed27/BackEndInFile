package com.infile.api.structure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infile.api.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

@Component
public class SecurityInterceptor extends WebRequestHandlerInterceptorAdapter {

    @Autowired
    SessionService sessionService;

    public SecurityInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, @NonNull Object handler) throws Exception {
        /*int code;
        String exception = "";
        Object reply = "";
        String token = request.getHeader("token");
        String moduleName = getModuleNameFromRequest(request);
        String requestMethod = request.getMethod();
        boolean isValid = this.sessionService.tokenSecure(Long.parseLong("1"), token);
        ObjectMapper mapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(200);
        if(!isValid){
            code = 1001;
            response.getWriter().write(mapper.writeValueAsString(Response.getResponse(code, reply, exception)));
            return false;
        }*/
        return true;
    }

    private String getModuleNameFromRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String[] segments = uri.split("/");
        String module = null;
        if (segments.length > 2) {
            module = segments[2];
        }
        return module;
    }

}
