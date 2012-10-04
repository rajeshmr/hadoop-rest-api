package com.indix.interfaces;

import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.*;

public class JobInterface {
    private JobClient jobClient = null;

    public JobInterface(JobClient jobClient) {
        this.jobClient = jobClient;
    }

    public List<JobID> getJobHistory() throws IOException {
        List<JobID> history = new ArrayList<JobID>();
        for (JobStatus jobStatus : jobClient.getAllJobs()) {
            history.add(jobStatus.getJobID());
        }
        return history;
    }

    public JobStatus[] getAllJobs() throws IOException {
        return jobClient.getAllJobs();
    }

   public RunningJob getJobDetails(JobID jobId) throws IOException {
       return jobClient.getJob(jobId);
   }

    public Map<String,Object> getJobCounters(JobID jobID) throws IOException {
        RunningJob runningJob = getJobDetails(jobID);
        Counters counters = runningJob.getCounters();
        Map<String,Object> response = new HashMap<String, Object>();
        Map<String,Object> counter;
        Counters.Counter c;
        for (String groupName : counters.getGroupNames()) {
            counter = new HashMap<String, Object>();
            for(Iterator i = counters.getGroup(groupName).iterator();i.hasNext();){
                c =((Counters.Counter)i.next());
                counter.put(c.getName(), c);
            }
            response.put(groupName,counter);
        }
        return response;
    }

}
