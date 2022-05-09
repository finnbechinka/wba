package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a scope
 *
 * @author 
 */
@XmlRootElement
public class Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String titel;

    private String kurzbeschreibung;

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

}
