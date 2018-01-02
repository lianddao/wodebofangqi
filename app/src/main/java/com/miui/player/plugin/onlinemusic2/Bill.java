package com.miui.player.plugin.onlinemusic2;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {
    private static final long serialVersionUID = 1;
    public AudioList mAudioList;
    public BillDetail mBillDetail;
    public final BillOutline mOutline;

    public static class BillDetail implements Serializable {
        private static final long serialVersionUID = 1;
        public final String mNo;
        public final String mType;
        public final Date mUpdateDate;

        public BillDetail(String type, String no, Date updateDate) {
            this.mType = type;
            this.mNo = no;
            this.mUpdateDate = updateDate;
        }
    }

    public static class BillOutline implements Serializable {
        private static final long serialVersionUID = 1;
        public final String mCategory;
        public final String mId;
        public final String mName;
        public final int mNum;

        public BillOutline(String id, String name, String category, int num) {
            this.mId = id;
            this.mName = name;
            this.mCategory = category;
            this.mNum = num;
        }
    }

    public Bill(BillOutline outline) {
        this.mOutline = outline;
    }
}
