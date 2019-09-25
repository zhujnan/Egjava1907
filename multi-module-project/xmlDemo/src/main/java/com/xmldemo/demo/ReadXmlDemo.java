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
        //1������
        SAXReader reader = new SAXReader();
        //2.ָ��xml�ļ�
        File file = new File("xmlDemo/src/main/resources/book1.xml");
        //3����ʼ�������������νṹ������
        try {
            Document doc = reader.read(file);
            //4.��ʼ�����������νṹ������
            Element rootelement
                    = doc.getRootElement();
            //��ø�Ԫ�أ��鼮�б�
            List list = rootelement.elements("����С˵");
            //�����������С˵��Ԫ�ؼ���
            List list1=rootelement.elements("������鼮");
            paseNovel(list);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    private static void paseNovel(List list) {
        Iterator it = list.iterator();
        while(it.hasNext()){
            //����С˵��Ԫ��
            Element novelElmt = (Element)it.next();
            System.out.println("����"+novelElmt.elementText("����"));
            System.out.println("�۸�"+novelElmt.elementText("�۸�"));
            System.out.println("���"+novelElmt.elementText("���"));
            System.out.println("----��ȡ�ڵ�����---------");
            List attrList = novelElmt.attributes();
            Iterator attrIt = attrList.iterator();
            while(attrIt.hasNext()){
                Attribute attr=(Attribute)attrIt.next();
                System.out.println(attr.getName()+"="+attr.getValue());
            }
        }
    }
}
