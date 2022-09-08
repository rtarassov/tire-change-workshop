package richard.tirechangeworkshop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class AvailableTime {

    private Timestamp time;
    private String uuid;
}
