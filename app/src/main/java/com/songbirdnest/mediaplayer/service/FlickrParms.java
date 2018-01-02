package com.songbirdnest.mediaplayer.service;

public class FlickrParms {
    String farmID;
    String photoID;
    String secret;
    String serverID;
    String size;

    public FlickrParms(String inFarm, String inServer, String inPhoto, String inSecret, String inSize) {
        this.farmID = inFarm;
        this.serverID = inServer;
        this.photoID = inPhoto;
        this.secret = inSecret;
        this.size = "m";
    }

    public void setFarmID(String farmID) {
        this.farmID = farmID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhotoURL() {
        if (this.farmID != null && this.serverID != null && this.photoID != null && this.secret != null && this.size != null) {
            return "http://farm" + this.farmID + ".static.flickr.com/" + this.serverID + "/" + this.photoID + "_" + this.secret + "_" + this.size + ".jpg";
        }
        if (this.farmID == null || this.serverID == null || this.photoID == null || this.secret == null) {
            return "Empty";
        }
        return "http://farm" + this.farmID + ".static.flickr.com/" + this.serverID + "/" + this.photoID + "_" + this.secret + ".jpg";
    }
}
