package com.infile.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "category_new")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    private String category;

    private Boolean state;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<New> newList;

}
