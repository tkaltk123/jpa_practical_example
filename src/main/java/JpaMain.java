import entity.MemberEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
            tran.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
    }
}
