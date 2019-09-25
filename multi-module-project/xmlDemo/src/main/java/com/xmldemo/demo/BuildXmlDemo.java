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
                {"1001","武侠","天龙八部"},
                {"1002","武侠2","天龙八部2"},
                {"1003","武侠3","天龙八部3"}
        };
        //1.创建一个空的文档对象
       Document doc = DocumentHelper.createDocument();
        //2.创建根元素
        Element rootElmt = doc.addElement("booklist");
        for(String[] book:books){
            Element bookElmt = rootElmt.addElement("book");
            //每本书增加一个book元素
            Element titleElmt= bookElmt.addElement("title");
            Element authorElmt=bookElmt.addElement("author");
            Element nameElmt=bookElmt.addElement("name");
            titleElmt.setText(book[0]);
            authorElmt.setText(book[1]);
            nameElmt.setText(book[2]);
            //给节点添加属性
            bookElmt.addAttribute("isbn","hot");
        }
        outPutXml(doc,s);
    }

    private static void outPutXml(Document doc, String s) {
        //创建一个java.io包中的FileWriter对象，指定目标文件
        try {
            FileWriter fw = new FileWriter(s);
            OutputFormat format
                    = OutputFormat.createPrettyPrint();
            format.setEncoding("gb2312");
            XMLWriter xmlWriter
                    = new XMLWriter(fw,format);
            //写出xml文件到操作系统
            xmlWriter.write(doc);//写出文档对象
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
