package com.mycars.controllers;

import com.mycars.domain.CarForm;
import com.mycars.repos.CarFormsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private CarFormsRepo carRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/main")
    public String main(Model model){
        Iterable<CarForm> carForms = carRepo.findAll();

        model.addAttribute("carForms",carForms);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam String carName,
            @RequestParam String text,
            @RequestParam Integer carCost,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
        CarForm car = new CarForm(carName, text, carCost, localDateTime);

        if (file != null && !file.getOriginalFilename().isEmpty()){
            File uploaddir = new File(uploadPath);
            if (!uploaddir.exists()){
                uploaddir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resulteFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resulteFilename));

            car.setCarPic(resulteFilename);
        }

        carRepo.save(car);
        Iterable<CarForm> carForms = carRepo.findAll();
        model.addAttribute("carForms",carForms);

        return "main";
    }

}
