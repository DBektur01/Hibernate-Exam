package Java13.dao;

import Java13.entity.UserProfile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserProfileDao {
    String saveUserProfile(UserProfile newUserProfile);

    Optional<UserProfileDao> getUserProfileById(Long id);

    String updateUserProfile(Long userProfileId , UserProfile newUserProfile);

    void deleteUserProfileById(Long id);

    void getUserProfileByEmail(String email);

    List<UserProfile> getUserRegisteredAfterDate(LocalDate date);



}
