package com.covidtracker.controller;

import java.util.List;

import com.covidtracker.models.LocationStats;
import com.covidtracker.services.CovidDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/")
    public String home(ModelMap model) {
        List<LocationStats> allStats = covidDataService.getAllStats();
        long totalCases = allStats.stream().mapToLong(stat -> stat.getTotalCases()).sum();
        long totalNewCases = allStats.stream().mapToLong(stat -> stat.getDiffFromPreviousDay()).sum();
        model.put("locationStats", allStats);
        model.put("totalCases", totalCases);
        model.put("totalNewCases", totalNewCases);
        return "home";
    }
}
