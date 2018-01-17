package cn.ldm.player.menu;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;

import cn.ldm.player.R;


public class CreateNewPlaylist extends BasePlaylistDialog {

    private long[] mPlaylistList = new long[]{};

    /**
     * @param list 添加到播放列表的曲目列表。
     * @return 这个对话框的一个新实例。
     */
    public static CreateNewPlaylist getInstance(final long[] list) {
        final CreateNewPlaylist frag = new CreateNewPlaylist();
        final Bundle args = new Bundle();
        args.putLongArray("playlist_list", list);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("defaultname", mPlaylist.getText().toString());
    }

    @Override
    public void initObjects(Bundle savedInstanceState) {
        mPlaylistList = getArguments().getLongArray("playlist_list");
        mDefaultName = savedInstanceState != null ? savedInstanceState.getString("defaultname") : makePlaylistName();
        if (mDefaultName == null) {
            getDialog().dismiss();
            return;
        }
        final String promptFormat = getString(R.string.create_playlist_prompt);
        mPrompt = String.format(promptFormat, mDefaultName);
    }

    @Override
    public void onSaveClick() {
//        final String playlistName = mPlaylist.getText().toString();
//        if (playlistName != null && playlistName.length() > 0) {
//            final int playlistId = (int) MusicUtils.getIdForPlaylist(getActivity(),
//                    playlistName);
//            if (playlistId >= 0) {
//                MusicUtils.clearPlaylist(getActivity(), playlistId);
//                MusicUtils.addToPlaylist(getActivity(), mPlaylistList, playlistId);
//            } else {
//                final long newId = MusicUtils.createPlaylist(getActivity(),
//                        Capitalize.capitalize(playlistName));
//                MusicUtils.addToPlaylist(getActivity(), mPlaylistList, newId);
//            }
//            getDialog().dismiss();
//        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onTextChangedListener() {
        //        final String playlistName = mPlaylist.getText().toString();
        //        mSaveButton = mPlaylistDialog.getButton(Dialog.BUTTON_POSITIVE);
        //        if (mSaveButton == null) {
        //            return;
        //        }
        //        if (playlistName.trim().length() == 0) {
        //            mSaveButton.setEnabled(false);
        //        } else {
        //            mSaveButton.setEnabled(true);
        //            if (MusicUtils.getIdForPlaylist(getActivity(), playlistName) >= 0) {
        //                mSaveButton.setText(R.string.overwrite);
        //            } else {
        //                mSaveButton.setText(R.string.save);
        //            }
        //        }
    }

    private String makePlaylistName() {
        //        String template = getString(R.string.new_playlist_name_template);
        //        int num = 1;
        //        Cursor cursor = getActivity().getContentResolver().query(
        //                MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
        //                new String[]{MediaStore.Audio.Playlists.NAME},
        //                MediaStore.Audio.Playlists.NAME + " != ''",
        //                null,
        //                null);
        //        if (cursor == null) {
        //            return null;
        //        }
        //
        //        String displayName;
        //        displayName = String.format(template, num++);
        //        boolean done = false;
        //        while (!done) {
        //            done = true;
        //            cursor.moveToFirst();
        //            while (!cursor.isAfterLast()) {
        //                final String playlistName = cursor.getString(0);
        //                if (playlistName.compareToIgnoreCase(displayName) == 0) {
        //                    displayName = String.format(template, num++);
        //                    done = false;
        //                }
        //                cursor.moveToNext();
        //            }
        //        }
        //        cursor.close();
        //        cursor = null;
        //        return displayName;
        return "DISPLAY_NAME";
    }
}
