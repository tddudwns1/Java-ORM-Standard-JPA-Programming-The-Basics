package com.example.ex1_hello_jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD",
            joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS",
            joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    //@Embedded
    //@AttributeOverrides() // 겹치는 임베디드 타입을 사용할 때 구분하기 위해서 사용
    //private Address workAddress;

    //private Integer age;
    //
    //@Enumerated(EnumType.STRING)
    //private RoleType roleType;
    //
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date createdDate;
    //
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date lastModifiedDate;
    //
    //@Lob
    //private String description;
    //
    //@Transient
    //private int temp;
    //
    //@Column(name = "TEAM_ID")
    //private Long teamId;
}
