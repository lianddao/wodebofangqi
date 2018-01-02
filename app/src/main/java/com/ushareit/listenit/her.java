package com.ushareit.listenit;

import android.os.Environment;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class her {
    StringBuilder f15294a = new StringBuilder();
    File f15295b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    final /* synthetic */ DragSortListView f15296c;
    private int f15297d = 0;
    private int f15298e = 0;
    private boolean f15299f = false;

    public her(DragSortListView dragSortListView) {
        this.f15296c = dragSortListView;
        if (!this.f15295b.exists()) {
            try {
                this.f15295b.createNewFile();
            } catch (IOException e) {
                exw.m18456d("mobeta", "Could not create dslv_state.txt");
                exw.m18449b("mobeta", e.getMessage());
            }
        }
    }

    public void m23635a() {
        this.f15294a.append("<DSLVStates>\n");
        this.f15298e = 0;
        this.f15299f = true;
    }

    public void m23636b() {
        if (this.f15299f) {
            int i;
            this.f15294a.append("<DSLVState>\n");
            int childCount = this.f15296c.getChildCount();
            int firstVisiblePosition = this.f15296c.getFirstVisiblePosition();
            this.f15294a.append("    <Positions>");
            for (i = 0; i < childCount; i++) {
                this.f15294a.append(firstVisiblePosition + i).append(",");
            }
            this.f15294a.append("</Positions>\n");
            this.f15294a.append("    <Tops>");
            for (i = 0; i < childCount; i++) {
                this.f15294a.append(this.f15296c.getChildAt(i).getTop()).append(",");
            }
            this.f15294a.append("</Tops>\n");
            this.f15294a.append("    <Bottoms>");
            for (i = 0; i < childCount; i++) {
                this.f15294a.append(this.f15296c.getChildAt(i).getBottom()).append(",");
            }
            this.f15294a.append("</Bottoms>\n");
            this.f15294a.append("    <FirstExpPos>").append(this.f15296c.f17456j).append("</FirstExpPos>\n");
            this.f15294a.append("    <FirstExpBlankHeight>").append(this.f15296c.m27035b(this.f15296c.f17456j) - this.f15296c.m27050d(this.f15296c.f17456j)).append("</FirstExpBlankHeight>\n");
            this.f15294a.append("    <SecondExpPos>").append(this.f15296c.f17457k).append("</SecondExpPos>\n");
            this.f15294a.append("    <SecondExpBlankHeight>").append(this.f15296c.m27035b(this.f15296c.f17457k) - this.f15296c.m27050d(this.f15296c.f17457k)).append("</SecondExpBlankHeight>\n");
            this.f15294a.append("    <SrcPos>").append(this.f15296c.f17459m).append("</SrcPos>\n");
            this.f15294a.append("    <SrcHeight>").append(this.f15296c.f17470x + this.f15296c.getDividerHeight()).append("</SrcHeight>\n");
            this.f15294a.append("    <ViewHeight>").append(this.f15296c.getHeight()).append("</ViewHeight>\n");
            this.f15294a.append("    <LastY>").append(this.f15296c.f17439P).append("</LastY>\n");
            this.f15294a.append("    <FloatY>").append(this.f15296c.f17450d).append("</FloatY>\n");
            this.f15294a.append("    <ShuffleEdges>");
            for (i = 0; i < childCount; i++) {
                this.f15294a.append(this.f15296c.m27026a(firstVisiblePosition + i, this.f15296c.getChildAt(i).getTop())).append(",");
            }
            this.f15294a.append("</ShuffleEdges>\n");
            this.f15294a.append("</DSLVState>\n");
            this.f15297d++;
            if (this.f15297d > 1000) {
                m23637c();
                this.f15297d = 0;
            }
        }
    }

    public void m23637c() {
        boolean z = false;
        if (this.f15299f) {
            try {
                if (this.f15298e != 0) {
                    z = true;
                }
                FileWriter fileWriter = new FileWriter(this.f15295b, z);
                fileWriter.write(this.f15294a.toString());
                this.f15294a.delete(0, this.f15294a.length());
                fileWriter.flush();
                fileWriter.close();
                this.f15298e++;
            } catch (IOException e) {
            }
        }
    }

    public void m23638d() {
        if (this.f15299f) {
            this.f15294a.append("</DSLVStates>\n");
            m23637c();
            this.f15299f = false;
        }
    }
}
