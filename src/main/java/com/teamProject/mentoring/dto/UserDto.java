package com.teamProject.mentoring.dto;


import com.teamProject.mentoring.entity.UserEntity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    private String area;

    private String branch;

    public static UserDto toUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setArea(userEntity.getArea());
        userDto.setBranch(userEntity.getBranch());

        return userDto;
    }





}
