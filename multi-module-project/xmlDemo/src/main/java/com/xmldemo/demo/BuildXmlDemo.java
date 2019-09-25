package com.xmldemo.demo;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhujn on 2019/9/16.
 */
public class BuildXmlDemo {
    public static void main(String[] args){
        buildXml("xmlDemo/src/main/resources/books2.xml");
    }
    private static void buildXml(String s) {
        String[][] books={
                {"1001","����","�����˲�"},
                {"1002","����2","�����˲�2"},
                {"1003","����3","�����˲�3"}
        };
        //1.����һ���յ��ĵ�����
       Document doc = DocumentHelper.createDocument();
        //2.������Ԫ��
        Element rootElmt = doc.addElement("booklist");
        for(String[] book:books){
            Element bookElmt = rootElmt.addElement("book");
            //ÿ��������һ��bookԪ��
            Element titleElmt= bookElmt.addElement("title");
            Element authorElmt=bookElmt.addElement("author");
            Element nameElmt=bookElmt.addElement("name");
            titleElmt.setText(book[0]);
            authorElmt.setText(book[1]);
            nameElmt.setText(book[2]);
            //���ڵ��������
            bookElmt.addAttribute("isbn","hot");
        }
        outPutXml(doc,s);
    }

    private static void outPutXml(Document doc, String s) {
        //����һ��java.io���е�FileWriter����ָ��Ŀ���ļ�
        try {
            FileWriter fw = new FileWriter(s);
            OutputFormat format
                    = OutputFormat.createPrettyPrint();
            format.setEncoding("gb2312");
            XMLWriter xmlWriter
                    = new XMLWriter(fw,format);
            //д��xml�ļ�������ϵͳ
            xmlWriter.write(doc);//д���ĵ�����
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
