package com.example.umc_9th_.domain.user.entity;

import com.example.umc_9th_.domain.base.entity.BaseEntity;
import com.example.umc_9th_.domain.review.entity.Review;
import com.example.umc_9th_.domain.user.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "user")
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 20)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(unique = true, length = 20)
    private String phoneNum;

    @Builder.Default
    private Boolean isPhoneNumVer = false;

    @Builder.Default
    private Integer userPoint = 0;

    @Builder.Default
    private Boolean userState = true;

    private LocalDateTime inactiveDate;

    // 연관관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPreference> userPreferences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserTerms> userTerms;
}
