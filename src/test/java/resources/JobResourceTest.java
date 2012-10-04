package resources;

import com.indix.resources.JobResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class JobResourceTest extends ResourceTest {

    private JobResource jobResource;


    @Before
    public void init(){
        jobResource = new JobResource(jobClient);
    }

    @Test
    public void shouldGetJobHistory() throws IOException {
        Response res = jobResource.getJobHistory();
        assertThat(res.getStatus(),is(200));
    }
}
