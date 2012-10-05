package com.indix.hadoop;

import com.yammer.metrics.core.HealthCheck;
import org.apache.hadoop.mapred.JobClient;

public class HadoopRestAPIServiceHealthCheck extends HealthCheck{
    private JobClient jobClient;
    public HadoopRestAPIServiceHealthCheck(JobClient jobClient) {
        super("HadoopRestAPIServiceHealthCheck");
        this.jobClient = jobClient;

    }

    @Override
    protected Result check() throws Exception {
        if(jobClient.getClusterStatus() == null){
          return Result.unhealthy("Cluster is Down!");
        }
        return Result.healthy();
    }
}
