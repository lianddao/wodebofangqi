package com.songbirdnest.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.songbirdnest.mediaplayer.service.FlickrParms;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class PullImageList extends AsyncTask<Void, Void, PullImageListResult> {
    private static final String FLICKR_API_HOME = "http://api.flickr.com/services/rest/?method=flickr.photos.search&media=photos&per_page=50&sort=relevance";
    private static final String TEXT_PARAM = "&text=";
    String mApiKey;
    HashMap<Integer, Bitmap> mBitmapHash;
    String mCurrentArtist;
    ArrayList<FlickrParms> mItemList;

    class C04701 implements ContentHandler {
        C04701() {
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
        }

        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            int x;
            String xmlInterpet = "";
            for (x = 0; x < atts.getLength(); x++) {
                xmlInterpet = xmlInterpet + atts.getLocalName(x) + " " + atts.getValue(x) + " ";
            }
            if (localName.equals("photo")) {
                FlickrParms firstParam = new FlickrParms();
                for (x = 0; x < atts.getLength(); x++) {
                    if (atts.getLocalName(x).equals("farm")) {
                        firstParam.setFarmID(atts.getValue(x));
                    } else if (atts.getLocalName(x).equals("secret")) {
                        firstParam.setSecret(atts.getValue(x));
                    } else if (atts.getLocalName(x).equals("id")) {
                        firstParam.setPhotoID(atts.getValue(x));
                    } else if (atts.getLocalName(x).equals("server")) {
                        firstParam.setServerID(atts.getValue(x));
                    }
                    xmlInterpet = xmlInterpet + atts.getLocalName(x) + " " + atts.getValue(x) + " ";
                }
                PullImageList.this.mItemList.add(firstParam);
            }
        }

        public void startDocument() throws SAXException {
        }

        public void skippedEntity(String name) throws SAXException {
        }

        public void setDocumentLocator(Locator locator) {
        }

        public void processingInstruction(String target, String data) throws SAXException {
        }

        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        }

        public void endPrefixMapping(String prefix) throws SAXException {
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
        }

        public void endDocument() throws SAXException {
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
        }
    }

    public static class PullImageListResult {
        Exception mException = null;
        public boolean mIsError = false;
        boolean mIsIOError = false;
    }

    public PullImageList(HashMap<Integer, Bitmap> pBitmapHash, ArrayList<FlickrParms> pItemList, String pArtist, String pApiKey) {
        this.mBitmapHash = pBitmapHash;
        this.mItemList = pItemList;
        this.mCurrentArtist = pArtist;
        this.mApiKey = pApiKey;
        Log.i("Tracker", "Target Artist: " + pArtist);
    }

    protected PullImageListResult doInBackground(Void... params) {
        this.mBitmapHash.clear();
        this.mItemList.clear();
        if (this.mCurrentArtist == null) {
            return null;
        }
        ContentHandler contentHandler = new C04701();
        PullImageListResult result = new PullImageListResult();
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            reader.setContentHandler(contentHandler);
            reader.parse(new InputSource(new URL(FLICKR_API_HOME + ("&api_key=" + this.mApiKey) + TEXT_PARAM + URLEncoder.encode(this.mCurrentArtist) + URLEncoder.encode(" AND ( music OR concert OR band )")).openStream()));
            return result;
        } catch (IOException ioException) {
            this.mItemList.clear();
            this.mBitmapHash.clear();
            result.mIsError = true;
            result.mIsIOError = true;
            result.mException = ioException;
            return result;
        } catch (Exception e) {
            this.mItemList.clear();
            this.mBitmapHash.clear();
            result.mIsError = true;
            result.mException = e;
            return result;
        }
    }
}
