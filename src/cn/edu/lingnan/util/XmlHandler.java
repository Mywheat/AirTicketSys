package cn.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//处理器
public class XmlHandler extends DefaultHandler{
	private StringBuffer sb = new StringBuffer();//定义可变字符串
    private HashMap<String,String> hm = new HashMap<String,String>();
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
        //1.清空一个可变字符串
    	sb.delete(0, sb.length());
    }

    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
        // 3.将可变字符串的内容存入某个介质
    	hm.put(qName.toLowerCase(), sb.toString().trim());//元素名    读到的内容
    }

    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        // 2.把读到的ch字符数组中的内容存入可变字符串
    	sb.append(ch,start,length);
    }
    public HashMap<String,String> getHashMap(){
    	return hm;
    }
}
