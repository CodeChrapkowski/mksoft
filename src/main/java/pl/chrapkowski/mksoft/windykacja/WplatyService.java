package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WplatyService {

    private final WplatyRepository wplatyRepository;

    private WplatyResponse createWplatyResponse(WplatyEntity wplatyEntity){
        WplatyResponse wResponse = new WplatyResponse();
        wResponse.setId(wplatyEntity.getId());
        wResponse.setData_wplaty(wplatyEntity.getData_wplaty());
        wResponse.setKowta(wplatyEntity.getKowta());
        wResponse.setOdsetki(wplatyEntity.getOdsetki());
        wResponse.setUtworzono(wplatyEntity.getUtworzono());
        return wResponse;
    }

    public Collection<WplatyResponse> getWplaty(){
        return wplatyRepository.findAll()
                .stream()
                .map(this::createWplatyResponse)
                .collect(Collectors.toList());
    }

}
