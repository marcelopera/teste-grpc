package br.com.truta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DummyService {
    
    public void realizaServico() {
        Random random = new Random();
        List<Long> timeToSleep = new ArrayList<>();
        timeToSleep.add(1000l);
        timeToSleep.add(5000l);
        try {
            Thread.sleep(timeToSleep.get(Math.floorMod(random.nextInt(), 2)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
