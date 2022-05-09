package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a artefact
 *
 * @author 
 */
@XmlRootElement
@Entity
@Table(name="tbl_Artefakt")
@NamedQueries({
    @NamedQuery(name="artefakt.findAll",query="SELECT a FROM Artefakt a"),
    @NamedQuery(name="artefakt.findById",query="SELECT a FROM Artefakt a WHERE a.id = :id"),
    @NamedQuery(name="artefakt.findByTitel",query="SELECT a FROM Artefakt a WHERE a.titel = :titel")
})
public class Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String titel;

    private String kurzbeschreibung;
    
    @ManyToOne
    private Aufgabenbereich scope;
    //private Long scopeId;
    
    @ManyToMany
    private Collection<Projekt> projekt;
    
    private int stunden;

    public Aufgabenbereich getScopeId() {
        return scope;
    }

    public void setScope(Aufgabenbereich scope) {
        this.scope = scope;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        this.stunden = stunden;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Projekt> getProjekt() {
        return projekt;
    }

    public void setProjekt(Collection<Projekt> projekt) {
        this.projekt = projekt;
    }

    
}
