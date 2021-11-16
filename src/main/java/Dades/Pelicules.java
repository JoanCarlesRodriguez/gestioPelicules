package Dades;

public class Pelicules {
    private String titol;
    private String any;
    private String director;
    private String genere;
    private String id;

    public Pelicules ( String t, int any, String director, String genere){
        t = titol;
        any = any;
        director = director;
        genere = genere;
    }

    public Pelicules(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Pelicules{id = " + id + ", titol = " + titol + ", any = " + any + ", director = " + director + ", genere= " + genere + '}';
    }
}
