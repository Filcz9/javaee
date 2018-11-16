package com.fczyz.sklep.service;

import java.util.ArrayList;
import java.util.List;

import com.fczyz.sklep.game.*;

public class SurveyService {

    public static List<Survey> db = new ArrayList<Survey>();

    public void add(Survey survey){
    	Survey newsurvey = new Survey(survey.getFrom(), survey.getTo(), survey.getFreq(), survey.getNotice());
    	db.add(newsurvey);
    }

    public List<Survey> getAllSurveys(){
        return db;
    }
}
