package com.myown.jenkins.ml;

import com.myown.jenkins.ml.model.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tests")
public class TestResource {

    private Set<Test> tests = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public TestResource() {
        tests.add(new Test("Apple", "Winter fruit"));
        tests.add(new Test("Pineapple", "Tropical fruit"));
    }

    @GET
    public Response list() {
        return Response.ok(tests).build();
    }

    @POST
    public Response add(Test test) {
        tests.add(test);
        return Response.ok(tests).build();
    }

    @DELETE
    public Response delete(Test test) {
        tests.removeIf(existingTest -> existingTest.name.contentEquals(test.name));
        return Response.ok(tests).build();
    }
}