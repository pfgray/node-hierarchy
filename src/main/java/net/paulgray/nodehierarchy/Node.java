package net.paulgray.nodehierarchy;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pgray on 10/21/14.
 */
@Entity
@Table(name = "nodes")
public class Node {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "path")
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
