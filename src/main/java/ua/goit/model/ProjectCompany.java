package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projects_companies")
public class ProjectCompany implements BaseEntity<Long> , Serializable {

    private static final long serialVersionUID = 1928224651923773356L;

    @Id
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "company_id")
    private Long companyId;

    @Override
    public Long getID() {
        return projectId;
    }
}
