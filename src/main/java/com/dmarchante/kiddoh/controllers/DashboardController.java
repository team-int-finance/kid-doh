package com.dmarchante.kiddoh.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dmarchante.kiddoh.dto.DataPoint;
import com.dmarchante.kiddoh.implementations.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

//    @Autowired
//    private DashboardService dashboardService;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String springMVC(ModelMap modelMap) {
//        List<List<Map<Object, Object>>> dashboardDataList = dashboardService.getDashboardData();
//        modelMap.addAttribute("dataPointsList", dashboardDataList);
//        return "dashboardTest";
//    }
    @GetMapping("/dashboard")
    public String getDashboard(ModelMap m) throws IOException {

        List<DataPoint> dataPoints = new ArrayList<>();

        DataPoint dataPoint = new DataPoint();
        dataPoint.setX(10);
        dataPoint.setY(15);
        dataPoints.add(dataPoint);

        dataPoint = new DataPoint();
        dataPoint.setX(20);
        dataPoint.setY(21);
        dataPoints.add(dataPoint);

        dataPoint = new DataPoint();
        dataPoint.setX(30);
        dataPoint.setY(8);
        dataPoints.add(dataPoint);

        m.addAttribute("dataPoints",dataPoints);

        return "dashboardTest";
    }
}