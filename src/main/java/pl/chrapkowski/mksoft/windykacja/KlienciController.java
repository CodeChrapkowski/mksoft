package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

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

    @GetMapping("{imie}")
    @ResponseStatus(HttpStatus.OK)
    public KlienciEntity getKlientByImie(@PathVariable String imie){
        return klienciService.getKlientByImie(imie);
    }

    @GetMapping("ewa")
    @ResponseStatus(HttpStatus.OK)
    public List<KlienciEntity> getEwa() {
        return klienciService.getEwa();
    }

    @GetMapping("podajImie/{imie}")
    @ResponseStatus(HttpStatus.OK)
    public List<KlienciEntity> getImie(@PathVariable String imie) {
        return klienciService.getImie(imie);
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
