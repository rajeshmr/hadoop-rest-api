package resources;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobTracker;
import org.junit.BeforeClass;
import org.junit.Ignore;

import java.io.IOException;

public class ResourceTest {

    protected static JobClient jobClient;
    protected static Configuration conf;

    @BeforeClass
    public static void initTestDeps() throws IOException {
        conf = new Configuration();
        conf.addResource(new Path("/home/user5/hadoop/conf/core-site.xml"));
        conf.addResource(new Path("/home/user5/hadoop/conf/hdfs-site.xml"));
        conf.addResource(new Path("/home/user5/hadoop/conf/mapred-site.xml"));
        jobClient = new JobClient(JobTracker.getAddress(conf),conf);
    }
}
