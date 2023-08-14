package com.teamProject.mentoring.repository;

import com.teamProject.mentoring.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


// JpaRepository< entity, pk타입 >

// db에 넘겨줄 때는 무조건 entity로 넘겨줘야 함.
// 최종적으로 repoistory가 db 와 상호작용 함.
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // JapRepository 에서 save 등 메소드 상속받아옴.
    Optional<UserEntity> findByEmail(String userEmail);
}
