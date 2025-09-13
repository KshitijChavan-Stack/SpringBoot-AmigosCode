package com.amigoscode;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepo softwareEngineerRepo;

    public SoftwareEngineerService(SoftwareEngineerRepo softwareEngineerRepo) {
        this.softwareEngineerRepo = softwareEngineerRepo;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepo.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        // just adding new data
        softwareEngineerRepo.save(softwareEngineer);

    }


    public SoftwareEngineer getSoftwareEngineerById(int id) {
        return softwareEngineerRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " Not Found"
                ) );
    }

    public void DeleteSoftwareEngineerById(Integer id) {

        boolean ifexists = softwareEngineerRepo.existsById(id);

        if (!ifexists) {
            throw new IllegalStateException(
                    id + " Not Found"
            );
        }

        softwareEngineerRepo.deleteById(id);

    }
}
