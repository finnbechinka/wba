package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a project
 *
 * @author 
 */
@XmlRootElement
@Entity
@Table(name = "tbl_Projekt")
public class Projekt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;

    private String kurzbeschreibung;

    private String logopath;

    private LocalDateTime startdatum;

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

}
