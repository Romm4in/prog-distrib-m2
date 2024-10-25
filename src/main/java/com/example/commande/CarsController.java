package com.example.commande;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

    private final ArrayList<Car> listofCars = new ArrayList<>();

    public CarsController() {
        listofCars.add(new Car("11AA22", "Ferrari", 100));
        listofCars.add(new Car("11AA23", "Porsche", 150));
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> getlistOfCars() {
        return listofCars;
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCar(@PathVariable String plateNumber) throws Exception {
        for (Car car : listofCars) {
            if (plateNumber.equals(car.getPlateNumber())) {
                return new Car(plateNumber, car.getBrand(), car.getPrice());
            }
        }
        throw new Exception("Car not found with plate number: " + plateNumber);
    }

    // Méthode pour louer une voiture
    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car rentCar(@PathVariable String plateNumber,
            @RequestParam boolean rent) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date dateDuJour = new Date();
        String dateDebutLocation = dateFormat.format(dateDuJour);

        for (Car car : listofCars) {
            if (plateNumber.equals(car.getPlateNumber())) {
                if (rent == true) {
                    car.setRented(true);
                    System.out.println("Car rented from " + dateDebutLocation + " to " + "20/12/2050");
                } else {
                    car.setRented(false);
                    System.out.println("Car returned.");
                }
                return car;
            }
        }
        throw new Exception("Car not found with plate number: " + plateNumber);
    }
}