package resources;

import com.indix.configurations.HadoopRestAPIConfiguration;
import com.indix.hadoop.HadoopConnection;
import com.indix.hadoop.HadoopController;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobTracker;
import org.junit.BeforeClass;
import org.junit.Ignore;

import java.io.IOException;

public class ResourceTest {

    protected static JobClient jobClient;

    @BeforeClass
    public static void initTestDeps() throws IOException {
        HadoopConnection hadoopConnection = new HadoopConnection(new HadoopRestAPIConfiguration());
        HadoopController hadoopController = new HadoopController(hadoopConnection);
        jobClient = hadoopController.getJobClient();
    }
}
