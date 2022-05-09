package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a scope and project connection
 *
 * @author
 */
@XmlRootElement
public class Projekt_Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;

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
