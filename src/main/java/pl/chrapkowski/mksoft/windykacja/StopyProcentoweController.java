package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("stopy")
@RequiredArgsConstructor
public class StopyProcentoweController {

    private final StopyProcentoweService stopyProcentoweService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<StopyProcentoweResponse> getStopyProcentowe() {
        return stopyProcentoweService.getStopyProcentowe();
    }


}
