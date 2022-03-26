package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;

import java.io.*;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class DoctorImportExport {

    public void recordRegistry(String registry, String fileName) {
        BufferedWriter exit = null;
        System.out.println(registry);

        try {
            exit = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException error) {
            System.out.println("Error opening file: " + error.getMessage());
        }

        try {
            exit.append(registry + "\n");
            exit.close();
        } catch (IOException error) {
            System.out.println("Error opening file: " + error.getMessage());
        }
    }

    public void recordTxtFile(List<Doctor> list) {
        File file = new File("all-doctors.txt");
        file.delete();

        int countRegDates = 0;

        String header = "00MEDICO20212";
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += dateFormat.format(todayDate);
        header += "01";

        recordRegistry(header, "Todos-os-medicos.txt");

        for (Doctor a : list) {
            String body = "02";
            body += String.format("%-40.40s", a.getName());
            body += String.format("%-4.4s", a.getUbs().getUbsId());
            body += String.format("%-15.15s", a.getUser().getCpf());
            body += String.format("%-50.50s", a.getUser().getEmail());
            body += String.format("%-30.30s", a.getSpecialty().getDescription());

            countRegDates++;
            recordRegistry(body, "all-doctors.txt");
        }

        String trailer = "01";
        trailer += String.format("%010d", countRegDates);
        recordRegistry(trailer, "all-doctors.txt");
        System.out.println(trailer);
    }
}
