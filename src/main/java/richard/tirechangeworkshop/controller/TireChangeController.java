package richard.tirechangeworkshop.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import richard.tirechangeworkshop.model.AvailableTime;
import richard.tirechangeworkshop.service.TireChangeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tire-change-times")
@CrossOrigin(origins = "http://localhost:4200/")
public class TireChangeController {



    private final TireChangeService tireChangeService = new TireChangeService();
    @GetMapping("/available")
    public ResponseEntity<List<AvailableTime>> findAvailableTimes(
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
            @RequestParam("until") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate until){
            return ResponseEntity.ok(tireChangeService.findAvailableTimes(from, until));
    }
}
