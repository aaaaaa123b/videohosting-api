package by.harlap.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Email
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_m2m_channels",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "channel_id", referencedColumnName = "id")}
    )
    Set<Channel> channels = new HashSet<>();
}
