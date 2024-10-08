package com.infile.api.structure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infile.api.service.SessionService;
import com.infile.api.structure.response.ResponseCode;
import com.infile.api.structure.response.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String token = request.getHeader("token");
        String userId = request.getHeader("userid");

        ObjectMapper mapper = new ObjectMapper();
        if( userId == null ){
            response.getWriter().write(mapper.writeValueAsString(new ResponseMessage(ResponseCode.UNAUTHORIZED, "")));
            return false;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(200);

        boolean isValid = this.sessionService.tokenSecure(Long.parseLong(userId), token);
        if (!isValid){
            response.getWriter().write(mapper.writeValueAsString(new ResponseMessage(ResponseCode.UNAUTHORIZED, "")));
            return false;
        }
        return true;
    }
}
