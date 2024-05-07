package Java13.service.serviceImpl;

import Java13.dao.UserProfileDao;
import Java13.entity.UserProfile;
import Java13.service.UserProfileService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileDao userProfileDao;
    @Override
    public String saveUserProfile(UserProfile newUserProfile) {
        return userProfileDao.saveUserProfile(newUserProfile);
    }

    @Override
    public Optional<UserProfileDao> getUserProfileById(Long id) {
        return userProfileDao.getUserProfileById(id);
    }

    @Override
    public String updateUserProfile(Long userProfileId, UserProfile newUserProfile) {
        return userProfileDao.updateUserProfile(userProfileId,newUserProfile);
    }

    @Override
    public void deleteUserProfileById(Long id) {
        userProfileDao.deleteUserProfileById(id);

    }

    @Override
    public void getUserProfileByEmail(String email) {
        userProfileDao.getUserProfileByEmail(email);

    }

    @Override
    public List<UserProfile> getUserRegisteredAfterDate(LocalDate date) {
            return userProfileDao.getUserRegisteredAfterDate(date);
    }
}
