package com.infile.api.model;

import com.infile.api.data.session.RegisterRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "user")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    private String email;

    private String user;

    private String password;

    private Boolean state;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SessionToken> sessionTokens;

    public User(RegisterRequest registerRequest){
        this.email = registerRequest.email();
        this.user = registerRequest.user();
        this.password = registerRequest.password();
    }

}
