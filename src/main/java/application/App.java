package application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Chocolatines.Chocolatines.Chocolatine;

public class App {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int resp = 0;
        String nom;
        float prix;
        float temperature;
        float poids;
        // menu
        while (resp > 6 || resp < 1) {

            System.out.println("1. Lister les chocolatines");
            System.out.println("2. Créer une chocolatine");
            System.out.println("3. Créer une commande");
            System.out.println("4. Top 5 Chocolatine"); // les 5 chocolatines les plus vendues
            System.out.println("5. Créer livreur");
            System.out.println("6. Affecter livreur à la commande");
            resp = sc.nextInt();
        }

        switch (resp) {
        case 1: // lister les chocolatines

            EntityManager em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();

            tx.begin();

//            String nomRecherche = "choco";

            TypedQuery<Chocolatine> query = em.createQuery("select c from Chocolatine c", Chocolatine.class);

//            query.setParameter("nomRech", nomRecherche);

            List<Chocolatine> liste = query.getResultList();
            System.out.println("nom \t\tprix \tpoids \ttemperature");
            for (Chocolatine chocolatine : liste) {
                System.out.println(chocolatine.getNom() + "\t" + chocolatine.getPrix() + "\t" + chocolatine.getPoids()
                        + "\t" + chocolatine.getTemperature());
            }

            tx.commit();

            em.close();

            break;
        case 2: // créer une chocolatine
            System.out.println("Vous avez choisi de créer une chocolatine, veuillez entrez les différents paramètres");
            System.out.println("Entrez le nom de la nouvelle chocolatine :");
            nom = sc.next();
            System.out.println("Entrez le prix de la nouvelle chocolatine :");
            prix = sc.nextFloat();
            System.out.println("Entrez la température de la nouvelle chocolatine :");
            temperature = sc.nextFloat();
            System.out.println("Entrez le poids de la nouvelle chocolatine :");
            poids = sc.nextFloat();

            Chocolatine newchoco = new Chocolatine(nom, prix, temperature, poids);
            EntityManager em1 = emf.createEntityManager();

            EntityTransaction tx1 = em1.getTransaction();

            tx1.begin();
            em1.persist(newchoco);
            tx1.commit();
            em1.close();

            break;
        case 3: // créer une commande

            break;
        case 4: // top 5 chocolatine

            break;
        case 5: // créer un livreur

            break;
        case 6: // affecter livreur à la commande

            break;
        default:
            break;

        }
        emf.close();
    }
}
