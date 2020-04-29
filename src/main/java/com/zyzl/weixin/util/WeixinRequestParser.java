package com.zyzl.weixin.util;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeixinRequestParser {

    public static Map<String, String> parse(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();

        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(inputStream);
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    String tagName = event.asStartElement().getName()
                            .toString();
                    if("SendPicsInfo".equals(tagName)) {
                        map.put(tagName, JSONUtil.obj2String(eventSendPicsInfo(reader)));
                    } else if("SendLocationInfo".equals(tagName)) {
                        map.put(tagName, JSONUtil.obj2String(eventSendLocationInfo(reader)));
                    } else if("ScanCodeInfo".equals(tagName)) {
                        map.put(tagName, JSONUtil.obj2String(eventScanCodePush(reader)));
                    } else if("xml".equals(tagName)) {
                    } else {
                        map.put(tagName, reader.getElementText());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    protected static Map<String, Object> eventScanCodePush(XMLEventReader reader) throws XMLStreamException{
        Map<String, Object> scanCodePush = new HashMap<String, Object>();
        while(reader.hasNext()){
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                String tagName = event.asStartElement().getName()
                        .toString();
                scanCodePush.put(tagName, reader.getElementText());
            }
        }
        return scanCodePush;
    }

    protected static Map<String, Object> eventSendLocationInfo(XMLEventReader reader) throws XMLStreamException{
        Map<String, Object> sendLocationInfo = new HashMap<String, Object>();
        while(reader.hasNext()){
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                String tagName = event.asStartElement().getName()
                        .toString();
                sendLocationInfo.put(tagName, reader.getElementText());
            }
        }
        return sendLocationInfo;
    }

    private static Map<String, Object> eventSendPicsInfo(XMLEventReader reader) throws XMLStreamException {
        Map<String, Object> sendPicsInfoMap = new HashMap<String, Object>();
        while (reader.hasNext()){
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                String tagName = event.asStartElement().getName()
                        .toString();
                if("Count".equals(tagName)){
                    sendPicsInfoMap.put(tagName, reader.getElementText());
                }else if("PicList".equals(tagName)){
//                    StringBuilder sb = new StringBuilder();
                    List<Map<String, String>> picList = CollectionUtil.newArrayList();
                    while(reader.hasNext()){
                        XMLEvent event1 = reader.nextEvent();
                        if(event1.isStartElement() && "PicMd5Sum".equals(event1.asStartElement().getName()
                                .toString())){
                            Map<String, String> picMap = new HashMap<String, String>();
                            picMap.put("PicMd5Sum", reader.getElementText());
//                            sb.append(reader.getElementText());
//                            sb.append(",");
                            picList.add(picMap);
                        }else if(event1.isEndElement() && "PicList".equals(event1.asEndElement().getName().toString())){
                            break;
                        }
                    }
//                    sendPicsInfoMap.put(tagName, sb.substring(0, sb.length()));
                    sendPicsInfoMap.put(tagName, picList);
                }
            }
        }

        return sendPicsInfoMap;
    }

}
