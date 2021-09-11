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
@Entity(name = "developers_projects")

public class DeveloperProject implements BaseEntity<Long>, Serializable {
    private static final long serialVersionUID = 4312636748752746342L;

    @Id
    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "project_id")
    private Long projectId;

    @Override
    public Long getID() {
        return developerId;
    }
}
