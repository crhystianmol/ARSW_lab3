package edu.eci.arsw.blueprints.services;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        Point[] puntos=new Point[]{
                new Point(0, 0),
                new Point(10, 10),
                new Point(4, 3),
                new Point(2, 8),
                new Point(3, 5),
                new Point(5, 6),
        };

        Blueprint bps1=new Blueprint("Luis", "paint1",puntos);
        Blueprint bps2=new Blueprint("Carlos", "paint2",puntos);
        Blueprint bps3=new Blueprint("Juan", "paint3",puntos);
        Blueprint bps4=new Blueprint("Mateo", "paint4",puntos);
        Blueprint bps5=new Blueprint("Daniel", "paint5",puntos);
        Blueprint bps6=new Blueprint("Ricardo", "paint6",puntos);

        try {
            bps.addNewBlueprint(bps1);
            bps.addNewBlueprint(bps2);
            bps.addNewBlueprint(bps3);
            bps.addNewBlueprint(bps4);
            bps.addNewBlueprint(bps5);
            bps.addNewBlueprint(bps6);

            System.out.println("--------------------------------");

            Blueprint geta = bps.getBlueprint("Luis","paint1");
            System.out.println(geta);

            System.out.println("--------------------------------");


            Set<Blueprint> getall = bps.getAllBlueprints();
            getall.forEach((entry) -> {System.out.println(entry);});

            System.out.println("--------------------------------");

            Set<Blueprint> getb = bps.getBlueprintsByAuthor("Luis");
            getb.forEach((entry) -> {System.out.println(entry);});

            System.out.println("--------------------------------");

        } catch (BlueprintPersistenceException e) {
            e.printStackTrace();
        }catch (BlueprintNotFoundException e) {
            e.printStackTrace();
        }
    }
}
