package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveSprawy(@RequestBody @Valid SprawyRequest sprawyRequest){
        sprawyService.saveSprawyRequest(sprawyRequest);
    }


}
