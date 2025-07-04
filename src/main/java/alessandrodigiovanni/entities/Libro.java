package alessandrodigiovanni.entities;

import alessandrodigiovanni.enums.Genere;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;


@Entity

public class Libro extends Catalogo {
    private String autore;
    @Enumerated
    private Genere genere;

    public Libro(){}

    public Libro(String titolo,int annoPubblicazione,int numeroPagine,String autore,Genere genere){
        super(titolo,annoPubblicazione,numeroPagine);
        this.autore=autore;
        this.genere=genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore="+ autore +
                "genere=" + genere +
                ", codiceISBN=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
