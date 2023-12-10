package by.harlap.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "channels")
@Getter
@Setter
public class Channel {

    @Id
    @SequenceGenerator(name = "channels_seq", sequenceName = "channels_seq", allocationSize = 1)
    @GeneratedValue(generator = "channels_seq")

    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private String category;

    @ManyToMany(mappedBy = "channels")
    private Set<User> users = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
}
