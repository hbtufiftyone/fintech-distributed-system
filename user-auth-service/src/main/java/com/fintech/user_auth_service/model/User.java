package com.fintech.user_auth_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity // Hibernate ko batata hai ki is class ki database mein ek table banegi
@Table(name = "users") // Database mein table ka naam 'users' rakhega
@Data // Lombok: Automatic Getter, Setter, toString, equals aur hashCode bana dega
@NoArgsConstructor // Lombok: Default/No-argument constructor banayega
@AllArgsConstructor // Lombok: All-arguments constructor banayega
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
}
