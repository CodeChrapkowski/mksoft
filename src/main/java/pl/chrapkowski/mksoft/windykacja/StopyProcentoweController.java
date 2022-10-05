package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveStopyProcentowe(@RequestBody @Valid StopyProcentoweRequest stopyProcentoweRequest) {
        stopyProcentoweService.saveStopyProcentoweRequest(stopyProcentoweRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStopyProcentowe(@PathVariable("id") Long id) {
        stopyProcentoweService.deleteStopyProcentowe(id);
    }
}
