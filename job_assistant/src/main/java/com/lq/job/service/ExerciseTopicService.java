package com.lq.job.service;

import java.util.List;

import com.lq.job.domain.ExerciseTopic;

public interface ExerciseTopicService {
    public int insertExetopic(ExerciseTopic exerciseTopic);
    public List<ExerciseTopic> showExeTopic();
    public int deleteExetopicById(Integer id);

}
