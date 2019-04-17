package com.lq.job.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.job.domain.ExerciseTopic;
import com.lq.job.domain.Exercisevo;
import com.lq.job.service.ExerciseService;
import com.lq.job.service.ExerciseTopicService;

@Controller
public class ExerciseManageController {
    @Autowired
    private ExerciseTopicService ets;
    @Autowired
    private ExerciseService es;

    @RequestMapping(value="showExeTopic")
    @ResponseBody
    public PageInfo<ExerciseTopic> showExeTopic(@RequestParam(defaultValue="1")Integer page) {
        PageHelper.startPage(page, 5);
        PageInfo<ExerciseTopic> list = new PageInfo<>(ets.showExeTopic());
        return list;
    }
    @RequestMapping(value="showExercises")
    @ResponseBody
    public PageInfo<Exercisevo> showExercises(@RequestParam(defaultValue="1")Integer page, Integer id) {
        PageHelper.startPage(page, 5);
        PageInfo<Exercisevo> list = new PageInfo<>(es.showExercises(id));
        return list;
    }
    @RequestMapping(value="deleteExeTopic")
    @ResponseBody
    public Map<String,Object> delExeTopic(Integer et_id) {
        int i = ets.deleteExetopicById(et_id);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if (i==1) {
            resultMap.put("type", "success");
        }else{
            resultMap.put("type", "fail");
        }
        return resultMap;
    }
    @RequestMapping(value="showExeIndex")
    public String showExeTopicIndex() {
        return "admin/showExeTopic";
    }
    @RequestMapping(value="showExerciseIndex")
    public String showExerciseIndex(Model model, Integer et_id) {
        model.addAttribute("et_id", et_id);
        return "admin/showExercise";
    }

}
