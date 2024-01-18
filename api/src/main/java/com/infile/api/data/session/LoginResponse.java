package com.infile.api.data.session;

import com.infile.api.model.SessionToken;

public record LoginResponse(Long idUser, String token) {
    public LoginResponse(SessionToken token){
        this(token.getUser().getIdUser(), token.getToken());
    }
}
