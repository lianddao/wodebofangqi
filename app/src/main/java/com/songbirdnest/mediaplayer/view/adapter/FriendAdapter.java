package com.songbirdnest.mediaplayer.view.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.database.AbstractCursor;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AlphabetIndexer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.widgets.AnimationImage;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.util.Logger;
import com.songbirdnest.util.ZeroCursor;
import com.songbirdnest.util.media.BitmapRemovedListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendAdapter extends AbstractSoundboardAdapter implements SectionIndexer {
    protected AsyncTask<Integer, Void, Void> aClearTask;
    private Map<String, Boolean> downloadStarted = new HashMap();
    private FriendRetriever friendRetriever;
    private final Friend gettingNames;
    private HashMap<String, Bitmap> mCacheMap;
    protected List<Friend> mFriendList;
    private SectionIndexer mIndexer;
    private LayoutInflater mInflator;
    private Resources mResources;
    private boolean scrolling = false;
    private boolean serverError = false;

    class C04261 implements OnScrollListener {
        int currentScrollState = -1;
        boolean scrollStateChanged = false;

        C04261() {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            boolean z = true;
            if (this.currentScrollState != scrollState) {
                this.scrollStateChanged = true;
            }
            this.currentScrollState = scrollState;
            FriendAdapter friendAdapter = FriendAdapter.this;
            if (scrollState == 0) {
                z = false;
            }
            friendAdapter.scrolling = z;
            if (scrollState == 0 && this.scrollStateChanged) {
                this.scrollStateChanged = false;
                FriendAdapter.this.notifyDataSetChanged();
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (this.scrollStateChanged) {
                this.scrollStateChanged = false;
                FriendAdapter.this.notifyDataSetChanged();
            }
        }
    }

    class C04272 extends AsyncTask<Integer, Void, Void> {
        C04272() {
        }

        protected Void doInBackground(Integer... params) {
            Integer aInteger = params[0];
            ArrayList<Object[]> aDiffList = new ArrayList();
            for (int i = 0; i < FriendAdapter.this.mFriendList.size(); i++) {
                if (FriendAdapter.this.mCacheMap.containsKey(((Friend) FriendAdapter.this.mFriendList.get(i)).getFacebookId())) {
                    aDiffList.add(new Object[]{Integer.valueOf(i - aInteger.intValue()), ((Friend) FriendAdapter.this.mFriendList.get(i)).getFacebookId()});
                }
            }
            Collections.sort(aDiffList, new ListCompare());
            while (FriendAdapter.this.mCacheMap.size() > 25) {
                String aDel = ((Object[]) aDiffList.get(0))[1];
                aDiffList.remove(0);
                FriendAdapter.this.mCacheMap.remove(aDel);
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            FriendAdapter.this.aClearTask = null;
        }
    }

    class C04283 extends AbstractCursor {
        C04283() {
        }

        public boolean isNull(int column) {
            return false;
        }

        public String getString(int column) {
            if (this.mPos == 0) {
                return "A";
            }
            this.mPos--;
            return ((Friend) FriendAdapter.this.mFriendList.get(this.mPos)).getFullName();
        }

        public short getShort(int column) {
            return (short) 0;
        }

        public long getLong(int column) {
            return 0;
        }

        public int getInt(int column) {
            return 0;
        }

        public float getFloat(int column) {
            return 0.0f;
        }

        public double getDouble(int column) {
            return 0.0d;
        }

        public int getCount() {
            return FriendAdapter.this.mFriendList.size() + 1;
        }

        public String[] getColumnNames() {
            return null;
        }
    }

    class BitmapRemover implements BitmapRemovedListener<String> {
        BitmapRemover() {
        }

        public void bitmapRemoved(String id, Bitmap bitmap) {
            FriendAdapter.this.notifyDataSetChanged();
        }
    }

    public static class ViewWrapper {
        public ImageView mImage;
        public TextView mText;

        public ViewWrapper(View pView) {
            this.mImage = (ImageView) pView.findViewById(C0116R.id.face_list_item_image);
            this.mText = (TextView) pView.findViewById(C0116R.id.face_list_item_text);
        }
    }

    public FriendAdapter(ListView mList, Activity activity, FriendRetriever pFriendRetriever) {
        this.mInflator = activity.getLayoutInflater();
        this.mResources = activity.getResources();
        this.friendRetriever = pFriendRetriever;
        this.gettingNames = new Friend();
        this.gettingNames.setFullName(this.mResources.getString(C0116R.string.getting_friends));
        this.mCacheMap = new HashMap();
        mList.setOnScrollListener(new C04261());
    }

    public void setServerError(boolean serverError) {
        this.serverError = serverError;
        notifyDataSetChanged();
    }

    public void setFriends(List<Friend> mFriendList) {
        this.mFriendList = mFriendList;
        notifyDataSetChanged();
    }

    public void setFriendImage(String id, Bitmap bitmap) {
        if (bitmap == null) {
            Logger.error((Object) this, "setFriendImage: Got an empty bitmap for id " + id + " resetting download");
            this.downloadStarted.remove(id);
            return;
        }
        this.mCacheMap.put(id, bitmap);
        notifyDataSetChanged();
    }

    void clearCache(int pPosition) {
        if (this.aClearTask == null && this.mCacheMap.size() > 50) {
            this.aClearTask = new C04272().execute(new Integer[]{Integer.valueOf(pPosition)});
        }
    }

    public void refreshDownload() {
        this.downloadStarted.clear();
    }

    public int getCount() {
        if (this.serverError || (this.mFriendList != null && this.mFriendList.size() == 0)) {
            return 0;
        }
        if (this.mFriendList == null) {
            return 1;
        }
        return this.mFriendList.size();
    }

    public Object getItem(int position) {
        if (this.mFriendList == null || this.mFriendList.size() == 0) {
            return this.gettingNames;
        }
        return this.mFriendList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewWrapper aWrapper;
        if (convertView == null) {
            convertView = this.mInflator.inflate(C0116R.layout.face_item, parent, false);
            aWrapper = new ViewWrapper(convertView);
            LayoutParams layoutParams = aWrapper.mImage.getLayoutParams();
            layoutParams.width = 60;
            layoutParams.height = 60;
            convertView.setTag(aWrapper);
        } else {
            aWrapper = (ViewWrapper) convertView.getTag();
        }
        if (getCount() == 1 && position == 0 && (this.mFriendList == null || this.mFriendList.size() == 0)) {
            AnimationDrawable aAnimation = (AnimationDrawable) this.mResources.getDrawable(C0116R.drawable.spinner);
            aWrapper.mImage.setImageDrawable(aAnimation);
            aWrapper.mImage.setBackgroundDrawable(null);
            aWrapper.mText.setText(C0116R.string.getting_friends);
            ((AnimationImage) aWrapper.mImage).setAnimation(aAnimation);
        } else {
            if (position == 0 && aWrapper.mImage.getBackground() == null) {
                aWrapper.mImage.setBackgroundResource(C0116R.color.album_art_border);
            }
            Friend aFriend = (Friend) getItem(position);
            aWrapper.mText.setText(aFriend.getFullName());
            aWrapper.mImage.setTag(Integer.valueOf(position));
            String aID = aFriend.getFacebookId();
            if (aID == null || aID.length() == 0) {
                Logger.error((Object) this, "Facebook ID is empty");
            } else if (this.scrolling && this.mCacheMap.get(aID) == null) {
                aWrapper.mImage.setImageResource(C0116R.drawable.generic_user_small);
            } else {
                if (this.mCacheMap.get(aID) == null) {
                    Bitmap facebookImage = this.friendRetriever.getFacebookFileImage(aFriend);
                    if (facebookImage != null) {
                        this.mCacheMap.put(aID, facebookImage);
                        aWrapper.mImage.setImageBitmap(facebookImage);
                    } else if (this.downloadStarted.get(aID) == null) {
                        this.downloadStarted.put(aID, Boolean.valueOf(true));
                        this.friendRetriever.downloadFacebookImage(aFriend);
                        aWrapper.mImage.setImageResource(C0116R.drawable.generic_user_small);
                    } else {
                        aWrapper.mImage.setImageResource(C0116R.drawable.generic_user_small);
                    }
                } else {
                    aWrapper.mImage.setImageBitmap((Bitmap) this.mCacheMap.get(aID));
                }
                clearCache(position);
            }
        }
        return convertView;
    }

    public int getPositionForSection(int section) {
        return getIndexer().getPositionForSection(section);
    }

    public int getSectionForPosition(int position) {
        return getIndexer().getSectionForPosition(position);
    }

    public Object[] getSections() {
        return getIndexer().getSections();
    }

    public SectionIndexer getIndexer() {
        if (this.mIndexer != null) {
            return this.mIndexer;
        }
        if (getCount() == 0) {
            this.mIndexer = new AlphabetIndexer(new ZeroCursor(new String[0]), 0, "");
            return this.mIndexer;
        }
        this.mIndexer = new AlphabetIndexer(new C04283(), 0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        return this.mIndexer;
    }
}
