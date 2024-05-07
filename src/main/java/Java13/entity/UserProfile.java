package Java13.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Builder
@SequenceGenerator(name = "id_gen", sequenceName = "user_seq", allocationSize = 1)
public class UserProfile extends GenerateID {
    @Column(unique = true)
    private String user_name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate registration_date;


    @OneToOne(mappedBy = "userProfile")
    private UserDetails userDetails;


    @Override
    public String toString() {
        return "UserProfile{" +
                ",idd='" + super.getId() + '\'' +
                "user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", registration_date=" + registration_date +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
