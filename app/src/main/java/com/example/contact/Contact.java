package com.example.contact;

public class Contact {
    Integer id;
    String nom;
    String prenom;
    String telephone;
    int img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Contact(Integer id, String nom, String prenom, String telephone, int img) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.img = img;
    }

    public Contact(String nom, String prenom, String telephone, int img) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.img = img;
    }

    public Contact(Integer id,String nom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Contact() {
    }
}
