package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.FileEntity;
import com.menthor.model.MatchEntity;
import com.menthor.model.UserDetailEntity;
import com.menthor.model.UserEntity;
import com.menthor.repository.FileRepository;
import com.menthor.repository.MatchRepository;
import com.menthor.repository.UserDetailRepository;
import com.menthor.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;
    private final FileRepository fileRepository;
    private final MatchRepository matchRepository;
    private final UserDto.Response response;

    public AdminService(UserRepository userRepository, UserDetailRepository userDetailRepository, FileRepository fileRepository, MatchRepository matchRepository) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
        this.fileRepository = fileRepository;
        this.matchRepository = matchRepository;
        this.response = new UserDto.Response();
    }

    public List<UserEntity> AllUser(){
        return userRepository.findAll();
    }

    public List<UserDetailEntity> AllUserDetail(){
        return userDetailRepository.findAll();
    }

    public List<FileEntity> AllFile(){
        return fileRepository.findAll();
    }

    public UserDto.Response SaveMatch(MatchEntity matchInfo){
//        UserEntity isMentorEmpty = userRepository.getReferenceById(matchInfo.getMentor_id());
//        UserEntity isMenteeEmpty = userRepository.getReferenceById(matchInfo.getMentee_id());
//        if (isMentorEmpty != null && isMenteeEmpty != null){
        matchInfo.setDate(new Date());
        matchRepository.save(matchInfo);
        response.setMessage("Eşleme Başarılı");
        return response;
//        }else {
//            response.setMessage("Eşleme Yapılırken Sorun Oluştu !");
//            return response;
//        }
    }

    public UserDto.Response DeleteMatch(Long matchId){
        MatchEntity match = matchRepository.getReferenceById(matchId);
        match.setDeleted(new Date());
        matchRepository.save(match);
        response.setMessage("Eşleşme Silindi");
        return response;
    }

//    public List[] UserListByRole(){
//        List<UserEntity> mentor = userRepository.findByRoleIgnoreCaseAndDeleted("mentor", null);
//        List<UserEntity> mentee = userRepository.findByRoleIgnoreCaseAndDeleted("mentee", null);
//        return new List[] {mentor, mentee};
//    }
}