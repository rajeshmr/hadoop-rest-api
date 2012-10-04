package com.indix.resources;

import com.indix.interfaces.JobInterface;
import com.indix.representations.Job;
import org.apache.hadoop.mapred.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Produces(MediaType.APPLICATION_JSON)
@Path("/jobs")
public class JobResource {
    private JobInterface jobInterface;
    private Map<String, Object> counters;
    private List<JobID> history;

    public JobResource(JobClient jobClient) {
        jobInterface = new JobInterface(jobClient);
    }

    @GET
    public Response getJobs() throws IOException {
        JobStatus[] jobs = jobInterface.getAllJobs();
        return Response.ok().entity(jobs).build();
    }

    @GET
    @Path("/{jtIdentifier}/{id}")
    public Response getJobDetails(@PathParam("jtIdentifier") String jtIdentifier,@PathParam("id") int id) throws IOException {
        JobID jobID = new JobID(jtIdentifier,id);
        RunningJob runningJob = jobInterface.getJobDetails(jobID);
        return Response.ok().entity(runningJob).build();
    }

    @GET
    @Path("/{jtIdentifier}/{id}/counters")
    public Response getJobCounters(@PathParam("jtIdentifier") String jtIdentifier,@PathParam("id") int id) throws IOException {
        JobID jobID = new JobID(jtIdentifier,id);
        counters = jobInterface.getJobCounters(jobID);
        return Response.ok().entity(counters).build();
    }

    @GET
    @Path("/history")
    public Response getJobHistory() throws IOException {
        history = jobInterface.getJobHistory();
        return Response.ok().entity(history).build();
    }

}
