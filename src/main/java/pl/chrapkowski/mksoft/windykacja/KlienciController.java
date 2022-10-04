package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("klienci")
@RequiredArgsConstructor
public class KlienciController {

    private final KlienciService klienciService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<KlienciResponse> getKlienci() {
        return klienciService.getKlienci();
    }

    @GetMapping("klient")
    @ResponseStatus(HttpStatus.OK)
    public Collection<KlienciResponse1> getKlientImie() {
        return klienciService.getKlientImie();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveKlient(@RequestBody @Valid KlienciRequest klientRequest) {
        klienciService.saveKlient(klientRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteklient(@PathVariable("id") Long id) {
        klienciService.deleteKlient(id);
    }

}
