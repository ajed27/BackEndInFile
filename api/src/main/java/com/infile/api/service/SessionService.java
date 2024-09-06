package com.infile.api.service;

import com.infile.api.data.session.LoginRequest;
import com.infile.api.data.session.LoginResponse;
import com.infile.api.data.session.RegisterRequest;
import com.infile.api.model.SessionToken;
import com.infile.api.model.User;
import com.infile.api.repository.TokenRepository;
import com.infile.api.repository.UserRepository;
import com.infile.api.structure.response.ResponseCode;
import com.infile.api.structure.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;

@Service
public class SessionService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Transactional
    public ResponseMessage login(LoginRequest loginRequest){
        User user = this.userRepository.findByUsername(loginRequest.user());
        if (user == null){
            return new ResponseMessage(ResponseCode.USER_DOESNT_EXIST, "");
        }
        if (!user.getState()){
            return new ResponseMessage(ResponseCode.USER_DELETED, "");
        }
        if (!user.getPassword().equals(loginRequest.password())){
            return new ResponseMessage(ResponseCode.PASSWORD_INCORRECT, "");
        }
        SessionToken sessionToken = this.createToken(user);
        this.tokenRepository.save(sessionToken);
        return new ResponseMessage(ResponseCode.SUCCESS, new LoginResponse(sessionToken));
    }


    private SessionToken createToken(User user){
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32).substring(0, 10);
        return new SessionToken(token, user);
    }

    @Transactional
    public ResponseMessage createUser(RegisterRequest registerRequest){
        User user = new User(registerRequest);
        this.userRepository.save(user);
        SessionToken sessionToken = this.createToken(user);
        this.tokenRepository.save(sessionToken);
        return new ResponseMessage(ResponseCode.SUCCESS, new LoginResponse(sessionToken));
    }

    @Transactional
    public boolean tokenSecure(Long idUser, String token){
        SessionToken sessionToken = this.tokenRepository.findByToken(token);
        if (sessionToken == null){
            return false;
        }
        return Objects.equals(sessionToken.getUsername().getIdUser(), idUser);
    }
}
