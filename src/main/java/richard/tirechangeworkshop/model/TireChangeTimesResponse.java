package richard.tirechangeworkshop.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class TireChangeTimesResponse {
    @JacksonXmlProperty(localName = "availableTime")
    @JacksonXmlElementWrapper(useWrapping=false)
    private List<AvailableTime> availableTimes;
}
