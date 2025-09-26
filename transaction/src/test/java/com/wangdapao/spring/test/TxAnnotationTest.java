package com.wangdapao.spring.test;

import com.wangdapao.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务管理的配置：
 * 1.在spring的配置文件中配置事务管理器：<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
 * 2.开启事务注解驱动：<tx:annotation-driven transaction-manager="transactionManager"/>
 * 3.使用@Transactional注解来标识需要事务处理的方法或者类
 *
 * 对于@Transactional注解，默认情况下，只有抛出异常才会回滚事务，但是可以通过设置属性rollbackFor来指定哪些异常会回滚事务
 * 属性：
 * a>只读：设置属性readOnly=true，表示当前方法只读，不进行更新操作
 * b>超时：timeout默认为-1，表示不超时，如果指定了超时时间，则方法执行超过指定时间则回滚事务
 * c>回滚策略：默认情况下，只有运行时，（编译时不会）抛出异常才会回滚事务
 *              rollbackFor/noRollbackFor，因为xxx/不因为xxx 进行回滚操作 参数接受 Class 对象数组，需要直接引用异常类
 *              rollbackForClassName/noRollbackForClassName，因为xxx/不因为xxx进行回滚操作  参数接收字符串数组，填写异常类的全限定类名
 *              rollbackFor: 编译时会检查类是否存在，类型安全
 *              rollbackForClassName: 编译时不检查，运行时才解析类名，可能存在类找不到的风险
 *              rollbackFor: 推荐使用，类型安全，IDE支持好
 *              rollbackForClassName: 适用于需要动态配置或通过配置文件指定回滚异常的场景
 * d>隔离级别：isolation，参数为枚举类型，设置隔离级别，默认情况下，使用数据库默认的隔离级别
 *           隔离级别越高，数据一致性就越好，但是性能越差
 *           四种隔离级别：READ_COMMITTED、READ_UNCOMMITTED、REPEATABLE_READ、SERIALIZABLE
 *           READ_UNCOMMITTED ：读未提交，允许脏读，允许不可重复读，允许幻读
 *           READ_COMMITTED ：读已提交，不允许脏读，允许不可重复读，允许幻读
 *           REPEATABLE_READ ：可重复读，不允许脏读，不允许不可重复读，允许幻读
 *           SERIALIZABLE : 串行化，不允许脏读，不允许不可重复读，不允许幻读
 * e>传播属性：propagation，参数为枚举类型，设置事务的传播属性,
 *           默认为REQUIRED，表示当前方法必须运行在事务中，如果当前没有事务，则创建一个事务，如果当前存在事务，则加入当前事务
 *           REQUIRED_NEW：使用新事务，如果当前存在事务，则暂停当前事务，创建一个新事务，新事务执行当前方法，结束后恢复暂停事务
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:tx-annotation.xml")
public class TxAnnotationTest {

    @Autowired
    private BookController bookController;


    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 2);
    }

    @Test
    public void testCheckout() {
        bookController.checkout(1, new Integer[]{1,2});
    }
}
