package com.seraleman.loggerms.components.reason;

import com.seraleman.loggerms.components.reason.dao.services.IReasonService;

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
@RequestMapping("api/ms/reasons")
public class ReasonController {

    @Autowired
    private IReasonService reasonService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return reasonService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return reasonService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Reason reason) {
        return reasonService.create(reason);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Reason reason) {
        return reasonService.update(id, reason);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return reasonService.delete(id);
    }
}
