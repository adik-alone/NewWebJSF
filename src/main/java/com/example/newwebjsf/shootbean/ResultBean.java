package com.example.newwebjsf.shootbean;

import com.example.newwebjsf.Shot;
import com.example.newwebjsf.TestBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.*;

@Named
@ApplicationScoped
public class ResultBean implements Serializable {
    @Inject
    private XBean xBean;
    @Inject
    private YBean yBean;
    @Inject
    private RBean rBean;
    private List<Shot> results = new ArrayList<>();
    private void initMap(){
//        results = new HashMap<>();
    }

    public List<Shot> getResults() {
        return results;
    }

    public void setResults(List<Shot> results) {
        this.results = results;
    }

    public void addNewResult (){
        Shot shot = new Shot();
        shot.setX(xBean.getX());
        shot.setY(yBean.getY());
        shot.setR(rBean.getR());
        if(true){
            shot.setResult(true);
        }else{
            shot.setResult(false);
        }
        results.add(shot);
    }
    public void clearTable(){
        results.clear();
    }
}
