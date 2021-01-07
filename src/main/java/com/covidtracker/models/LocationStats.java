package com.covidtracker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationStats {
    private String state;
    private String country;
    private Long totalCases;
    private Long diffFromPreviousDay;
}