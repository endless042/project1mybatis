package reply;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteMessageService {
	private static DeleteMessageService instance=new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return instance;
	}
	private DeleteMessageService() {}
	
	public void deleteMessage(int num, String password) {
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			ReplyDBBean messageDao=ReplyDBBean.getInstance();
			ReplyDataBean message=messageDao.select(num);
			if(message==null) {
				throw new MessageNotFoundException("메세지 없음");
				
			}
			if(!message.matchPassword(password)) {
				throw new InvalidPassowrdException("bad password");
			}
			messageDao.delete(num);
			conn.commit();
		}catch(SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패"+ex.getMessage(),ex);
		}catch(InvalidPassowrdException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		}finally {
			JdbcUtil.close(conn);
			}
		}
	}

