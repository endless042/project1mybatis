package reply;

import java.sql.Connection;
import java.sql.SQLException;

import db.MessageDBBean;
import db.MessageDataBean;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteMessageService {
	private static WriteMessageService instance=new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		return instance;
	}
	private WriteMessageService() {}
	public void write(MessageDataBean message) {
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			MessageDBBean messageDao=MessageDBBean.getInstance();
			messageDao.insert(conn,message);
			
		}catch(SQLException e) {
			throw new ServiceException("메세지 등록 실패: "+e.getMessage(),e);
			
		}finally {JdbcUtil.close(conn);
	}
}
}


