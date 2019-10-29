package jpabook.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import jpabook.start.Member;

public class SampleMethod {

	public void example_3_5_1(EntityManager em) {
		Member member1 = new Member();
		member1.setId("id3");
		member1.setUsername("오소리3");
		member1.setAge(30);
		
		Member member2 = new Member();
		member2.setId("id4");
		member2.setUsername("오소리4");
		member2.setAge(40);
		
		Member member3 = new Member();
		member3.setId("id5");
		member3.setUsername("오소리5");
		member3.setAge(50);
		
		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		
		TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
		List<Member> members = query.getResultList();
		
	}
	
	public void example_3_4_1(EntityManager em) {
		String id1 = "id1";
		
		Member member1 = em.find(Member.class, id1);
		Member member2 = em.find(Member.class, id1);
		
		if( member1 == member2) {
			System.out.println("[ == ]");
		}
		
		if( member1.equals(member2)) {
			System.out.println("[ equals ]");
		}
	}
	
	public void example_2_6_4(EntityManager em) {
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
		
		TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
		List<Member> members = query.getResultList();
		System.out.println("레코드수 : " + members.size());
		
		em.remove(member);
	}
}
