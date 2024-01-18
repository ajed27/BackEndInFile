package com.infile.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "new")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class New {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_new")
    private Long idNew;

    @Column(name = "new")
    private String news;

    private String description;

    private String image;

    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryNew category;

}
