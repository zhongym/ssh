
package zhong.webservice.clinet1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zhong.webservice.clinet1 package.
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

    private final static QName _CreateUserResponse_QNAME = new QName("www.zhong.webservice.demo", "createUserResponse");
    private final static QName _GetUserByUserId_QNAME = new QName("www.zhong.webservice.demo", "getUserByUserId");
    private final static QName _CreateUser_QNAME = new QName("www.zhong.webservice.demo", "createUser");
    private final static QName _GetUserByUserIdResponse_QNAME = new QName("www.zhong.webservice.demo", "getUserByUserIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zhong.webservice.clinet1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link GetUserByUserId }
     * 
     */
    public GetUserByUserId createGetUserByUserId() {
        return new GetUserByUserId();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link GetUserByUserIdResponse }
     * 
     */
    public GetUserByUserIdResponse createGetUserByUserIdResponse() {
        return new GetUserByUserIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.zhong.webservice.demo", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.zhong.webservice.demo", name = "getUserByUserId")
    public JAXBElement<GetUserByUserId> createGetUserByUserId(GetUserByUserId value) {
        return new JAXBElement<GetUserByUserId>(_GetUserByUserId_QNAME, GetUserByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.zhong.webservice.demo", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.zhong.webservice.demo", name = "getUserByUserIdResponse")
    public JAXBElement<GetUserByUserIdResponse> createGetUserByUserIdResponse(GetUserByUserIdResponse value) {
        return new JAXBElement<GetUserByUserIdResponse>(_GetUserByUserIdResponse_QNAME, GetUserByUserIdResponse.class, null, value);
    }

}
