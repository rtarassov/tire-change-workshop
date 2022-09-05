package richard.tirechangeworkshop.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import richard.tirechangeworkshop.model.Answer;
import richard.tirechangeworkshop.model.TireChangeTime;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/tire-change-times")
public class TireChangeController {

    @GetMapping("/available")
    public List<Answer> findAvailableTimes(@RequestParam("from") String from,
                                           @RequestParam("until") String until){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9003/api/v1/tire-change-times/available?from=" + from + "&until=" + until;
        Answer[] times = restTemplate.getForObject(url, Answer[].class);
        return Arrays.asList(times);
    }


}
