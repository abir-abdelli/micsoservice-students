package com.students.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students", catalog = "test")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "niveau")
    private String niveau;

    @Column(name = "moyenne")
    private float moyenne;

    @Column(name = "abscence")
    private Integer abscence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public Integer getAbscence() {
        return abscence;
    }

    public void setAbscence(Integer abscence) {
        this.abscence = abscence;
    }
}
