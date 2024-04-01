package org.redeemerlives.firstjobapp.job.impl;

import org.redeemerlives.firstjobapp.job.Job;
import org.redeemerlives.firstjobapp.job.JobRepository;
import org.redeemerlives.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(String id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Boolean deleteJobById(String id) {
        Optional<Job> job = jobRepository.findById(id);
        job.ifPresent(jobRepository::delete);
        return job.isPresent();
    }

    @Override
    public boolean updateJob(String id, Job jobUpdate) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            job.get().setTitle(jobUpdate.getTitle());
            job.get().setDescription(jobUpdate.getDescription());
            job.get().setMinSalary(jobUpdate.getMinSalary());
            job.get().setMaxSalary(jobUpdate.getMaxSalary());
            job.get().setLocation(jobUpdate.getLocation());
            jobRepository.save(job.get());
            return true;
        }

        return false;
    }
}
