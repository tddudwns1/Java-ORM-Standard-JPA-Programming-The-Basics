package com.example.ex1_hello_jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "Member")
//@Table(uniqueConstraints = ) unique 제약조건 걸때 씀
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    //, unique = true -> 이거는 안 씀, 왜냐? 제약조건 이름이 랜덤으로 되서 에러 발생 시 파악 불가능
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    //private Integer age;
    //@Enumerated(EnumType.STRING)
    //private RoleType roleType;
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date createdDate;
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date lastModifiedDate;
    //@Lob
    //private String description;

    //@Transient
    //private int temp;

    //@Column(name = "TEAM_ID")
    //private Long teamId;
}
