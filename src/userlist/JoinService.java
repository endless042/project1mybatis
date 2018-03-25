package userlist;

public class JoinService {
	private UserlistDBBean userpro=UserlistDBBean.getInstance();
	public boolean dupIdTest(JoinRequest joinReq) {
		
		UserlistDataBean user=userpro.getUser(joinReq.getId());
		
		
		if(user!=null) {
			
		return false;
		
		}else {
		
		return true;}
		

	}
}
