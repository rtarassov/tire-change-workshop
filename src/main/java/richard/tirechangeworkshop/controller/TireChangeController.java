package richard.tirechangeworkshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tire-change-times")
public class TireChangeController {

    @GetMapping("/available")
    public List<Object> findAvailableTimes(@PathVariable("from") String from,
                                           @PathVariable("until") String until){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9003/api/v1/tire-change-times/available?from=" + from + "&until=" + until;
        Object[] times = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(times);
    }
}
