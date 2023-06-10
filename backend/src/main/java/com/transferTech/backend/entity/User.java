package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User  implements UserDetails {

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

    @Column(name = "DNI",
            unique = true)
    private String dni;

    @Column(name = "PROFILE_IMG")
    private String profileImg;

    @Column(name = "DATE_OF_BIRTH")
    //@DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateOfBirth;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

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

    public void deleteContact(User contact){
        contacts.remove(contact);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .toList();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
