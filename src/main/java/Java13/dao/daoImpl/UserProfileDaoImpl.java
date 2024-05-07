package Java13.dao.daoImpl;
import Java13.config.DatabaseConfig;
import Java13.dao.UserProfileDao;
import Java13.entity.UserProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class UserProfileDaoImpl implements UserProfileDao {
    EntityManagerFactory entityManagerFactory = DatabaseConfig.entityManagerFactory();


    @Override
    public String saveUserProfile(UserProfile newUserProfile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(newUserProfile);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            return e.getMessage();
        }
        return "Successfully Saved !";
    }

    @Override
    public Optional<UserProfileDao> getUserProfileById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserProfileDao userProfile = null;
        try {
            entityManager.getTransaction().begin();
            userProfile = entityManager.find(UserProfileDao.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return Optional.ofNullable(userProfile);
    }

    @Override
    public String updateUserProfile(Long userProfileId, UserProfile newUserProfile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update UserProfile u set u.user_name =:username , u.email =:eamil,u.registration_date =:registration where u.id =:id")
                    .setParameter("id", userProfileId)
                    .setParameter("username", newUserProfile.getUser_name())
                    .setParameter("eamil", newUserProfile.getEmail())
                    .setParameter("registration", newUserProfile.getRegistration_date())
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            rollback(entityManager);
            return e.getMessage();
        }
        return "Successfully updated !";
    }

    @Override
    public void deleteUserProfileById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, id);
            entityManager.remove(userProfile);
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void getUserProfileByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("select u from UserProfile u where u.email =:email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }

    }

    @Override
    public List<UserProfile> getUserRegisteredAfterDate(LocalDate date) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<UserProfile> userProfiles = entityManager.createQuery("select u from UserProfile u where u.registration_date >:registration", UserProfile.class)
                    .getResultList();
            entityManager.getTransaction().commit();
            return userProfiles;
        } catch (Exception e) {
            rollback(entityManager);
            System.err.println(e.getMessage());
        }
        return null ;
    }
    public void rollback(EntityManager entityManager) {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
        entityManager.close();
    }
}
