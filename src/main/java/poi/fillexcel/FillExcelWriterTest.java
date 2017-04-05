package poi.fillexcel;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lxd
 * Date: 11-5-5
 * Time: 下午4:58
 * To change this template use File | Settings | File Templates.
 */
@Ignore("手动测试")
public class FillExcelWriterTest {
	private static Logger log = LoggerFactory.getLogger(FillExcelWriterTest.class);

	public static void main(String[] args) {
		log.info("afdsafddsafsafsa");
		System.out.println("aaaaaaaaaaaaaaaaa");
	}

	@Test
	public void testString(){
		String setStr = "set123213";
        String set1 = setStr.substring(setStr.indexOf("set")+"set".length());
        System.out.println(set1);
//        Long set = Long.valueOf(setStr.substring(setStr.indexOf("set")));
    }

    @Test
    public void testExcelWriter() throws IOException {
    	Order order = new Order();

    	OrderItem item1 = new OrderItem();
    	item1.setIntegral(30);
    	item1.setNum(2);
    	item1.setProductNm("商品B");
    	item1.setSpecNm("红色");
    	item1.setStockNo("AFDSE001");
    	item1.setUnitPrice(314.15);
    	order.getOrderItems().add(item1);

    	OrderItem item2 = new OrderItem();
    	item2.setIntegral(50);
    	item2.setNum(3);
    	item2.setProductNm("商品W");
    	item2.setSpecNm("");
    	item2.setStockNo("FDWEE345");
    	item2.setUnitPrice(32.15);
    	order.getOrderItems().add(item2);

    	FillExcelWriter fill = new FillExcelWriter("E:\\ssh\\src\\main\\temp\\iMallOrderExport.xls");
    	fill.fillToFile(order, "E:\\ssh\\src\\main\\out\\out1.xls");
    }
    
    public static class OrderItem{
    	private String productNm;
    	private String stockNo;
    	private String specNm;
    	private Double unitPrice;
    	private Integer num;
    	private Integer integral;
    	private String totalPrice;
		public String getProductNm() {
			return productNm;
		}
		public void setProductNm(String productNm) {
			this.productNm = productNm;
		}
		public String getStockNo() {
			return stockNo;
		}
		public void setStockNo(String stockNo) {
			this.stockNo = stockNo;
		}
		public String getSpecNm() {
			return specNm;
		}
		public void setSpecNm(String specNm) {
			this.specNm = specNm;
		}
		public Double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(Double unitPrice) {
			this.unitPrice = unitPrice;
		}
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
		public Integer getIntegral() {
			return integral;
		}
		public void setIntegral(Integer integral) {
			this.integral = integral;
		}
		public String getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(String totalPrice) {
			this.totalPrice = totalPrice;
		}
    }
    
    public static class Order{
		private String orderNum = "DFANE00201103030032";
		private Date createDate = new Date();
		private String userName = "用户x";
		private String loginId = "usera";
		private String userEmail = "admin@iloosen.com";
		private String userMobile = "13800138000";
		private String userTel = "020-342432342";
		private List<OrderItem> orderItems = new ArrayList<OrderItem>();
		public String getOrderNum() {
			return orderNum;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public String getUserName() {
			return userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public String getUserMobile() {
			return userMobile;
		}
		public String getUserTel() {
			return userTel;
		}
		public String getCreateDateStr(){
			return UtilDateTime.convertDateToString(createDate);
		}
		public String getLoginId() {
			return loginId;
		}
		public List<OrderItem> getOrderItems() {
			return orderItems;
		}
		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
	}
	
}
