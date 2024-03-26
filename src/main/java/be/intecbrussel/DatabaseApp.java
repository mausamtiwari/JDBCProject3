package be.intecbrussel;

import be.intecbrussel.models.Beer;
import be.intecbrussel.repositoreis.BeerRepository;
import be.intecbrussel.repositoreis.BrewerRepository;
import be.intecbrussel.repositoreis.CategoryRepository;

import java.sql.SQLException;
import java.sql.SQLOutput;
public class DatabaseApp {
    public static void main(String[] args) throws SQLException {

        System.out.println("Reading category");
        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.read();
        System.out.println();

        /*System.out.println("Reading brewers");
        BrewerRepository brewerRepository = new BrewerRepository();
        brewerRepository.read();*/

        /*System.out.println();
        System.out.println("Reading beers");
        BeerRepository beerRepository = new BeerRepository();
        beerRepository.read();*/

        System.out.println();
        System.out.println("Inserting into category");
        categoryRepository.create();

        System.out.println();
        System.out.println("Updating category");
        categoryRepository.update();


        /*System.out.println();
        categoryRepository.delete();*/






    }
}
