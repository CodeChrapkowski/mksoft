package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StopyProcentoweService {
    private final StopyProcentoweRepository stopyProcentoweRepository;


    private StopyProcentoweResponse createStopyProcentoweResponse(StopyProcentoweEntiti stopyProcentoweEntiti) {
        StopyProcentoweResponse spResponse = new StopyProcentoweResponse();
        spResponse.setData(stopyProcentoweEntiti.getData());
        spResponse.setOpis(stopyProcentoweEntiti.getOpis());
        spResponse.setStopa(stopyProcentoweEntiti.getStopa());
        spResponse.setUtworzono(stopyProcentoweEntiti.getUtworzono());
        return spResponse;
    }

    public Collection<StopyProcentoweResponse> getStopyProcentowe() {
        return stopyProcentoweRepository.findAll()
                .stream()
                .map(this::createStopyProcentoweResponse)
                .collect(Collectors.toList());
    }

    private StopyProcentoweEntiti createStopyProcentoweEntity(StopyProcentoweRequest stopyProcentoweRequest) {
        StopyProcentoweEntiti spEntity = new StopyProcentoweEntiti();
        spEntity.setData(stopyProcentoweRequest.getData());
        spEntity.setOpis(stopyProcentoweRequest.getOpis());
        spEntity.setStopa(stopyProcentoweRequest.getStopa());
        spEntity.setUtworzono(LocalDateTime.now());
        return spEntity;
    }

    public void saveStopyProcentoweRequest(StopyProcentoweRequest stopyProcentoweRequest) {
        stopyProcentoweRepository.save(createStopyProcentoweEntity(stopyProcentoweRequest));
    }

}
