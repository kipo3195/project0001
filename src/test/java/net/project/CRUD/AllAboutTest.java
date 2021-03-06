package net.project.CRUD;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.project.Member.dao.MemberMapper;
import net.project.board.dao.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:/context/spring/root-context.xml"
})
public class AllAboutTest {

	@Inject
	BoardMapper board;
	
	@Inject
	MemberMapper member;
	
	@Inject
	DataSource ds;
	
	@Test
	public void test() {
		System.out.println("board:"+board);
		System.out.println("member:"+member);
		System.out.println("ds:"+ds);
	}
	
	
}
