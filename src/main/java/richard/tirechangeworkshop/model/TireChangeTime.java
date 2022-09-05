package richard.tirechangeworkshop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@RequiredArgsConstructor
public class TireChangeTime {

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private String from;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private String until;

    private String uuid;
}
