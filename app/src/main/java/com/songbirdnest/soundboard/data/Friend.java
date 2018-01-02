package com.songbirdnest.soundboard.data;

public class Friend {
    protected String facebookId;
    protected String fullName;
    protected String soundBoardId;

    public String getFacebookId() {
        return this.facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSoundBoardId() {
        return this.soundBoardId;
    }

    public void setSoundBoardId(String soundBoardId) {
        this.soundBoardId = soundBoardId;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Friend friend = (Friend) o;
        if (this.facebookId != null) {
            if (this.facebookId.equals(friend.facebookId)) {
                return true;
            }
        } else if (friend.facebookId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.facebookId != null ? this.facebookId.hashCode() : 0;
    }
}
