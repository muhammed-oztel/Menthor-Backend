package com.menthor.MenthorProject.service;

import com.menthor.MenthorProject.model.FileEntity;
import com.menthor.MenthorProject.model.MeetEntity;
import com.menthor.MenthorProject.model.UserDetailEntity;
import com.menthor.MenthorProject.model.UserEntity;
import com.menthor.MenthorProject.repository.FileRepository;
import com.menthor.MenthorProject.repository.MeetRepository;
import com.menthor.MenthorProject.repository.UserDetailRepository;
import com.menthor.MenthorProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;
    private final MeetRepository meetRepository;
    private final FileRepository fileRepository;

    public AdminService(UserRepository userRepository, UserDetailRepository userDetailRepository, MeetRepository meetRepository, FileRepository fileRepository) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
        this.meetRepository = meetRepository;
        this.fileRepository = fileRepository;
    }

    public List<UserEntity> AllUser(){
        return userRepository.findAll();
    }

    public List<UserDetailEntity> AllUserDetail(){
        return userDetailRepository.findAll();
    }

    public List<MeetEntity> AllMeet(){
        return meetRepository.findAll();
    }

    public List<FileEntity> AllFile(){
        return fileRepository.findAll();
    }
}
