package org.redeemerlives.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
        Job job = jobService.getJobById(id);

        if (job != null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJobs(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("job created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable String id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return ResponseEntity.status(HttpStatus.OK).body("job deleted successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable String id, @RequestBody Job jobUpdate) {
        boolean updated = jobService.updateJob(id, jobUpdate);

        if (updated)
            return ResponseEntity.ok("job updated successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
