package com.toggleable.morgan.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
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

    public boolean process() {
        boolean status = true;
        Application currentRecord;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch(eventType) {
                    case XmlPullParser.START_TAG:
                        Log.d("ParseApplications", "Starting tag for " + tagName);
                        if(tagName.equalsIgnoreCase("entry")) {
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        Log.d("ParseApplications", "Ending tag for " + tagName);
                        break;
                    default:
                        //Nothing else to do.
                }
                eventType = xpp.next();
            }


        } catch(Exception e) {
            status = false;
            e.printStackTrace();
        }
        return true;

    }
}
