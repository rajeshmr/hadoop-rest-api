package com.indix.interfaces;

import com.indix.representations.Job;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobID;
import org.apache.hadoop.mapred.JobStatus;
import org.apache.hadoop.mapred.RunningJob;

import java.io.IOException;

public class JobInterface {
    private JobClient jobClient = null;

    public JobInterface(JobClient jobClient) {
        this.jobClient = jobClient;
    }

    public JobStatus[] getAllJobs() throws IOException {
        return jobClient.getAllJobs();
    }

   public RunningJob getJobDetails(JobID jobId) throws IOException {
       return jobClient.getJob(jobId);
   }

}
