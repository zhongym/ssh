
package zhong.webservice.clinet;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ICoofansWebService", targetNamespace = "http://docking.service.imall.iloosen.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICoofansWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "udpateErpOrderStats", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpOrderStats")
    @ResponseWrapper(localName = "udpateErpOrderStatsResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpOrderStatsResponse")
    public String udpateErpOrderStats(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "udpateErpPackage", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpPackage")
    @ResponseWrapper(localName = "udpateErpPackageResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpPackageResponse")
    public String udpateErpPackage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "udpateErpPrice", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpPrice")
    @ResponseWrapper(localName = "udpateErpPriceResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpPriceResponse")
    public String udpateErpPrice(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateErpStock", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UpdateErpStock")
    @ResponseWrapper(localName = "updateErpStockResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UpdateErpStockResponse")
    public String updateErpStock(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "udpateErpIntegralKB", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpIntegralKB")
    @ResponseWrapper(localName = "udpateErpIntegralKBResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UdpateErpIntegralKBResponse")
    public String udpateErpIntegralKB(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateErpPackageItem", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UpdateErpPackageItem")
    @ResponseWrapper(localName = "updateErpPackageItemResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.UpdateErpPackageItemResponse")
    public String updateErpPackageItem(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param tags
     * @param type
     * @param userMobiles
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "batchUpdateUserTag", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.BatchUpdateUserTag")
    @ResponseWrapper(localName = "batchUpdateUserTagResponse", targetNamespace = "http://docking.service.imall.iloosen.com/", className = "zhong.webservice.clinet.BatchUpdateUserTagResponse")
    public String batchUpdateUserTag(
        @WebParam(name = "userMobiles", targetNamespace = "")
        List<String> userMobiles,
        @WebParam(name = "tags", targetNamespace = "")
        String tags,
        @WebParam(name = "type", targetNamespace = "")
        String type);

}
