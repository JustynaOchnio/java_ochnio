package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.java_ochnio.addressbook.model.GroupData;

import java.util.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group= new GroupData("test2", null, null);
        app.group().create(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
