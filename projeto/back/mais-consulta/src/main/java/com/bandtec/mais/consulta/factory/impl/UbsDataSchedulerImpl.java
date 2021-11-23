package com.bandtec.mais.consulta.factory.impl;

import com.bandtec.mais.consulta.factory.UbsDataScheduler;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class UbsDataSchedulerImpl implements UbsDataScheduler {

    Timer timer = new Timer();



    @Override
    public void run() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                //TODO fazer logica e pegar o dia de hoje e apagar o dia anterior para não lotar o banco
            }

        }, 1000, 5000);
    }
}