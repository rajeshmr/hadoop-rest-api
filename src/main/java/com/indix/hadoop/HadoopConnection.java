package com.indix.hadoop;

import com.indix.configurations.HadoopRestAPIConfiguration;

public class HadoopConnection {

    private String hadoopHome;

    public HadoopConnection(HadoopRestAPIConfiguration hadoopRestAPIConfiguration) {
        this.hadoopHome = hadoopRestAPIConfiguration.getHadoopHome();
    }

    public String getHadoopHome() {
        return hadoopHome;
    }
}
