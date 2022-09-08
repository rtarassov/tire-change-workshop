package richard.tirechangeworkshop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import richard.tirechangeworkshop.model.AvailableTime;
import richard.tirechangeworkshop.model.TireChangeTimesResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TireChangeService {


    /**
    @Value("${urlInApplicationProperties}")
    private String urlInApplicationProperties;
    Couldn't get this to work with IntelliJ Community edition.
    **/
    private String baseUrl = "http://localhost:9003/api/v1/tire-change-times/";


    public List<AvailableTime> findAvailableTimes(LocalDate from, LocalDate until) {
        if (from == null || until == null || until.isBefore(from)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please select both dates");
        }
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "available?from=" + from.format(DateTimeFormatter.ISO_DATE) + "&until=" + until.format(DateTimeFormatter.ISO_DATE);
        log.info("Creating a request to {}", url);
        HttpEntity<Void> requestEntity = new HttpEntity<>(new HttpHeaders());

        ObjectMapper objectMapper = new XmlMapper();
        TireChangeTimesResponse tireChangeTimesResponse;
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    url, HttpMethod.GET, requestEntity, String.class, from, until);
            tireChangeTimesResponse = objectMapper.readValue(response.getBody(), TireChangeTimesResponse.class);
            return tireChangeTimesResponse.getAvailableTimes();
        } catch (Exception e) {
            log.error("Failed to convert available times from XML");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to load available times");
        }
    }
}
