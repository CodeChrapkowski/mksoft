package pl.chrapkowski.mksoft.ksiegowosc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KontrahenciService {

    private final KontrahenciRepository kontrahenciRepository;

    private KontrahenciResponse createKontrachenciResponse(KontrahenciEntity kontrahenciEntity){
        KontrahenciResponse konResponse =new KontrahenciResponse();
        konResponse.setId(konResponse.getId());
        konResponse.setNazwa(kontrahenciEntity.getNazwa());
        konResponse.setKonto(kontrahenciEntity.getKonto());
        konResponse.setUtworzono(kontrahenciEntity.getUtworzono());
        return konResponse;
    }

    public Collection<KontrahenciResponse> getKontrahenci(){
        return kontrahenciRepository.findAll()
                .stream()
                .map(this::createKontrachenciResponse)
                .collect(Collectors.toList());
    }

}
