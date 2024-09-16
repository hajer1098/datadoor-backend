package com.hajer.DataDoor.Controllers;


import com.hajer.DataDoor.Services.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("statistics")
@AllArgsConstructor
public class StatisticsController {

    private final StatisticsService service;

}
