package Java13.dao;

import Java13.entity.UserDetails;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface UserDetailsDao {
    String saveUserDetailToUserPById(Long user_id , UserDetails userDetails);

    Optional<UserDetails> getUserDById(Long id);

    String updateAddressUserDetails(Long userD_id,String address);
    void deleteUserDById(Long id);

    String getUserDetailsByAddress (String address);

    List<UserDetails> sortUserDetailsByDateOfBirth ();
}
