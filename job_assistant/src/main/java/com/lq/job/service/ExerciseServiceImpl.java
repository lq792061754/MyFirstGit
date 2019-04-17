package com.lq.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lq.job.domain.Exercise;
import com.lq.job.domain.Exercisevo;
import com.lq.job.mapper.ExerciseMapper;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    @Autowired
    private ExerciseMapper exeMapper;

    @Override
    public int insertExercise(Exercise exercise) {
      return exeMapper.insertExercise(exercise);
    }

    @Override
    public List<Exercisevo> showExercises(Integer id) {
        // TODO Auto-generated method stub
        return exeMapper.showExercises(id);
    }

}
