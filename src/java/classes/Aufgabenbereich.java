package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a scope
 *
 * @author 
 */
@XmlRootElement
@Entity
@Table(name="tbl_Aufgabenbereich")
@NamedQueries({
    @NamedQuery(name="aufgabenbereich.findAll",query="SELECT a FROM Aufgabenbereich a"),
    @NamedQuery(name="aufgabenbereich.findById",query="SELECT a FROM Aufgabenbereich a WHERE a.id = :id"),
    @NamedQuery(name="aufgabenbereich.findByTitel",query="SELECT a FROM Aufgabenbereich a WHERE a.titel = :titel")
})
public class Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String titel;

    private String kurzbeschreibung;
    
    @ManyToMany
    private Collection<Projekt> projekt;

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
