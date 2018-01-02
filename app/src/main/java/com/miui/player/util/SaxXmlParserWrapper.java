package com.miui.player.util;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.DOMException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public final class SaxXmlParserWrapper {

    public static final class ConfigParserException extends SAXException {
        private static final long serialVersionUID = -8593607220242308209L;

        public ConfigParserException(String detailMessage) {
            super(detailMessage);
        }

        public ConfigParserException(String detailMessage, Exception e) {
            super(detailMessage + " 详细错误: " + e.toString());
        }
    }

    public static void parse(InputStream inputStream, DefaultHandler saxHandler) throws ConfigParserException {
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream");
        }
        parse(new InputSource(inputStream), saxHandler);
    }

    public static void parse(InputSource inputSource, DefaultHandler saxHandler) throws ConfigParserException {
        if (inputSource == null) {
            throw new IllegalArgumentException("inputStream");
        } else if (saxHandler == null) {
            throw new IllegalArgumentException("saxHandler");
        } else {
            try {
                XMLReader xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                xmlreader.setContentHandler(saxHandler);
                xmlreader.parse(inputSource);
            } catch (IOException e) {
                throw new ConfigParserException("无法解析该XML文档.", e);
            } catch (SAXException e2) {
                throw new ConfigParserException("无法解析该XML文档.", e2);
            } catch (ParserConfigurationException e3) {
                throw new ConfigParserException("无法解析该XML文档.", e3);
            } catch (DOMException e4) {
                throw new ConfigParserException("无法解析该XML文档.", e4);
            }
        }
    }
}
