package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actors")
public class Actor extends Employee {

    private List<Film> films;

    public Actor() {
    }

    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
        this.films = new ArrayList<Film>();
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "actors_films",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film){
        this.films.add(film);
    }
}
