package com.indix;

import com.indix.configurations.HadoopRestAPIConfiguration;
import com.indix.resources.JobResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobTracker;
import org.eclipse.jdt.internal.core.SourceType;

public class HadoopRestAPIService extends Service<HadoopRestAPIConfiguration> {

    public static JobClient jobClient = null;
    private Configuration conf;

    public static void main(String[] args) throws Exception {
        new HadoopRestAPIService().run(new String[]{"server"});
    }
    @Override
    protected void initialize(HadoopRestAPIConfiguration hadoopRestAPIConfiguration, Environment environment) throws Exception {
        conf = new Configuration();
        conf.addResource(new Path("/home/user5/hadoop/conf/core-site.xml"));
        conf.addResource(new Path("/home/user5/hadoop/conf/hdfs-site.xml"));
        conf.addResource(new Path("/home/user5/hadoop/conf/mapred-site.xml"));
//        conf.set("mapred.job.tracker","localhost:9001");
//        conf.set("fs.default.name","hdfs://localhost:9000");
        jobClient = new JobClient(JobTracker.getAddress(conf),conf);
        environment.addResource(new JobResource(jobClient));
    }
}
