package sm.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.liepaiwang.common.utils.UUIDUtils;
import com.sina.user.dao.UserDao;
import com.sina.user.model.User;

/**
 * dao junit测试
 * @author Administrator
 *
 */
public class DaoTest extends BaseTest{

	@Autowired
	public UserDao userDao;
	
	@Test
	public void queryUserByUserid(){
		userDao.selectByPrimaryKey("8fe1dd038ac74b1284c2ccb7778c2b64");
	}
	
	@Test
	public void insertUser(){
		User user = new User();
		user.setUserid(UUIDUtils.randomUUID());
		user.setUsername("lihua");
		user.setPhone("18712016817");
		user.setPassword("123456");
//		userDao.insert(user);//全插入
		userDao.insertSelective(user);//部分插入
		System.out.println("000");
	}
}
