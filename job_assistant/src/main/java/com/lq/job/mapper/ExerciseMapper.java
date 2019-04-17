package com.lq.job.mapper;

import java.util.List;

import com.lq.job.domain.Exercise;
import com.lq.job.domain.Exercisevo;

public interface ExerciseMapper {
    public int insertExercise(Exercise exercise);
    public List<Exercisevo> showExercises(Integer id);
}
