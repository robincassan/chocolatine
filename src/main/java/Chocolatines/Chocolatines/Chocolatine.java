package Chocolatines.Chocolatines;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tablechoco")

public class Chocolatine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String nom;

    float prix;
    float temperature;
    float poids;

    // constructeur par défaut car pas de parametre
    public Chocolatine() {
        super();
    }

    public Chocolatine(String nom, float prix, float temperature, float poids) {
        super();
        this.nom = nom;
        this.prix = prix;
        this.temperature = temperature;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

}
