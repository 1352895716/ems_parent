package com.ems.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.ems.pojo.StaffExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ems.mapper.StaffMapper;
import com.ems.pojo.Staff;

import com.ems.service.StaffService;

import entity.PageResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Staff> findAll() {
		return staffMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Staff> page=   (Page<Staff>) staffMapper.selectByExample(null);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Staff staff) {
		/*//
		staff.setSex(false);
		staff.setPassword("123456");
		//设置入职日期
		staff.setCreateTime(new Date());
		//先插入获得id
		Integer id = staffMapper.insert(staff);
		//设置员工编号
		Date now = new Date(); // 创建一个Date对象，获取当前时间
		// 指定格式化格式
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String date = f.format(now).substring(0,4);
		String str2 = staff.getSecitonId()+"";
		if(staff.getSecitonId()<10)
			str2 = 0+str2;
		String str3 = staff.getId()+"";
		if(id<10) {
			str3 = 0+""+0+str3;
		}else if (id<100){
			str3 = 0+""+str3;
		}
		String number = date+str2+str3;
		System.out.println("生成的number为："+number);
		staff.setNumber(number);


		staffMapper.updateByPrimaryKey(staff);*/
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Staff staff){
		staffMapper.updateByPrimaryKey(staff);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Staff findOne(Integer id){
		Staff staff = staffMapper.selectByPrimaryKey(id);
		System.out.println("service: "+staff);
		return staff;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			staffMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(Staff staff, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		StaffExample example=new StaffExample();
		StaffExample.Criteria criteria = example.createCriteria();
		
		if(staff!=null){			
			if(staff.getNumber()!=null && staff.getNumber().length()>0){
				criteria.andNumberLike("%"+staff.getNumber()+"%");
			}
			if(staff.getName()!=null && staff.getName().length()>0){
				criteria.andNameLike("%"+staff.getName()+"%");
			}
			if(staff.getPassword()!=null && staff.getPassword().length()>0){
				criteria.andPasswordLike("%"+staff.getPassword()+"%");
			}
			if(staff.getPhone()!=null && staff.getPhone().length()>0){
				criteria.andPhoneLike("%"+staff.getPhone()+"%");
			}
			if(staff.getEmail()!=null && staff.getEmail().length()>0){
				criteria.andEmailLike("%"+staff.getEmail()+"%");
			}
			if(staff.getMajor()!=null && staff.getMajor().length()>0){
				criteria.andMajorLike("%"+staff.getMajor()+"%");
			}
	
		}
		
		Page<Staff> page= (Page<Staff>)staffMapper.selectByExample(example);
		return new PageResult((int) page.getTotal(), page.getResult());
	}

	//检查该员工是否存在
	@Override
	public int checked(String phone, String number) {
		//添加查询条件
		StaffExample example = new StaffExample();
		StaffExample.Criteria criteria = example.createCriteria();
		criteria.andNumberEqualTo(number);
		criteria.andPhoneEqualTo(phone);
		List<Staff> staff = staffMapper.selectByExample(example);
		if(staff.size()>0){//若员工存在
			sendSms(phone);//发送验证码
			return 1;
		}
		return 0;
	}

	@Override
	public int checkedCode(String phone,String code) {
		String smsCode = (String) redisTemplate.boundHashOps("smsCode").get(phone);
		if(code==null){
			return 0;
		}
		if(!code.equals(smsCode)){
			return 0;
		}
		return 1;
	}

	@Override
	public void updPwd(String number, String password) {
		//先从数据库中查出数据，在修改
		StaffExample example = new StaffExample();
		StaffExample.Criteria criteria = example.createCriteria();
		criteria.andNumberEqualTo(number);
		List<Staff> list = staffMapper.selectByExample(example);
		Staff staff = list.get(0);
		staff.setPassword(password);
		staffMapper.updateByExample(staff,example);
	}

	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	Destination smsDestination;
	//验证码发送
	private void sendSms(final String phone) {
		//1.生成验证码
		final String code = (long)(Math.random()*1000000)+"";
		//System.out.println("验证码："+code);
		//2.存储到redis
		redisTemplate.boundHashOps("smsCode").put(phone,code);
		//3.发送到activeMQ
		jmsTemplate.send(smsDestination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("mobile",phone);
				mapMessage.setString("template_code","SMS_171359087");
				mapMessage.setString("sign_name","MyFamily");
				Map m=new HashMap<>();
				m.put("code", code);
				mapMessage.setString("param", JSON.toJSONString(m));//参数
				return mapMessage;
			}
		});
	}

}
