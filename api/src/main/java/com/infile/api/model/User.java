package com.infile.api.model;

import com.infile.api.data.session.RegisterRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "client")
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

    @Column(name = "username")
    private String username;

    private String password;

    private Boolean state;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SessionToken> sessionTokens;

    public User(RegisterRequest registerRequest){
        this.email = registerRequest.email();
        this.username = registerRequest.user();
        this.password = registerRequest.password();
    }

}
