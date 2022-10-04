package pl.chrapkowski.mksoft.windykacja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
        return klienciRes;
    }

    public Collection<KlienciResponse1> getKlient1(){
        return klienciRepository.finfbyImie()
                .stream()
                .map(this::createKlienciResponse1)
                .collect(Collectors.toList());
    }

    private KlienciResponse1 createKlienciResponse1(KlienciEntity klienciEntity) {
        KlienciResponse1 klienciRes1 = new KlienciResponse1();

        klienciRes1.setImie(klienciEntity.getImie());
    //    klienciRes1.setNazwisko(klienciEntity.getNazwisko());
      //  klienciRes1.setPesel(klienciEntity.getPesel());
        return klienciRes1;
    }
    private KlienciEntity createKlientEntity(KlienciRequest klienciRequest){
        KlienciEntity kl = new KlienciEntity();
        kl.setImie(klienciRequest.getImie());
        kl.setNazwisko(klienciRequest.getNazwisko());
        kl.setPesel(klienciRequest.getPesel());
        return kl;
    }

    public void saveKlient(KlienciRequest klienciRequest){
        klienciRepository.save(createKlientEntity(klienciRequest));
    }

    @Transactional
    public void deleteKlient(long id){
        klienciRepository
                .findById(id)
                .ifPresent(klienciRepository::delete);
    }


}
