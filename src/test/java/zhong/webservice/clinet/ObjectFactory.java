
package zhong.webservice.clinet;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zhong.webservice.clinet package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UdpateErpOrderStatsResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpOrderStatsResponse");
    private final static QName _UdpateErpIntegralKB_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpIntegralKB");
    private final static QName _UpdateErpPackageItemResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "updateErpPackageItemResponse");
    private final static QName _UdpateErpOrderStats_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpOrderStats");
    private final static QName _UdpateErpPackageResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpPackageResponse");
    private final static QName _UdpateErpPrice_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpPrice");
    private final static QName _UpdateErpStock_QNAME = new QName("http://docking.service.imall.iloosen.com/", "updateErpStock");
    private final static QName _UdpateErpIntegralKBResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpIntegralKBResponse");
    private final static QName _UdpateErpPriceResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpPriceResponse");
    private final static QName _UpdateErpPackageItem_QNAME = new QName("http://docking.service.imall.iloosen.com/", "updateErpPackageItem");
    private final static QName _BatchUpdateUserTag_QNAME = new QName("http://docking.service.imall.iloosen.com/", "batchUpdateUserTag");
    private final static QName _UpdateErpStockResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "updateErpStockResponse");
    private final static QName _BatchUpdateUserTagResponse_QNAME = new QName("http://docking.service.imall.iloosen.com/", "batchUpdateUserTagResponse");
    private final static QName _UdpateErpPackage_QNAME = new QName("http://docking.service.imall.iloosen.com/", "udpateErpPackage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zhong.webservice.clinet
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UdpateErpPriceResponse }
     * 
     */
    public UdpateErpPriceResponse createUdpateErpPriceResponse() {
        return new UdpateErpPriceResponse();
    }

    /**
     * Create an instance of {@link UdpateErpPackageResponse }
     * 
     */
    public UdpateErpPackageResponse createUdpateErpPackageResponse() {
        return new UdpateErpPackageResponse();
    }

    /**
     * Create an instance of {@link UdpateErpIntegralKBResponse }
     * 
     */
    public UdpateErpIntegralKBResponse createUdpateErpIntegralKBResponse() {
        return new UdpateErpIntegralKBResponse();
    }

    /**
     * Create an instance of {@link UpdateErpStockResponse }
     * 
     */
    public UpdateErpStockResponse createUpdateErpStockResponse() {
        return new UpdateErpStockResponse();
    }

    /**
     * Create an instance of {@link UdpateErpPrice }
     * 
     */
    public UdpateErpPrice createUdpateErpPrice() {
        return new UdpateErpPrice();
    }

    /**
     * Create an instance of {@link UdpateErpIntegralKB }
     * 
     */
    public UdpateErpIntegralKB createUdpateErpIntegralKB() {
        return new UdpateErpIntegralKB();
    }

    /**
     * Create an instance of {@link UpdateErpPackageItemResponse }
     * 
     */
    public UpdateErpPackageItemResponse createUpdateErpPackageItemResponse() {
        return new UpdateErpPackageItemResponse();
    }

    /**
     * Create an instance of {@link UpdateErpPackageItem }
     * 
     */
    public UpdateErpPackageItem createUpdateErpPackageItem() {
        return new UpdateErpPackageItem();
    }

    /**
     * Create an instance of {@link BatchUpdateUserTagResponse }
     * 
     */
    public BatchUpdateUserTagResponse createBatchUpdateUserTagResponse() {
        return new BatchUpdateUserTagResponse();
    }

    /**
     * Create an instance of {@link UdpateErpPackage }
     * 
     */
    public UdpateErpPackage createUdpateErpPackage() {
        return new UdpateErpPackage();
    }

    /**
     * Create an instance of {@link UdpateErpOrderStatsResponse }
     * 
     */
    public UdpateErpOrderStatsResponse createUdpateErpOrderStatsResponse() {
        return new UdpateErpOrderStatsResponse();
    }

    /**
     * Create an instance of {@link BatchUpdateUserTag }
     * 
     */
    public BatchUpdateUserTag createBatchUpdateUserTag() {
        return new BatchUpdateUserTag();
    }

    /**
     * Create an instance of {@link UdpateErpOrderStats }
     * 
     */
    public UdpateErpOrderStats createUdpateErpOrderStats() {
        return new UdpateErpOrderStats();
    }

    /**
     * Create an instance of {@link UpdateErpStock }
     * 
     */
    public UpdateErpStock createUpdateErpStock() {
        return new UpdateErpStock();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpOrderStatsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpOrderStatsResponse")
    public JAXBElement<UdpateErpOrderStatsResponse> createUdpateErpOrderStatsResponse(UdpateErpOrderStatsResponse value) {
        return new JAXBElement<UdpateErpOrderStatsResponse>(_UdpateErpOrderStatsResponse_QNAME, UdpateErpOrderStatsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpIntegralKB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpIntegralKB")
    public JAXBElement<UdpateErpIntegralKB> createUdpateErpIntegralKB(UdpateErpIntegralKB value) {
        return new JAXBElement<UdpateErpIntegralKB>(_UdpateErpIntegralKB_QNAME, UdpateErpIntegralKB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateErpPackageItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "updateErpPackageItemResponse")
    public JAXBElement<UpdateErpPackageItemResponse> createUpdateErpPackageItemResponse(UpdateErpPackageItemResponse value) {
        return new JAXBElement<UpdateErpPackageItemResponse>(_UpdateErpPackageItemResponse_QNAME, UpdateErpPackageItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpOrderStats }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpOrderStats")
    public JAXBElement<UdpateErpOrderStats> createUdpateErpOrderStats(UdpateErpOrderStats value) {
        return new JAXBElement<UdpateErpOrderStats>(_UdpateErpOrderStats_QNAME, UdpateErpOrderStats.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpPackageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpPackageResponse")
    public JAXBElement<UdpateErpPackageResponse> createUdpateErpPackageResponse(UdpateErpPackageResponse value) {
        return new JAXBElement<UdpateErpPackageResponse>(_UdpateErpPackageResponse_QNAME, UdpateErpPackageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpPrice")
    public JAXBElement<UdpateErpPrice> createUdpateErpPrice(UdpateErpPrice value) {
        return new JAXBElement<UdpateErpPrice>(_UdpateErpPrice_QNAME, UdpateErpPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateErpStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "updateErpStock")
    public JAXBElement<UpdateErpStock> createUpdateErpStock(UpdateErpStock value) {
        return new JAXBElement<UpdateErpStock>(_UpdateErpStock_QNAME, UpdateErpStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpIntegralKBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpIntegralKBResponse")
    public JAXBElement<UdpateErpIntegralKBResponse> createUdpateErpIntegralKBResponse(UdpateErpIntegralKBResponse value) {
        return new JAXBElement<UdpateErpIntegralKBResponse>(_UdpateErpIntegralKBResponse_QNAME, UdpateErpIntegralKBResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpPriceResponse")
    public JAXBElement<UdpateErpPriceResponse> createUdpateErpPriceResponse(UdpateErpPriceResponse value) {
        return new JAXBElement<UdpateErpPriceResponse>(_UdpateErpPriceResponse_QNAME, UdpateErpPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateErpPackageItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "updateErpPackageItem")
    public JAXBElement<UpdateErpPackageItem> createUpdateErpPackageItem(UpdateErpPackageItem value) {
        return new JAXBElement<UpdateErpPackageItem>(_UpdateErpPackageItem_QNAME, UpdateErpPackageItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchUpdateUserTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "batchUpdateUserTag")
    public JAXBElement<BatchUpdateUserTag> createBatchUpdateUserTag(BatchUpdateUserTag value) {
        return new JAXBElement<BatchUpdateUserTag>(_BatchUpdateUserTag_QNAME, BatchUpdateUserTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateErpStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "updateErpStockResponse")
    public JAXBElement<UpdateErpStockResponse> createUpdateErpStockResponse(UpdateErpStockResponse value) {
        return new JAXBElement<UpdateErpStockResponse>(_UpdateErpStockResponse_QNAME, UpdateErpStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchUpdateUserTagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "batchUpdateUserTagResponse")
    public JAXBElement<BatchUpdateUserTagResponse> createBatchUpdateUserTagResponse(BatchUpdateUserTagResponse value) {
        return new JAXBElement<BatchUpdateUserTagResponse>(_BatchUpdateUserTagResponse_QNAME, BatchUpdateUserTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UdpateErpPackage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docking.service.imall.iloosen.com/", name = "udpateErpPackage")
    public JAXBElement<UdpateErpPackage> createUdpateErpPackage(UdpateErpPackage value) {
        return new JAXBElement<UdpateErpPackage>(_UdpateErpPackage_QNAME, UdpateErpPackage.class, null, value);
    }

}
