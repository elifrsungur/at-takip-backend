package gov.dsi.attigh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DistrictAreaNotFoundException extends RuntimeException {
    public DistrictAreaNotFoundException(String m){
        super(m);
    }
}
