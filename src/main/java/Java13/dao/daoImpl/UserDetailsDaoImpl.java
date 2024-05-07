package Java13.dao.daoImpl;
import Java13.config.DatabaseConfig;
import Java13.dao.UserDetailsDao;
import Java13.entity.UserDetails;
import Java13.entity.UserProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class UserDetailsDaoImpl implements UserDetailsDao {
    private final EntityManagerFactory entityManagerFactory = DatabaseConfig.entityManagerFactory();


    @Override
    public String saveUserDetailToUserPById(Long user_id, UserDetails userDetails) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class,user_id);
            if(userProfile == null) {
                System.out.println("not found !");
            }

            entityManager.persist(userDetails);
            entityManager.getTransaction().commit();

        }catch (Exception e){
            rollback(entityManager);
            return e.getMessage();
        }
        return "Successfully saved !";
    }

    @Override
    public Optional<UserDetails> getUserDById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDetails userDetails = new UserDetails();
        try {
            entityManager.getTransaction().begin();
            userDetails = entityManager.find(UserDetails.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return  Optional.of(userDetails);
    }

    @Override
    public String updateAddressUserDetails(Long userD_id, String address) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update UserDetails u set u.address =:address where u.id =:id")
                    .setParameter("id",userD_id)
                    .setParameter("address",address )
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            return e.getMessage();
        }
        return "Successfully updated !";

    }

    @Override
    public void deleteUserDById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserDetails userDetails = entityManager.find(UserDetails.class, id);
            entityManager.remove(userDetails);
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }

    }

    @Override
    public String getUserDetailsByAddress(String address) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("select u from UserDetails u where u.address =:address")
                    .setParameter("address", address)
                    .getSingleResult();
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return "Success !";
    }

    @Override
    public List<UserDetails> sortUserDetailsByDateOfBirth() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<UserDetails>  result = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
            result = entityManager.createQuery("select u from UserDetails  u order by u.date_of_birth", UserDetails.class)
                    .getResultList();

        }catch (Exception e){
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return result;
    }
    public  void rollback (EntityManager entityManager){
        if(entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
        entityManager.close();
    }
}
