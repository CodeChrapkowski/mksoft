package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KlienciService {

    private final KlienciRepository klienciRepository;

    public Collection<KlienciResponse> getKlienci() {
        return klienciRepository.findAll()
                .stream()
                .map(this::createKlienciResponse)
                .collect(Collectors.toList());
    }

    private KlienciResponse createKlienciResponse(KlienciEntity klienciEntity) {
        KlienciResponse klienciRes = new KlienciResponse();

        klienciRes.setImie(klienciEntity.getImie());
        klienciRes.setNazwisko(klienciEntity.getNazwisko());
        klienciRes.setPesel(klienciEntity.getPesel());
        klienciRes.setUtworzono(klienciEntity.getUtworzono());
        return klienciRes;
    }

 /*   public KlienciEntity getKlientByImie(String imie) {
        return klienciRepository.findByimie(imie);
    }*/

    public List<KlienciEntity> getImie(String p1) {
        return klienciRepository.findKlient(p1);
    }

    private KlienciEntity createKlientEntity(KlienciRequest klienciRequest) {
        KlienciEntity kl = new KlienciEntity();
        kl.setImie(klienciRequest.getImie());
        kl.setNazwisko(klienciRequest.getNazwisko());
        kl.setPesel(klienciRequest.getPesel());
        kl.setUtworzono(LocalDateTime.now());
        return kl;
    }

    public void saveKlient(KlienciRequest klienciRequest) {
        klienciRepository.save(createKlientEntity(klienciRequest));
    }



    public KlienciEntity updateKlienci(KlienciUpdateRequest klienciUpdateRequest){
        KlienciEntity existingKlientEntity = klienciRepository.findById(klienciUpdateRequest.getId()).orElse(null);
        existingKlientEntity.setImie(klienciUpdateRequest.getImie());
        existingKlientEntity.setNazwisko(klienciUpdateRequest.getNazwisko());
        existingKlientEntity.setPesel(klienciUpdateRequest.getPesel());
       return klienciRepository.save(existingKlientEntity);
    }

    @Transactional
    public void deleteKlient(long id) {
        klienciRepository
                .findById(id)
                .ifPresent(klienciRepository::delete);
    }


}
