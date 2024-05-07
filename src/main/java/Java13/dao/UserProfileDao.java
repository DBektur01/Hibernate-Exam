package Java13.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserProfile {
    String saveUserProfile(UserProfile newUserProfile);

    Optional<UserProfile> getUserProfileById(Long id);

    String updateUserProfile(Long userProfileId , UserProfile newUserProfile);

    void deleteUserProfileById(Long id);

    void getUserProfileByEmail(String email);

    List<UserProfile> getUserRegisteredAfterDate(LocalDate date);



}
