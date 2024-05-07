package Java13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "user_details")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter

@Builder
@SequenceGenerator(name = "id_gen",sequenceName = "userD_seq",allocationSize = 1)
public class UserDetails extends GenerateID {

    private String full_name;
    private LocalDate date_of_birth;
    private String address;

    public String getFull_name() {
        return full_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @OneToOne
    private UserProfile userProfile;

    @Override
    public String toString() {
        return "UserDetails{" +
                ",idd='" + super.getId() + '\'' +
                "full_name='" + full_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", address='" + address + '\'' +
                '}';
    }

}
