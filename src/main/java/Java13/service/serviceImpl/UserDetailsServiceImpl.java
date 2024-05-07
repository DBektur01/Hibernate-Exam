package Java13.service.serviceImpl;

import Java13.dao.UserDetailsDao;
import Java13.dao.UserProfileDao;
import Java13.entity.UserDetails;
import Java13.service.UserDetailsService;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDetailsDao userDetailsDao;
    @Override
    public String saveUserDetailToUserPById(Long user_id, UserDetails userDetails) {
        return userDetailsDao.saveUserDetailToUserPById(user_id,userDetails) ;
    }

    @Override
    public Optional<UserDetails> getUserDById(Long id) {
        return userDetailsDao.getUserDById(id);
    }

    @Override
    public String updateAddressUserDetails(Long userD_id, String address) {
        return userDetailsDao.updateAddressUserDetails(userD_id,address);
    }

    @Override
    public void deleteUserDById(Long id) {
        userDetailsDao.deleteUserDById(id);

    }

    @Override
    public String getUserDetailsByAddress(String address) {
        return userDetailsDao.getUserDetailsByAddress(address);
    }

    @Override
    public List<UserDetails> sortUserDetailsByDateOfBirth() {
        return userDetailsDao.sortUserDetailsByDateOfBirth();
    }
}
