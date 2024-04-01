package org.redeemerlives.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    void createJob(Job job);

    Job getJobById(String id);

    Boolean deleteJobById(String id);

    boolean updateJob(String id, Job jobUpdate);
}
