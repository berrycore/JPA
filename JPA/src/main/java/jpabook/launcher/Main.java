package jpabook.launcher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.model.entity.Member;
import jpabook.model.entity.Order;

public class Main {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			long orderId = 1000;
			Order order = em.find(Order.class, orderId);
			
			Member member = em.find(Member.class, order.getMemberId());	// select from order with forign key(memberId)
//			Member member = order.getMember();							// refer object that order
			
			tx.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
	}
}
