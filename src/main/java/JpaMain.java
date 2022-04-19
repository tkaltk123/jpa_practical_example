import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Arrays;

public class JpaMain {
    public static void main(String[] args) {
        // 엔티티 매니저 팩토리 생성
        var emf = Persistence.createEntityManagerFactory("jpa_practical_example");
        // 엔티티 매니저 생성
        var em = emf.createEntityManager();
        // 트랜잭션 획득
        var tran = em.getTransaction();
        try {
            tran.begin();
            logic(em);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        var item = em.find(AlbumEntity.class,1L);
        System.out.println(item.getName());
    }
}
