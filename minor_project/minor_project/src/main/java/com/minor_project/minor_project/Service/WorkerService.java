package com.minor_project.minor_project.Service;

import com.minor_project.minor_project.Entity.Worker;
import com.minor_project.minor_project.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public Worker saveWorkerDetails(Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getAllWorkerDetails() {
        return workerRepository.findAll();
    }

    public Optional<Worker> getWorkerDetailsById(Long id) {
        return workerRepository.findById(id);
    }

}
