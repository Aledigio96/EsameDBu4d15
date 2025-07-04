package alessandrodigiovanni.entities;

import alessandrodigiovanni.enums.Periodicità;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity

public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista(){}

    public Rivista(String titolo,int annoPubblicazione,int numeroPagine,Periodicità periodicità){
        super(titolo,annoPubblicazione,numeroPagine);
        this.periodicità=periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                ", codiceISBN=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
