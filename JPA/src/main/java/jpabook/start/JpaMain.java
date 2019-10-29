package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	private static void logic(EntityManager em) {
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("오소리");
		member.setAge(2);
		
		em.persist(member);
		
		member.setAge(20);
		
		Member findMember = em.find(Member.class, id);
		System.out.println("아이디 : " + findMember.getId());
		System.out.println("이름 : " + findMember.getUsername());
		System.out.println("나이 : " + findMember.getAge());
		
		em.remove(member);
	}
}
