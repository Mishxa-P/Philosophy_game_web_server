package com.philosophygame.service;

import com.philosophygame.entity.*;
import com.philosophygame.repository.ClassroomRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;


    public Classroom findClassroomById(Long classroomId) {
        Optional<Classroom> ClassroomFromDb = classroomRepository.findById(classroomId);
        return ClassroomFromDb.orElse(new Classroom());
    }

    public boolean checkClassroom(ClassroomRequest classroomRequest)
    {
        Classroom classroom = classroomRepository.findByClassroomName(classroomRequest.getClassroomName());

        if (classroom == null) {
            return false;
        }

        if (!classroom.getPassword().equals(classroomRequest.getClassroomPassword())) {
            return false;
        }

        return true;
    }

    public List<Classroom> allClassrooms() {
        return classroomRepository.findAll();
    }

    public boolean saveClassroom(Classroom classroom) {

        Classroom classroomFromDB = classroomRepository.findByClassroomName(classroom.getClassroomName());

        if (classroomFromDB != null) {
            return false;
        }
        classroom.setPassword(makePassword(getRandomNumber(6, 10)));
        classroomRepository.save(classroom);
        return true;
    }

    public boolean deleteClassroom(Long classroomId) {
        if (classroomRepository.findById(classroomId).isPresent()) {
            classroomRepository.deleteById(classroomId);
            return true;
        }
        return false;
    }

    public boolean deleteAll() {
        classroomRepository.deleteAll();
        return true;
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private String makePassword(int length) {
        if (length < 6) {
            length = 6;
        }
        final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        final char[] symbols = "^$?!@#%&".toCharArray();
        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789^$?!@#%&".toCharArray();

        //Use cryptographically secure random number generator
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length-4; i++) {
            password.append(allAllowed[random.nextInt(allAllowed.length)]);
        }
        //Ensure password policy is met by inserting required random chars in random positions
        password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
        password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
        password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
        password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);
        return password.toString();
    }

}
