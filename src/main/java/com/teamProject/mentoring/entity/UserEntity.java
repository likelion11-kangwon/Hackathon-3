package com.teamProject.mentoring.entity;



import com.teamProject.mentoring.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users")
public class UserEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    private String name;

    private String email;

    private String password;

    private String area;


    // default : null
    private String branch;


    public static UserEntity toUserEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName(userDto.getName());
        userEntity.setArea(userDto.getArea());
        userEntity.setBranch(userDto.getBranch());






        return userEntity;
    }
}
