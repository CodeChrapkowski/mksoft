package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("wplaty")
@RequiredArgsConstructor
public class WplatyController {

    private final WplatyService wplatyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<WplatyResponse> getWplaty() {
        return wplatyService.getWplaty();
    }
}
