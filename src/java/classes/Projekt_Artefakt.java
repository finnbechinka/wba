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
 * Represents a artefact and project connection
 *
 * @author 
 */
@XmlRootElement
@Entity
@Table(name="tbl_Projekt_Artefakt")
@NamedQueries({
    @NamedQuery(name="projekt_artefakt.findAll",query="SELECT pa FROM Projekt_Artefakt pa"),
    @NamedQuery(name="projekt_artefakt.findById",query="SELECT pa FROM Projekt_Artefakt pa WHERE pa.id = :id")
})
public class Projekt_Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long artefactId;
    
    private Long projectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtefactId() {
        return artefactId;
    }

    public void setArtefactId(Long artefactId) {
        this.artefactId = artefactId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    
}
