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
@Entity(name = "customers_projects")
    public class CustomersProjects implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = -2568780829714438227L;
    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "project_id")
    private Long projectId;

    @Override
    public Long getID() {
        return customerId;
    }
}
