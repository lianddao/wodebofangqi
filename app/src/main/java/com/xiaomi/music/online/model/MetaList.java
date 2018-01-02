package com.xiaomi.music.online.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetaList<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<T> mContent = new ArrayList();
    private PageHelper mPageHelper = new PageHelper();

    private class PageHelper implements Serializable {
        private static final long serialVersionUID = 1;
        private final List<Integer> mSumInPage = new ArrayList();

        PageHelper() {
            this.mSumInPage.add(0, Integer.valueOf(0));
            this.mSumInPage.add(1, Integer.valueOf(MetaList.this.size()));
        }

        private void updateSum(int pageNo, int size) {
            int i;
            if (pageNo < this.mSumInPage.size()) {
                int delta = size - (((Integer) this.mSumInPage.get(pageNo)).intValue() - ((Integer) this.mSumInPage.get(pageNo - 1)).intValue());
                for (i = pageNo; i < this.mSumInPage.size(); i++) {
                    this.mSumInPage.set(i, Integer.valueOf(((Integer) this.mSumInPage.get(i)).intValue() + delta));
                }
                return;
            }
            for (i = this.mSumInPage.size(); i < pageNo; i++) {
                this.mSumInPage.add(i, this.mSumInPage.get(this.mSumInPage.size() - 1));
            }
            this.mSumInPage.add(pageNo, Integer.valueOf(((Integer) this.mSumInPage.get(pageNo - 1)).intValue() + size));
        }

        boolean isPageExist(int pageNo) {
            return pageNo < this.mSumInPage.size();
        }

        void add(List<T> list, int pageNo) {
            if (list != null) {
                updateSum(pageNo, list.size());
                MetaList.this.mContent.addAll(((Integer) this.mSumInPage.get(pageNo - 1)).intValue(), list);
            }
        }

        void remove(int pageNo) {
            int start = ((Integer) this.mSumInPage.get(pageNo - 1)).intValue();
            int end = ((Integer) this.mSumInPage.get(pageNo)).intValue();
            for (int i = end - 1; i >= start; i--) {
                MetaList.this.mContent.remove(i);
            }
            updateSum(pageNo, start - end);
        }

        void update(List<T> list, int pageNo) {
            if (list != null) {
                if (isPageExist(pageNo)) {
                    remove(pageNo);
                }
                add(list, pageNo);
            }
        }
    }

    public MetaList(List<T> content) {
        this.mPageHelper.update(content, 1);
    }

    public List<T> getContent() {
        return Collections.unmodifiableList(this.mContent);
    }

    public boolean isValid() {
        return this.mContent != null;
    }

    public int size() {
        return this.mContent != null ? this.mContent.size() : 0;
    }

    public T get(int position) {
        return this.mContent.get(position);
    }

    public void update(List<T> list, int pageNo) {
        this.mPageHelper.update(list, pageNo);
    }
}
