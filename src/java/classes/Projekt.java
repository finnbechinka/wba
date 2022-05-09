package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a project
 *
 * @author 
 */
@XmlRootElement
@Entity
@Table(name="tbl_Projekt")
@NamedQueries({
    @NamedQuery(name="projekt.findAll",query="SELECT p FROM Projekt p"),
    @NamedQuery(name="projekt.findById",query="SELECT p FROM Projekt p WHERE p.id = :id"),
    @NamedQuery(name="projekt.findByTitel",query="SELECT p FROM Projekt p WHERE p.titel = :titel")
})
public class Projekt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titel;

    private String kurzbeschreibung;

    private String logopath;

    private LocalDateTime startdatum;
    
    @ManyToMany
    private Collection<Artefakt> artefakt;
    
    @ManyToMany
    private Collection<Aufgabenbereich> aufgabenbereich;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    public void setKurzbeschreibung(String kurzbeschreibung) {
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public LocalDateTime getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(LocalDateTime startdatum) {
        this.startdatum = startdatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Collection<Artefakt> getArtefakt() {
        return artefakt;
    }

    public void setArtefakt(Collection<Artefakt> artefakt) {
        this.artefakt = artefakt;
    }

    public Collection<Aufgabenbereich> getAufgabenbereich() {
        return aufgabenbereich;
    }

    public void setAufgabenbereich(Collection<Aufgabenbereich> aufgabenbereich) {
        this.aufgabenbereich = aufgabenbereich;
    }

    
}
