package com.miui.player.plugin.onlinemusic2;

import com.xiaomi.music.online.model.MetaList;
import java.util.List;

public class SearchSuggestion extends MetaList<String> {
    private static final long serialVersionUID = 1;
    public final String mKeywords;

    public SearchSuggestion(String keywords, List<String> suggestions) {
        super(suggestions);
        this.mKeywords = keywords;
    }
}
