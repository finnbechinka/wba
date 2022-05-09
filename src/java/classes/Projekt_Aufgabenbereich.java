package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a scope and project connection
 *
 * @author
 */
@XmlRootElement
@Entity
@Table(name="tbl_Projekt_Aufgabenbereich")
@NamedQueries({
    @NamedQuery(name="projekt_aufgabenbereich.findAll",query="SELECT pa FROM Projekt_Aufgabenbereich pa"),
    @NamedQuery(name="projekt_aufgabenbereich.findById",query="SELECT pa FROM Projekt_Aufgabenbereich pa WHERE pa.id = :id")
})
public class Projekt_Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long scopeId;

    private Long projectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScopeId() {
        return scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}
