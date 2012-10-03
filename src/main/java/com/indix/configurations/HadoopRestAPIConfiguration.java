package com.indix.configurations;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HadoopRestAPIConfiguration extends Configuration {

    @NotEmpty @JsonProperty
    private String hadoopHome = "/home/user5/hadoop/";

    public String getHadoopHome() {
        return hadoopHome;
    }
}
