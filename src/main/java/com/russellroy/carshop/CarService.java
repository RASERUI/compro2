package com.russellroy.carshop;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
public class CarService {
    private static final String FILE = "cars.csv";
    private int nextId = 1;

    public List<Car> getAll() {
        List<Car> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] f = line.split(",");
                if (f.length < 9) continue; // skip bad rows

                Car c = new Car();
                c.setCarId(Integer.parseInt(f[0]));
                c.setLicensePlateNumber(f[1]);
                c.setMake(f[2]);
                c.setModel(f[3]);

                // FIX: handle empty year safely
                if (f[4].isEmpty()) {
                    c.setYear(null);
                } else {
                    c.setYear(Integer.parseInt(f[4]));
                }

                c.setColor(f[5]);
                c.setBodyType(f[6]);
                c.setEngineType(f[7]);
                c.setTransmission(f[8]);

                list.add(c);
                nextId = c.getCarId() + 1;
            }
        } catch (IOException ignored) {}
        return list;
    }

    public void save(Car c) {
        c.setCarId(nextId++);
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(String.join(",",
                    String.valueOf(c.getCarId()),
                    c.getLicensePlateNumber(),
                    c.getMake(),
                    c.getModel(),
                    (c.getYear() == null ? "" : String.valueOf(c.getYear())),
                    c.getColor(),
                    c.getBodyType(),
                    c.getEngineType(),
                    c.getTransmission()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
