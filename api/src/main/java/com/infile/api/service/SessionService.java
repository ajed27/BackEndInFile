package com.infile.api.service;

import com.infile.api.data.session.LoginRequest;
import com.infile.api.data.session.LoginResponse;
import com.infile.api.data.session.RegisterRequest;
import com.infile.api.model.SessionToken;
import com.infile.api.model.User;
import com.infile.api.repository.TokenRepository;
import com.infile.api.repository.UserRepository;
import com.infile.api.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Objects;

@Service
public class SessionService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    public Map<String, Object> login(LoginRequest loginRequest){
        User user = this.userRepository.findByUser(loginRequest.user());
        if (user == null){
            return Response.getResponse(1001, "", "");
        }
        if (!user.getState()){
            return Response.getResponse(1002, "", "");
        }
        if (!user.getPassword().equals(loginRequest.password())){
            return Response.getResponse(1003, "", "");
        }
        SessionToken sessionToken = this.createToken(user);
        this.tokenRepository.save(sessionToken);
        return Response.getResponse(1000, new LoginResponse(sessionToken), "");
    }

    private SessionToken createToken(User user){
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32).substring(0, 10);
        return new SessionToken(token, user);
    }

    public Map<String, Object> createUser(RegisterRequest registerRequest){
        User user = new User(registerRequest);
        this.userRepository.save(user);
        SessionToken sessionToken = this.createToken(user);
        this.tokenRepository.save(sessionToken);
        return Response.getResponse(1000, new LoginResponse(sessionToken), "");
    }

    public boolean tokenSecure(Long idUser, String token){
        SessionToken sessionToken = this.tokenRepository.findByToken(token);
        if (sessionToken == null){
            return false;
        }
        return Objects.equals(sessionToken.getUser().getIdUser(), idUser);
    }
}
