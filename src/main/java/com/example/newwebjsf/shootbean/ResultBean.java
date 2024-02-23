package com.example.newwebjsf.shootbean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.*;

@Named
@ApplicationScoped
public class ResultBean implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private XBean xBean;
    @Inject
    private YBean yBean;
    @Inject
    private RBean rBean;
    private List results = new ArrayList<>();
    public List<Shot> getResults() {
        results = entityManager.createQuery("select s from Shot s").getResultList();
        return results;
    }

    public void setResults(List<Shot> results) {
        this.results = results;
    }
    @Transactional
    public void addNewResult (){
        long start_time = System.nanoTime();
        Shot shot = new Shot();
        shot.setX(xBean.getX());
        shot.setY(yBean.getY());
        shot.setR(rBean.getR());
        if(CheckArea(shot)){
            shot.setResult(true);
        }else{
            shot.setResult(false);
        }
        String data = String.valueOf(new org.joda.time.DateTime());
        shot.setData(data);
        long end_time = System.nanoTime();
        long execution_time = (end_time - start_time)/1000;
        String exec_time = String.valueOf(execution_time) + " mc";
        shot.setExecute_time(exec_time);
//        results.add(shot);
        try{
            entityManager.persist(shot);
        }catch (Exception e){
            //
        }

    }
    @Transactional
    public void clearTable(){
//        results.clear();
//        entityManager.clear();
        entityManager.createQuery("DELETE from Shot").executeUpdate();
    }
    private boolean CheckArea(Shot shot){
        float x = shot.getX();
        float y = shot.getY();
        float r = shot.getR();

        if(x >= 0 && y >= 0){
            if(x*x + y*y <= r*r) return true;
            return false;
        }
        if(x >= 0 && y <= 0){
            if(y >= x/2 - r/2) return true;
            return false;
        }
        if(x <= 0 && y <= 0){
            if((x >= -1 * r/2) && (y >= -1 * r)) return true;
            return false;
        }
        if(x <= 0 && y >= 0){
            return false;
        }
        return false;
    }
}
