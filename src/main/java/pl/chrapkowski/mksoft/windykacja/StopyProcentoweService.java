package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StopyProcentoweService {
    private final StopyProcentoweRepository stopyProcentoweRepository;


    private StopyProcentoweResponse createStopyProcentoweResponse(StopyProcentoweEntity stopyProcentoweEntiti) {
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

    private StopyProcentoweEntity createStopyProcentoweEntity(StopyProcentoweRequest stopyProcentoweRequest) {
        StopyProcentoweEntity spEntity = new StopyProcentoweEntity();
        spEntity.setData(stopyProcentoweRequest.getData());
        spEntity.setOpis(stopyProcentoweRequest.getOpis());
        spEntity.setStopa(stopyProcentoweRequest.getStopa());
        spEntity.setUtworzono(LocalDateTime.now());
        return spEntity;
    }

    public void saveStopyProcentoweRequest(StopyProcentoweRequest stopyProcentoweRequest) {
        stopyProcentoweRepository.save(createStopyProcentoweEntity(stopyProcentoweRequest));
    }

    public StopyProcentoweEntity updateStopyProcentowe(StopyProcentoweEntity stopyProcentoweEntity) {
        StopyProcentoweEntity existingStopyProcentoweEntity = stopyProcentoweRepository.findById(stopyProcentoweEntity.getId()).orElse(null);
        existingStopyProcentoweEntity.setData(stopyProcentoweEntity.getData());
        existingStopyProcentoweEntity.setStopa(stopyProcentoweEntity.getStopa());
        existingStopyProcentoweEntity.setOpis(stopyProcentoweEntity.getOpis());
        return stopyProcentoweRepository.save(existingStopyProcentoweEntity);
    }

    @Transactional
    public void deleteStopyProcentowe(long id) {
        stopyProcentoweRepository
                .findById(id)
                .ifPresent(stopyProcentoweRepository::delete);
    }
}
