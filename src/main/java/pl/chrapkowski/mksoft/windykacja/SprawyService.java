package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SprawyService {

    private final SprawyRepository sprawyRepository;
    private final KlienciRepository klienciRepository;

    private SprawyResponse createSprawyResponse(SprawyEntity sprawyEntity) {
        SprawyResponse sResponse = new SprawyResponse();
        sResponse.setId(sprawyEntity.getId());
        sResponse.setNazwisko_klient(sprawyEntity.getKlient().getNazwisko());
        sResponse.setKwota_zadluzenia(sprawyEntity.getKwota_zadluzenia());
        sResponse.setTermin_zaplaty(sprawyEntity.getTermin_zaplaty());
        sResponse.setNr_sprawy(sprawyEntity.getNr_sprawy());
        sResponse.setRok(sprawyEntity.getRok());
        sResponse.setOpis(sprawyEntity.getOpis());
        sResponse.setUtworzono(sprawyEntity.getUtworzono());
        return sResponse;
    }

    public Collection<SprawyResponse> getSprawy() {
        return sprawyRepository.findAll()
                .stream()
                .map(this::createSprawyResponse)
                .collect(Collectors.toList());
    }

    private SprawyEntity createSprawyEntity(SprawyRequest sprawyRequest) {
        SprawyEntity sEntity = new SprawyEntity();
        sEntity.setKlient(klienciRepository.findById(sprawyRequest.getKlient()).orElseThrow(() -> new RuntimeException("Klient nie istnieje")));
        sEntity.setKwota_zadluzenia(sprawyRequest.getKwota_zadluzenia());
        sEntity.setTermin_zaplaty(sprawyRequest.getTermin_zaplaty());
        sEntity.setNr_sprawy(sprawyRequest.getNr_sprawy());
        sEntity.setRok(sprawyRequest.getRok());
        sEntity.setOpis(sprawyRequest.getOpis());
        sEntity.setUtworzono(LocalDateTime.now());
        return sEntity;
    }

    public void saveSprawyRequest(SprawyRequest sprawyRequest) {
        sprawyRepository.save(createSprawyEntity(sprawyRequest));
    }
}
