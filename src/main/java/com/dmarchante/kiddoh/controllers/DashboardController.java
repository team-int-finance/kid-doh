//package com.dmarchante.kiddoh.controllers;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.dmarchante.kiddoh.dto.DataPoint;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class DashboardController {
//    @GetMapping("/dashboard")
//    public String getDashboard(ModelMap m) throws IOException {
//        List<DataPoint> dataPoints = new ArrayList<>();
//
//        DataPoint dataPoint = new DataPoint();
//        dataPoint.setX(10);
//        dataPoint.setY(15);
//        dataPoints.add(dataPoint);
//
//        dataPoint = new DataPoint();
//        dataPoint.setX(20);
//        dataPoint.setY(21);
//        dataPoints.add(dataPoint);
//
//        dataPoint = new DataPoint();
//        dataPoint.setX(30);
//        dataPoint.setY(8);
//        dataPoints.add(dataPoint);
//
//        m.addAttribute("dataPoints",dataPoints);
//
//        return "dashboard";
//    }
//}