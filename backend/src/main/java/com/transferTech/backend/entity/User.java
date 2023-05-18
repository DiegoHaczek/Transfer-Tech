package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL",
            unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @OneToOne(mappedBy = "user")
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private List<User> contacts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID")
    @Enumerated(EnumType.STRING)
    private List<Role> role;


    public void addContact(User contact){
        contacts.add(contact);
    }
}
