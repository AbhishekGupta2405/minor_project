package com.minor_project.minor_project.Controller;


import com.minor_project.minor_project.Entity.Worker;
import com.minor_project.minor_project.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/save")
    public ResponseEntity<Worker> saveWorkerDetails(@RequestBody Worker worker) {
        Worker savedWorkerDetails = workerService.saveWorkerDetails(worker);
        return new ResponseEntity<>(savedWorkerDetails, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getAllWorkerDetails() {
        List<Worker> workerDetailsList =workerService. getAllWorkerDetails();
        return new ResponseEntity<>(workerDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerDetailsById(@PathVariable Long id) {
        Optional<Worker> workerDetails = workerService.getWorkerDetailsById(id);
        return workerDetails.map(details -> new ResponseEntity<>(details, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
