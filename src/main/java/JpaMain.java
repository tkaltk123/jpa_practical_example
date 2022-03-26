import entity.ItemEntity;
import entity.MemberEntity;
import entity.OrderEntity;
import entity.OrderItemEntity;

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
        var member = new MemberEntity();
        member.setName("멤버");
        em.persist(member);

        var order = new OrderEntity();
        order.setMember(member);
        em.persist(order);

        var item = new ItemEntity();
        item.setName("상품");
        item.setPrice(100);
        item.setStockQuantity(1);
        em.persist(item);

        var orderItem = new OrderItemEntity();
        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setCount(1);
        orderItem.setOrderPrice(100);
        em.persist(orderItem);

        System.out.println("ordered member name : "+order.getMember().getName());
        System.out.println("ordered item#1 name : "+order.getOrderItems().get(0).getItem().getName());

    }
}
