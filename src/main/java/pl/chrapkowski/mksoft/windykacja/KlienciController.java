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

    @GetMapping("find/{p1}")
    @ResponseStatus(HttpStatus.OK)
    public List<KlienciEntity> findKlient(@PathVariable String p1) {
        return klienciService.getImie(p1);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public KlienciEntity updateKlienci(@RequestBody KlienciUpdateRequest klienciUpdateRequest) {
        return klienciService.updateKlienci(klienciUpdateRequest);

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
