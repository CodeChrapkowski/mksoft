package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SprawyService {

    private final SprawyRepository sprawyRepository;

    private SprawyResponse createSprawyResponse(SprawyEntity sprawyEntity){
        SprawyResponse sResponse =new SprawyResponse();
        sResponse.setId(sResponse.getId());
        sResponse.setNazwisko_klient(sprawyEntity.getKlient().getImie());
        sResponse.setKwota_zadluzenia(sprawyEntity.getKwota_zadluzenia());
        sResponse.setTermin_zaplaty(sprawyEntity.getTermin_zaplaty());
        sResponse.setNr_sprawy(sprawyEntity.getNr_sprawy());
        sResponse.setRok(sprawyEntity.getRok());
        sResponse.setOpis(sprawyEntity.getOpis());
        sResponse.setUtworzono(sprawyEntity.getUtworzono());
        return sResponse;
    }

    public Collection<SprawyResponse> getSprawy(){
        return sprawyRepository.findAll()
                .stream()
                .map(this::createSprawyResponse)
                .collect(Collectors.toList());
    }
}
