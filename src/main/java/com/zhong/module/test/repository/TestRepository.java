package com.zhong.module.test.repository;

import com.zhong.commons.base.IBaseRepository;
import com.zhong.module.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhong on 2016/10/29.

 JpaRepository的查询功能
 创建查询的顺序
 Spring Data JPA 在为接口创建代理对象时，如果发现同时存在多种上述情况可用，它该优先采用哪种策略呢？
 <jpa:repositories> 提供了 query-lookup-strategy 属性，用以指定查找的顺序。它有如下三个取值：
 1：create-if-not-found：如果方法通过@Query指定了查询语句，则使用该语句实现查询；如果没有，则查找是否定义了符合条件的命名查询，如果找到，则使用该命名查询；如果两者都没有找到，则通过解析方法名字来创建查询。这是 query-lookup-strategy 属性的默认值
 2：create：通过解析方法名字来创建查询。即使有符合的命名查询，或者方法通过 @Query指定的查询语句，都将会被忽略
 3：use-declared-query：如果方法通过@Query指定了查询语句，则使用该语句实现查询；如果没有，则查找是否定义了符合条件的命名查询，如果找到，则使用该命名查询；如果两者都没有找到，则抛出异常

 */
@Repository
public interface TestRepository extends IBaseRepository<Test,Integer> {
    /**
     *
     Spring Data JPA框架在进行方法名解析时，会先把方法名多余的前缀截取掉，比如 find、findBy、read、readBy、get、getBy，然后对剩下部分进行解析。
     假如创建如下的查询：findByUserDepUuid()，框架在解析该方法时，首先剔除 findBy，然后对剩下的属性进行解析，假设查询实体为Doc
     1：先判断 userDepUuid （根据 POJO 规范，首字母变为小写）是否为查询实体的一个属性，如果是，则表示根据该属性进行查询；如果没有该属性，继续第二步；
     2：从右往左截取第一个大写字母开头的字符串此处为Uuid），然后检查剩下的字符串是否为查询实体的一个属性，如果是，则表示根据该属性进行查询；如果没有该属性，则重复第二步，继续从右往左截取；最后假设user为查询实体的一个属性；
     3：接着处理剩下部分（DepUuid），先判断 user 所对应的类型是否有depUuid属性，如果有，则表示该方法最终是根据 “ Doc.user.depUuid” 的取值进行查询；否则继续按照步骤 2 的规则从右往左截取，最终表示根据 “Doc.user.dep.uuid” 的值进行查询。
     4:可能会存在一种特殊情况，比如 Doc包含一个 user 的属性，也有一个 userDep 属性，此时会存在混淆。可以明确在属性之间加上 "_" 以显式表达意图，比如 "findByUser_DepUuid()" 或者 "findByUserDep_uuid()"
     特殊的参数： 还可以直接在方法的参数上加入分页或排序的参数，比如：
     Page<UserModel> findByName(String name, Pageable pageable);
     List<UserModel> findByName(String name, Sort sort);
     */
    List<Test> findByTitle(String title);

    /**
     1：在实体类上使用@NamedQuery，示例如下：
     @NamedQuery(name = "UserModel.findByAge",query = "select o from UserModel o where o.age >= ?1")
     2：在自己实现的DAO的Repository接口里面定义一个同名的方法，示例如下：
     public List<UserModel> findByAge(int age);
     3：然后就可以使用了，Spring会先找是否有同名的NamedQuery，如果有，那么就不会按照接口定义的方法来解析。
     */
    List<Test> findByTitle1(String title);


    /**

     可以在自定义的查询方法上使用@Query来指定该方法要执行的查询语句，比如：
     @Query("select o from UserModel o where o.uuid=?1")
     public List<UserModel> findByUuidOrAge(int uuid);
     注意：
     1：方法的参数个数必须和@Query里面需要的参数个数一致
     2：如果是like，后面的参数需要前面或者后面加“%”，比如下面都对：
     @Query("select o from UserModel o where o.name like ?1%")
     public List<UserModel> findByUuidOrAge(String name);

     @Query("select o from UserModel o where o.name like %?1")
     public List<UserModel> findByUuidOrAge(String name);

     @Query("select o from UserModel o where o.name like %?1%")
     public List<UserModel> findByUuidOrAge(String name);

     当然，这样在传递参数值的时候就可以不加‘%’了，当然加了也不会错

     n还可以使用@Query来指定本地查询，只要设置nativeQuery为true，比如：
     @Query(value="select * from tbl_user where name like %?1" ,nativeQuery=true)
     public List<UserModel> findByUuidOrAge(String name);
     注意：当前版本的本地查询不支持翻页和动态的排序

     使用命名化参数，使用@Param即可，比如：
     @Query(value="select o from UserModel o where o.name like %:nn")
     public List<UserModel> findByUuidOrAge(@Param("nn") String name);
     同样支持更新类的Query语句，添加@Modifying即可，比如：
     @Modifying
     @Query(value="update UserModel o set o.name=:newName where o.name like %:nn")
     public int findByUuidOrAge(@Param("nn") String name,@Param("newName") String newName);
     注意：
     1：方法的返回值应该是int，表示更新语句所影响的行数
     2：在调用的地方必须加事务，没有事务不能正常执行
     */
    @Query("select count(t.testId) from Test t")
    long countById();


}
