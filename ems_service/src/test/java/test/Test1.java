package test;

import com.ems.mapper.SectionMapper;
import com.ems.pojo.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: Test1
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/15 14:33
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class Test1 {

    @Autowired
    SectionMapper sectionMapper;
    @Test
    public void test(){
        List<Section> list = sectionMapper.selectByExample(null);
        System.out.println(list.size());
    }
}
