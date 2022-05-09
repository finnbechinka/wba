package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a artefact and project connection
 *
 * @author 
 */
@XmlRootElement
public class Projekt_Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;

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
