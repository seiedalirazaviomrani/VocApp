package com.razavy.vocapp;

public class Session {
    private int mImgResourceId;
    private String mSessionName;
    private String mSessionDescription;

    public Session(int imgResourceId, String sessionName, String sessionDescription) {
        this.mImgResourceId = imgResourceId;
        this.mSessionName = sessionName;
        this.mSessionDescription = sessionDescription;
    }

    public int getImgResourceId() {
        return mImgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.mImgResourceId = imgResourceId;
    }

    public String getSessionName() {
        return mSessionName;
    }

    public void setSessionName(String sessionName) {
        mSessionName = sessionName;
    }

    public String getSessionDescription() {
        return mSessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.mSessionDescription = sessionDescription;
    }
}
