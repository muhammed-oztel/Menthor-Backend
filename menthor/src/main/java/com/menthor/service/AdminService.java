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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public UserDto.Response DeleteMatch(Long userId){
        try {
            UserEntity user = userRepository.getReferenceById(userId);
            Long matchId = null;
            if (user.getRole().toLowerCase().equals("mentor")){
                matchId = matchRepository.findByMentorAndAndDeleted(userId, null).get(0).getId();
            }else if (user.getRole().toLowerCase().equals("mentee")){
                matchId = matchRepository.findByMenteeAndAndDeleted(userId, null).get(0).getId();
            }
            MatchEntity match = matchRepository.getReferenceById(matchId);
            match.setDeleted(new Date());
            matchRepository.save(match);
            response.setMessage("Eşleşme Silindi");
            return response;
        }catch (Exception ex){
            return null;
        }
    }

    public List[] AllMatch(){
        List<MatchEntity> matches = matchRepository.findAll();
        List<UserEntity> mentees = new ArrayList<UserEntity>();
        List<UserEntity> mentors = new ArrayList<UserEntity>();
        Optional<UserEntity> mentee = null;
        Optional<UserEntity> mentor = null;
        for (int i=0;i<matches.size();++i){
            mentee = userRepository.findById(matches.get(i).getMentee());
            mentor = userRepository.findById(matches.get(i).getMentor());
            mentees.add(mentee.get());
            mentors.add(mentor.get());
        }
        return new List[]{mentees, mentors};
    }

//    public List[] UserListByRole(){
//        List<UserEntity> mentor = userRepository.findByRoleIgnoreCaseAndDeleted("mentor", null);
//        List<UserEntity> mentee = userRepository.findByRoleIgnoreCaseAndDeleted("mentee", null);
//        return new List[] {mentor, mentee};
//    }
}