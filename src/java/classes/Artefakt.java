package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a artefact
 *
 * @author 
 */
@XmlRootElement
public class Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String titel;

    private String kurzbeschreibung;
    
    private Long scopeId;
    
    private int stunden;

    public Long getScopeId() {
        return scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
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

}
