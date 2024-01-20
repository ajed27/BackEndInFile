package com.infile.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "session_token")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SessionToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Long idToken;

    private String token;

    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User username;

    public SessionToken(String token, User username){
        this.token = token;
        this.username = username;
    }

}
