package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Address;
import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.gateway.repository.AddressRepository;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.usecase.export.ImportCsv;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ImportCsvClinicGenerate implements ImportCsv {

    @Autowired
    ClinicRepository clinicRepository;

    @Autowired
    AddressRepository addressRepository;

    public static List<Clinic> readSaveClinicWithAddress(List<Address> addressList) {
        FileReader file = null;
        Scanner entrance = null;
        Boolean internError = false;
        List<Clinic> list = new ArrayList();
        String fileName = "clinic.csv";

        try {
            file = new FileReader(fileName);
            entrance = new Scanner(file).useDelimiter(";|\\n");
        } catch (FileNotFoundException error) {
            System.out.println("File not found");
            System.exit(1);
        }
        Random generator = new Random();

        try {
            while (entrance.hasNext()) {
                Integer id = list.size() + 1;
                String name = entrance.next();
                String phone = "(11)" + generator.nextInt(8999) + "-" + generator.nextInt(9999);
                list.add(new Clinic(id, name, phone,"", addressList.get(id - 1)));
            }
        } catch (NoSuchElementException error) {
            System.out.println("File with problems");
            internError = true;
        } catch (IllegalStateException error) {
            System.out.println("Error reading file");
            internError = true;
        } finally {
            entrance.close();
            try {
                file.close();
            } catch (IOException error) {
                System.out.println("Error closing file");
                internError = true;
            }
            if (internError) {
                System.exit(1);
            }
        }

        list.removeIf(clinic -> clinic.getName().equals(""));

        return list;
    }

    public static List<Address> readSaveAddress() {
        FileReader file = null;
        Scanner entrance = null;
        Boolean internError = false;
        String fileName = "address.csv";

        try {
            file = new FileReader(fileName);
            entrance = new Scanner(file).useDelimiter(";|\\n");
        } catch (FileNotFoundException error) {
            System.out.println("File not found " + error);
            System.exit(1);
        }

        List<Address> listAddress = new ArrayList<>();

        List<String> states = List.of("SP", "RJ", "ES", "MT", "MG");

        Random generator = new Random();
        try {
            while (entrance.hasNext()) {
                Integer id = listAddress.size() + 1;
                String cep = generator.nextInt(+99999) + "-" + generator.nextInt(+999);
                String state = states.get(generator.nextInt(states.size()));
                String publicPlace = "";
                String street = StrFormat.toTitledCase(entrance.next());
                String district = StrFormat.toTitledCase(entrance.next());
                String city = "Jd " + StrFormat.toTitledCase(district);
                String number = String.valueOf(generator.nextInt(+2000));
                String complement = "";
                Address address = new Address(id, cep, city, state, district, street, publicPlace, number, complement);
                listAddress.add(address);
            }
        } catch (NoSuchElementException error) {
            System.out.println("File with problems");
            internError = true;
        } catch (IllegalStateException error) {
            System.out.println("Error reading file");
            internError = true;
        } finally {
            entrance.close();
            try {
                file.close();
            } catch (IOException error) {
                System.out.println("Error closing file");
                internError = true;
            }
            if (internError) {
                System.exit(1);
            }
        }

        return listAddress;
    }

    @Override
    public void run() {
        List<Address> addressList = readSaveAddress();
        List<Clinic> listClinic = readSaveClinicWithAddress(addressList);
        clinicRepository.saveAllAndFlush(listClinic);
    }
}
