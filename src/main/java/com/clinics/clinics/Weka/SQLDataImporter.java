package com.clinics.clinics.Weka;

import weka.core.Instances;
import weka.experiment.InstanceQuery;
import java.io.File;

public class SQLDataImporter {
    static File propsFile = new File("F:\\Programowanie\\clinics\\src\\main\\java\\com\\clinics\\clinics\\Weka\\DatabaseUtils.props");

    public static Instances getDataSetFromPostgreSQL(String userName, String password, String queryText, int limit) throws Exception {
        InstanceQuery query = new InstanceQuery();
        query.setUsername(userName);
        query.setPassword(password);
        
        query.setCustomPropsFile(propsFile);

        if (limit>0) query.setQuery(queryText + " limit "+ limit + ";");
        else query.setQuery(queryText + ";");

        Instances data = query.retrieveInstances();

        return data;
    }
}