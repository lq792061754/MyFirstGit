package com.lq.job.mapper;

import java.util.List;

import com.lq.job.domain.ExerciseTopic;

public interface ExerciseTopicMapper {
    public int insertExetopic(ExerciseTopic exerciseTopic);
    public List<ExerciseTopic> showExeTopic();
    public int deleteExetopicById(Integer id);

}
