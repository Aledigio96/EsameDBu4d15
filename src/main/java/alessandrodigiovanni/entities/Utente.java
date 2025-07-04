package alessandrodigiovanni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private LocalDate datadinascita;
    private long numeroTessera;

    public Utente(){}

    public Utente(String nome,String cognome,LocalDate datadinascita,long numeroTessera){

        this.nome=nome;
        this.cognome=cognome;
        this.datadinascita=datadinascita;
        this.numeroTessera=numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita(LocalDate datadinascita) {
        this.datadinascita = datadinascita;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", datadinascita=" + datadinascita +
                ", numeroTessera=" + numeroTessera +
                '}';
    }
}
