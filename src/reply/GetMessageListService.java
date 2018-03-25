package reply;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class GetMessageListService {
	private static GetMessageListService instance = new GetMessageListService();

	public static GetMessageListService getInstance() {
		return instance;

	}

	private GetMessageListService() {
	} // 싱글톤

	private static final int MESSAGE_COUNT_PER_PAGE = 5;

	public MessageListView getMessageList(int pageNumber, String pronum) {
		Connection conn = null;
		int currentPageNumber = pageNumber;

		try {
			conn = ConnectionProvider.getConnection();
			ReplyDBBean messageDao = ReplyDBBean.getInstance();
			int messageTotalCount = messageDao.selectCount(pronum);
			List<ReplyDataBean> messageList = null;
			int firstRow = 0;
			int endRow = 0;

			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(firstRow, endRow, pronum);
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();

			}
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패:" + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}