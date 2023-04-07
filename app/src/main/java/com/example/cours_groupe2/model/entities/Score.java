package com.example.cours_groupe2.model.entities;

public class Score extends BaseEntity{
    private Integer score;
    private String nom;


    public Score(Integer score, String nom) {
        this.score = score;
        this.nom = nom;
    }

    public Score() {
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
