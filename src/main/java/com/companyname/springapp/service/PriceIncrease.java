package com.companyname.springapp.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class PriceIncrease {

    @Min(0)
    @Max(50)
    @NotNull
    private Integer percentage;

    public void setPercentage(int i) {
        percentage = i;
        log.info("Percentage set to " + i);
    }

    public Integer getPercentage() {
        return percentage;
    }
}
