package com.seraleman.loggerms.components.registry;

import com.seraleman.loggerms.components.registry.dao.services.IRegistryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ms/logs")
public class RegistryController {

    @Autowired
    private IRegistryService registryService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return registryService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return registryService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Registry registry) {
        return registryService.create(registry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Registry registry) {
        return registryService.update(id, registry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return registryService.delete(id);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<?> showRegistriesByUser(@PathVariable String user) {
        return registryService.registriesByUser(user);
    }

    @GetMapping("/reason/{reasonId}")
    public ResponseEntity<?> showRegistriesByReasonId(@PathVariable String reasonId) {
        return registryService.registriesByReasonId(reasonId);
    }

    // https://stackoverflow.com/questions/26233882/javascript-date-to-java-time-localdate
    // Serializar un LocalDateTime desde JavaScript!!!
    @GetMapping("/date/{date}")
    public ResponseEntity<?> showRegistriesByDate(@PathVariable String date) {
        return registryService.registriesByDate(date);
    }

    // https://stackoverflow.com/questions/26233882/javascript-date-to-java-time-localdate
    // Serializar un LocalDateTime desde JavaScript!!!
    @GetMapping("/reason/{reasonId}/{date}")
    public ResponseEntity<?> showRegistriesByReasonIdAndDate(@PathVariable String reasonId,
            @PathVariable String date) {
        return registryService.registriesByReasonIdAndDate(reasonId, date);
    }

}
