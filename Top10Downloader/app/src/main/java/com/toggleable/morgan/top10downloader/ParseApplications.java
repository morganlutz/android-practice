package com.toggleable.morgan.top10downloader;

import java.util.ArrayList;

/**
 * Created by morgaface on 10/22/15.
 */
public class ParseApplications {

    private String xmlData;
    private ArrayList<Application> applications;

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public ParseApplications(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<Application>();
    }
}
