package com.example.ex1_hello_jpa;

import com.example.ex1_hello_jpa.domain.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Permanence implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        ////1. 엔티티 조회, 1차 캐시
        ////엔티티를 생성한 상태(비영속)
        //Member member = new Member();
        //member.setId(1L);
        //member.setName("회원1");
        ////엔티티를 영속
        //em.persist(member);
        ////1차 캐시에서 조회
        //Member findMember = em.find(Member.class, 1L);
        ////데이터베이스에서 조회
        //Member findMember2 = em.find(Member.class, 2L);
        //
        ////2. 영속 엔티티의 동일성 보장
        //Member a = em.find(Member.class, 1L);
        //Member b = em.find(Member.class, 1L);
        //System.out.println(a == b); //동일성 비교 true
        //
        ////3. 엔티티 등록
        ////3. 트랜잭션을 지원하는 쓰기 지연
        ////EntityTransaction transaction = em.getTransaction();
        ////엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
        ////transaction.begin(); // [트랜잭션] 시작
        //em.persist(a);
        //em.persist(b);
        ////여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
        ////커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
        ////transaction.commit(); // [트랜잭션] 커밋
        //
        ////4. 엔티티 수정
        ////4. 변경 감지
        //
        //// 영속 엔티티 조회
        //Member memberA = em.find(Member.class, "memberA");
        ////영속 엔티티 데이터 수정
        //memberA.setName("hi");
        ////em.update(member) 이런 코드가 있어야 하지 않을까 ?
        ////                  필요 없음!
    }
}