package com.menthor.service;

import com.menthor.dto.AdminDto;
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
        try {
            List<UserEntity> allUser = userRepository.findAllByAndDeleted(null);
            List<UserEntity> response = new ArrayList<UserEntity>();
            for (int i=0; i < allUser.size();++i){
                UserEntity user = userRepository.getReferenceById(allUser.get(i).getId());
                List<MatchEntity> match = new ArrayList<>();
                if (user.getRole().toLowerCase().equals("mentor")){
                    match = matchRepository.findByMentorAndAndDeleted(allUser.get(i).getId(), null);
                }else if (user.getRole().toLowerCase().equals("mentee")){
                    match = matchRepository.findByMenteeAndAndDeleted(allUser.get(i).getId(), null);
                }
                if (match.isEmpty())
                    response.add(allUser.get(i));
            }
            return response;
        }catch (Exception ex){
            return null;
        }
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
        try {
            MatchEntity match = matchRepository.getReferenceById(matchId);
            match.setDeleted(new Date());
            matchRepository.save(match);
            response.setMessage("Eşleşme Silindi");
            return response;
        }catch (Exception ex){
            return null;
        }
    }

    public List<AdminDto.MatchResp> AllMatch(){
        List<MatchEntity> matches = matchRepository.findAll();
        List<AdminDto.MatchResp> response = new ArrayList<AdminDto.MatchResp>();
        Optional<UserEntity> mentee = null;
        Optional<UserEntity> mentor = null;
        for (int i=0;i<matches.size();++i){
            AdminDto.MatchResp infos = new AdminDto.MatchResp();
            mentee = userRepository.findById(matches.get(i).getMentee());
            mentor = userRepository.findById(matches.get(i).getMentor());
            if (matches.get(i).getDeleted() == null){
                infos.setMatchId(matches.get(i).getId());
                infos.setMentor(mentor.get().getName()+" "+mentor.get().getSurname());
                infos.setMentee(mentee.get().getName()+" "+mentee.get().getSurname());
                response.add(infos);
            }
        }
        return response;
    }

//    public List[] UserListByRole(){
//        List<UserEntity> mentor = userRepository.findByRoleIgnoreCaseAndDeleted("mentor", null);
//        List<UserEntity> mentee = userRepository.findByRoleIgnoreCaseAndDeleted("mentee", null);
//        return new List[] {mentor, mentee};
//    }
}