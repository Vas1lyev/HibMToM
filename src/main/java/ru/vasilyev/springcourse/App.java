package ru.vasilyev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vasilyev.springcourse.model.Actor;
import ru.vasilyev.springcourse.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie movie = new Movie("Pulp fiction", 1994);
//
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            // Arrays.asList
//            // List.of - immutable
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);


//            Movie movie = session.get(Movie.class, 1);
//
//            for (Actor actor : movie.getActors()) {
//                System.out.println(actor);
//            }
//
//            System.out.println();
//
//            Actor actor = session.get(Actor.class, 1);
//
//            for(Movie m : actor.getMovies()) {
//                System.out.println(m);
//            }


//            Movie movie = session.get(Movie.class, 2);
//            Actor actor = session.get(Actor.class, 1);
//
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);

            Actor actor = session.get(Actor.class, 1);
            Movie movieToRemove = actor.getMovies().get(0);


            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);



            session.getTransaction().commit();
        }

    }
}
