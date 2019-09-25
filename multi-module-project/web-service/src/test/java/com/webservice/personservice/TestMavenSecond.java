package com.webservice.personservice;

import com.webservice.personserviceimpl.PersonServiceImpl;
import org.junit.Test;

/**
 * Created by zhujn on 2019/9/10.
 */
public class TestMavenSecond {
@Test
    public void testSayHello() {
    IPersonService mavenTest
            = new PersonServiceImpl();
    System.out.println(mavenTest.findPerson(2).toString());
}

}
