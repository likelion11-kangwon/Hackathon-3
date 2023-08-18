package com.teamProject.mentoring.service;

import com.teamProject.mentoring.dto.UserDto;
import com.teamProject.mentoring.entity.Center;
import com.teamProject.mentoring.entity.Company;
import com.teamProject.mentoring.entity.UserEntity;
import com.teamProject.mentoring.repository.CenterRepository;
import com.teamProject.mentoring.repository.CompanyRepository;
import com.teamProject.mentoring.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
// RequiredArgsConstructor : 생성자 주입.
public class Service {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final CenterRepository centerRepository;


    public boolean save(UserDto userDto) {
        UserEntity userEntity = UserEntity.toUserEntity(userDto);
        Optional<UserEntity> byUserEmail = userRepository.findByEmail(userDto.getEmail());
        // 여기서의 save 메소드는 내가 생성할 필요X

        // 중복되는 이메일 없으면 save.
        if(byUserEmail.isEmpty()) {
            userRepository.save(userEntity);
            return true;
        }
        // 중복되는 이메일 존재
        else {
//            System.out.println("exist _ email");
            return false;
        }
    }
    public UserDto login(UserDto userDto){
        Optional<UserEntity> byUserEmail =  userRepository.findByEmail(userDto.getEmail());
        //조회성공
        if(byUserEmail.isPresent()){
            UserEntity userEntity = byUserEmail.get();
            if(userEntity.getPassword().equals(userDto.getPassword())){
                // 비밀번호 일치
                return UserDto.toUserDto(userEntity);
            }
            else {
                // 비밀번호 불일치
                return null;
            }
        }
        //조회실패
        else{
            return null;
        }
    }

    public boolean updateUserProfile(String userEmail, String branch) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(userEmail);

        if (existingUser.isPresent()) {
            UserEntity userEntity = existingUser.get();
            userEntity.setBranch(branch);


            userRepository.save(userEntity);
            return true; // 성공적으로 업데이트된 경우
        }

        return false; // 업데이트 실패 (사용자 정보가 잘못되었거나 존재하지 않는 경우)
    }
    public List<Center> getCenterListByArea(String userEmail){
        Optional<UserEntity> existingUser = userRepository.findByEmail(userEmail);
        if(existingUser.isPresent()){
//            System.out.println("EXIST");
            UserEntity userEntity = existingUser.get();
            String area = userEntity.getArea();
            if(area.equals("강원특별자치도")) area = "강원도";
            return centerRepository.findByInfoContaining(area);
        }
        return null;
    }
    public boolean isExistUser(String userEmail){
        Optional<UserEntity> existingUser = userRepository.findByEmail(userEmail);
        if(existingUser.isPresent()) return true;
        return false;
    }

    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    public String getTestResultPage(String userEmail) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(userEmail);
        if(existingUser.isPresent()) {
            UserEntity userEntity = existingUser.get();
            String userTestResult = userEntity.getBranch();
            if(userTestResult == null) return null;
            else if(userTestResult.equals("과학")) return "/test/a1";
            else if(userTestResult.equals("코딩")) return "/test/a2";
            else if(userTestResult.equals("생활")) return "/test/a3";
            else if(userTestResult.equals("독서")) return "/test/a4";
            else if(userTestResult.equals("미술")) return "/test/a5";
            else if(userTestResult.equals("수학")) return "/test/a6";
            else if(userTestResult.equals("체육")) return "/test/a7";
            else if(userTestResult.equals("영어")) return "/test/a8";
        }
        return null;
    }
}
