package pl.chrapkowski.mksoft.ksiegowosc;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("kontrahenci")
@RequiredArgsConstructor
public class KontrahenciController {

    private final KontrahenciService kontrahenciService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<KontrahenciResponse> getKontrahenci(){
        return kontrahenciService.getKontrahenci();


    }

}
