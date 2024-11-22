package com.minor_project.minor_project.Controller;



import com.minor_project.minor_project.Entity.Appointment;
import com.minor_project.minor_project.Service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
//        return appointmentService.getAppointmentById(id)
//                .map(appointment -> ResponseEntity.ok(appointment))
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found"));
//    }
@GetMapping("/{id}")
public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
    return appointmentService.getAppointmentById(id)
            .map(appointment -> ResponseEntity.ok(appointment))
            .orElseGet(() -> {
                Appointment notFoundAppointment = new Appointment();
                notFoundAppointment.setTaskLocation("Not Found");
                notFoundAppointment.setTaskDuration("N/A");
                notFoundAppointment.setTaskDetails("No appointment found for this ID");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundAppointment);
            });
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
