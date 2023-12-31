package com.example.ex1_hello_jpa;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JpaMain implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //1. insert member
        //Member member = new Member();
        //member.setId(2L);
        //member.setName("HelloA");
        //member.setUsername("hi2");

        //2. find member
        //Member member = em.find(Member.class, 1L);

        //3. update member
        //Member member = em.find(Member.class, 1L);
        //member.setName("HelloJPA");

        // 영속 상태로 만들기
        //em.persist(member);
        
        //4. jpql
        //List<Member> result = em.createQuery("select m from Member as m", Member.class)
        ////        .setFirstResult(1)
        ////        .setMaxResults(3)
        //        .getResultList();
        //for (Member member : result) {
        //    System.out.println("member = " + member);
        //}

    }
}
