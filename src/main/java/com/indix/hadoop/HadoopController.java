package com.indix.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobTracker;

import java.io.IOException;

public class HadoopController {

    private JobClient jobClient;

    public HadoopController(HadoopConnection hadoopConnection) throws IOException {
        String hadoopHome = hadoopConnection.getHadoopHome();
        Configuration conf = new Configuration();
        conf.addResource(new Path(hadoopHome+"/conf/core-site.xml"));
        conf.addResource(new Path(hadoopHome+"/conf/hdfs-site.xml"));
        conf.addResource(new Path(hadoopHome+"/conf/mapred-site.xml"));
        jobClient = new JobClient(JobTracker.getAddress(conf),conf);
    }

    public JobClient getJobClient() {
        return jobClient;
    }
}
