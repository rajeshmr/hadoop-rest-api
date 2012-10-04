package com.indix;

import com.indix.configurations.HadoopRestAPIConfiguration;
import com.indix.hadoop.HadoopConnection;
import com.indix.hadoop.HadoopController;
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
        HadoopConnection hadoopConnection = new HadoopConnection(hadoopRestAPIConfiguration);
        HadoopController hadoopController = new HadoopController(hadoopConnection);
        jobClient = hadoopController.getJobClient();
        environment.addResource(new JobResource(jobClient));
    }
}
