package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Collection<StopyProcentoweResponse> getStopyProcentowe(){
        return stopyProcentoweRepository.findAll()
                .stream()
                .map(this::createStopyProcentoweResponse)
                .collect(Collectors.toList());
    }

}
