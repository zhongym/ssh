package poi.listexcel;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: lxd
 * Date: 11-5-5
 * Time: 下午4:58
 * To change this template use File | Settings | File Templates.
 */
//@Ignore("手动测试")
public class ListExcelWriterTest {
    @Test
    public void testExcelWriter() throws IOException {
        ListExcelWriter writer = new ListExcelWriter("E:\\ssh\\src\\main\\testExport.xls");

        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("loginId", "loginId" + i);
            data.put("name", "name" + i);
            data.put("email", "email" + i);
            data.put("mobi", "mobi" + i);
            data.put("tel", "tel" + i);
            data.put("addr", "addr" + i);
            data.put("money", i % 21);
            dataList.add(data);
        }
        writer.fillToFile(dataList, "out.xls");
    }
}
