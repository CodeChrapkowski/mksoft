package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("sprawy")
@RequiredArgsConstructor
public class SprawyController {

    private final SprawyService sprawyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<SprawyResponse> getSprawy(){
        return sprawyService.getSprawy();
    }

}
