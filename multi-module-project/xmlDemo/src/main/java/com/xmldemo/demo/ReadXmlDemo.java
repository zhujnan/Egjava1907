package com.xmldemo.demo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.text.html.HTMLDocument;
import  java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhujn on 2019/9/16.
 */
public class ReadXmlDemo {
    public static void main(String[] args){
        readBook();
    }

    private static void readBook() {
        //1解析器
        SAXReader reader = new SAXReader();
        //2.指定xml文件
        File file = new File("xmlDemo/src/main/resources/book1.xml");
        //3，开始解析，构建树形结构并返回
        try {
            Document doc = reader.read(file);
            //4.开始解析构建树形结构并返回
            Element rootelement
                    = doc.getRootElement();
            //获得根元素：书籍列表
            List list = rootelement.elements("武侠小说");
            //获得所有武侠小说的元素集合
            List list1=rootelement.elements("计算机书籍");
            paseNovel(list);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    private static void paseNovel(List list) {
        Iterator it = list.iterator();
        while(it.hasNext()){
            //武侠小说的元素
            Element novelElmt = (Element)it.next();
            System.out.println("书名"+novelElmt.elementText("书名"));
            System.out.println("价格"+novelElmt.elementText("价格"));
            System.out.println("简介"+novelElmt.elementText("简介"));
            System.out.println("----获取节点属性---------");
            List attrList = novelElmt.attributes();
            Iterator attrIt = attrList.iterator();
            while(attrIt.hasNext()){
                Attribute attr=(Attribute)attrIt.next();
                System.out.println(attr.getName()+"="+attr.getValue());
            }
        }
    }
}
