package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import ahistory.AhistoryDBBean;
import ahistory.AhistoryDataBean;
import auction.AuctionDBBean;
import auction.AuctionDataBean;
import cart.CartDBBean;
import cart.CartDataBean;
import gpurc.GpurcDBBean;
import gpurc.GpurcDataBean;
import order.OrderDBBean;
import order.OrderDataBean;
import paylist.PaylistDBBean;
import paylist.PaylistDataBean;
import userlist.UserlistDBBean;
import userlist.UserlistDataBean;

public class ActionController extends Action {

	public String main(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "메인");
		List aTopProduct = null;
		List gTopProduct = null;
		int acount;
		int gcount;
		try {
			AuctionDBBean apro = AuctionDBBean.getInstance();
			acount = apro.getAproductCount("top");
			if (acount > 0) {
				aTopProduct = apro.getTopProducts(1, 3);
				AuctionDataBean tmp = new AuctionDataBean();
				String olddate = "";
				String formatSdate = "";
				String formatEdate = "";

					for (int i = 0; i < aTopProduct.size(); i++) {
						tmp = (AuctionDataBean) aTopProduct.get(i);
						olddate = tmp.getSdate();
						formatSdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
								+ "일 " + olddate.substring(8, 10) + "시";
						olddate = tmp.getEdate();
						formatEdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
								+ "일 " + olddate.substring(8, 10) + "시";
						tmp.setSdate(formatSdate);
						tmp.setEdate(formatEdate);
					}
				}

			GpurcDBBean gpro = GpurcDBBean.getInstance();
			gcount = gpro.getGproductCount("top");
			if (gcount > 0) {
				gTopProduct = gpro.getTopProducts(1, 3);

				GpurcDataBean tmp = null;
				for (int i = 0; i < gTopProduct.size(); i++) {
					tmp = (GpurcDataBean) gTopProduct.get(i);
					Date date = new Date();
					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
					String curtime = simple.format(date);
					int timeCount = gpro.getRemainTime(tmp, curtime);
					int rday = timeCount / 24 / 60 / 60;

					tmp.setEdate(rday + "");
				}
			}
			int i = 1;
			int j = 1;
			req.setAttribute("acount", acount);
			req.setAttribute("gcount", gcount);
			req.setAttribute("aTopProduct", aTopProduct);
			req.setAttribute("gTopProduct", gTopProduct);
			req.setAttribute("i", i);
			req.setAttribute("j", j);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/view/main.jsp";
	}
	

	public String auction(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "경매");

		String stateSelect = req.getParameter("stateSelect");
		if (stateSelect == null || stateSelect == "") {
			stateSelect = "all";
		}

		String state = req.getParameter("state");
		if (state == null || state == "") {
			state = "2";
		}

		int pageSize = 6;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String pageNum = req.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int allcount = 0;
		int number = 0;
		List productList = null;

		AuctionDBBean apro = AuctionDBBean.getInstance();
		count = apro.getAproductCount(stateSelect);
		allcount = apro.getAproductCount("all");
		if (count > 0) {
			productList = apro.getProducts(startRow, endRow, stateSelect);
		}

		number = count - (currentPage - 1) * pageSize;

		int bottomLine = 5;

		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;

		if (endPage > pageCount)
			endPage = pageCount;

		AuctionDataBean tmp = new AuctionDataBean();
		String olddate = "";
		String formatSdate = "";
		String formatEdate = "";

		if (count > 0) {
			for (int i = 0; i < productList.size(); i++) {
				tmp = (AuctionDataBean) productList.get(i);
				olddate = tmp.getSdate();
				formatSdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
						+ "일 " + olddate.substring(8, 10) + "시";
				olddate = tmp.getEdate();
				formatEdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
						+ "일 " + olddate.substring(8, 10) + "시";
				tmp.setSdate(formatSdate);
				tmp.setEdate(formatEdate);

			}
		}

		req.setAttribute("stateSelect", stateSelect);

		req.setAttribute("count", count);
		req.setAttribute("allcount", allcount);
		req.setAttribute("productList", productList);
		req.setAttribute("startPage", startPage);
		req.setAttribute("bottomLine", bottomLine);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("number", number);

		return "/view/auction.jsp?stateSelect=" + stateSelect;
	}

	public String acontent(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "경매");

		String part = req.getParameter("part");
		String state = req.getParameter("state");
		if (state == null || state == "") {
			state = "2";
		}

		int num = Integer.parseInt(req.getParameter("num"));
		
		System.out.println("num======================="+num);
		String pageNum = req.getParameter("pageNum");

		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}

		try {
			AuctionDBBean aPro = AuctionDBBean.getInstance();
			AuctionDataBean aproduct = aPro.getProduct(num, "content");

			System.out.println(aproduct);

			Date date = new Date();

			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

			System.out.println(simple.format(date));
			String curtime = simple.format(date);

			int timeCount = aPro.getRemainTime(aproduct, curtime);
			int startRemain = aPro.getStartRemain(aproduct, curtime);

			String olddate = aproduct.getSdate();
			String formatSdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 "
					+ olddate.substring(6, 8) + "일 " + olddate.substring(8, 10) + "시";
			olddate = aproduct.getEdate();
			String formatEdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 "
					+ olddate.substring(6, 8) + "일 " + olddate.substring(8, 10) + "시";

			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("part", part);
			req.setAttribute("aproduct", aproduct);
			req.setAttribute("timeCount", timeCount);
			req.setAttribute("formatSdate", formatSdate);
			req.setAttribute("formatEdate", formatEdate);

			int rsecond = timeCount % 60;
			int rminutes = timeCount / 60 % 60;
			int rhour = timeCount / 3600 % 24;
			int rday = timeCount / 24 / 60 / 60;

			req.setAttribute("rsecond", rsecond);
			req.setAttribute("rminutes", rminutes);
			req.setAttribute("rhour", rhour);
			req.setAttribute("rday", rday);
			req.setAttribute("startRemain", startRemain);
		
			AhistoryDBBean hpro = AhistoryDBBean.getInstance();
			List historylist = null;
			int historycount = hpro.getHistoryCount(num);
			req.setAttribute("historycount", historycount);
			
			if(historycount!=0) {
			historylist=hpro.getHistoryList(0, 3, num);
			
			req.setAttribute("historylist", historylist);
		}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/view/aproductview.jsp?select=auction";
	}

	public String gcontent_reply(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "경매");

		return "/view/gproductview.jsp?select=gpurchase&part=reply";
	}

	public String auctionSubmit(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "경매");

		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");

		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		String price = req.getParameter("price");
		AhistoryDBBean hpro = AhistoryDBBean.getInstance();
		AhistoryDataBean ahistory = new AhistoryDataBean();

		ahistory.setNum(num);
		ahistory.setPrice(price);
		ahistory.setUserid((String) req.getSession().getAttribute("loginId"));

		hpro.addHistory(ahistory);

		System.out.println(ahistory);

		AuctionDBBean apro = AuctionDBBean.getInstance();
		AuctionDataBean aproduct = apro.getProduct(num, "");

		aproduct.setEprice(price);

		int c = aproduct.getCount();

		
		aproduct.setCount(c + 1);
	

		apro.updateAproduct(aproduct);
		System.out.println(aproduct);

		OrderDBBean opro = OrderDBBean.getInstance();
		OrderDataBean order = new OrderDataBean();

		order.setAprice(price);
		order.setAproduct(aproduct);
		order.setPronum("a" + num);
		order.setUserid((String) req.getSession().getAttribute("loginId"));

		opro.addOrder(order);

		return "/page/acontent";
	}

	public String gpurcSubmit(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "공동구매");

		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");

		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}

		String quantity = req.getParameter("quantity");
		if (quantity == null || quantity == "") {
			quantity = "0";
		}
		int selectquantity = Integer.parseInt(quantity);
		System.out.println(quantity);

		try {
			OrderDBBean opro = OrderDBBean.getInstance();
			OrderDataBean order = new OrderDataBean();

			GpurcDBBean gpro = GpurcDBBean.getInstance();
			GpurcDataBean gproduct = gpro.getProduct(num, "");

			int gcount = gproduct.getCount();
			System.out.println(gcount);

			gproduct.setCount(gcount + selectquantity);

			gpro.updateGproduct(gproduct);

			System.out.println(gproduct);

			order.setGproduct(gproduct);
			order.setPronum("g" + num);
			order.setUserid((String) req.getSession().getAttribute("loginId"));
			order.setCount(selectquantity);

			opro.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/page/gcontent";
	}

	public String gpurchase(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "공동구매");

		String stateSelect = req.getParameter("stateSelect");
		if (stateSelect == null || stateSelect == "") {
			stateSelect = "all";
		}

		int pageSize = 6;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String pageNum = req.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int allcount = 0;
		int number = 0;

		List productList = null;
		GpurcDBBean gpro = GpurcDBBean.getInstance();
		count = gpro.getGproductCount(stateSelect);
		allcount = gpro.getGproductCount("all");
		if (count > 0) {
			productList = gpro.getProducts(startRow, endRow, stateSelect);
		}

		GpurcDataBean tmp = null;
		if (count > 0) {
			for (int i = 0; i < productList.size(); i++) {
				tmp = (GpurcDataBean) productList.get(i);
				Date date = new Date();
				SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
				String curtime = simple.format(date);
				int timeCount = gpro.getRemainTime(tmp, curtime);
				int rday = timeCount / 24 / 60 / 60;

				tmp.setEdate(rday + "");

			}
		}

		number = count - (currentPage - 1) * pageSize;

		int bottomLine = 5;

		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;

		if (endPage > pageCount)
			endPage = pageCount;

		req.setAttribute("stateSelect", stateSelect);
		req.setAttribute("count", count);
		req.setAttribute("allcount", allcount);
		req.setAttribute("productList", productList);
		req.setAttribute("startPage", startPage);
		req.setAttribute("bottomLine", bottomLine);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("number", number);

		return "/view/gpurchase.jsp?select=gpurchase&stateSelect=" + stateSelect;
	}

	public String gcontent(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "공동구매");

		String part = req.getParameter("part");
		String state = req.getParameter("state");
		if (state == null || state == "") {
			state = "2";
		}

		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");

		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {
			GpurcDBBean gPro = GpurcDBBean.getInstance();
			GpurcDataBean gproduct = gPro.getProduct(num, "content");

			System.out.println(gproduct);

			Date date = new Date();

			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

			String curtime = simple.format(date);

			int timeCount = gPro.getRemainTime(gproduct, curtime);

			String olddate = gproduct.getSdate();
			String formatSdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 "
					+ olddate.substring(6, 8) + "일 " + olddate.substring(8, 10) + "시";
			olddate = gproduct.getEdate();
			String formatEdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 "
					+ olddate.substring(6, 8) + "일 " + olddate.substring(8, 10) + "시";

			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("part", part);

			req.setAttribute("gproduct", gproduct);
			req.setAttribute("timeCount", timeCount);
			req.setAttribute("formatSdate", formatSdate);
			req.setAttribute("formatEdate", formatEdate);

			int rsecond = timeCount % 60;
			int rminutes = timeCount / 60 % 60;
			int rhour = timeCount / 3600 % 24;
			int rday = timeCount / 24 / 60 / 60;

			req.setAttribute("rsecond", rsecond);
			req.setAttribute("rminutes", rminutes);
			req.setAttribute("rhour", rhour);
			req.setAttribute("rday", rday);
			int startRemain = gPro.getStartRemain(gproduct, curtime);
			
			req.setAttribute("startRemain", startRemain);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/view/gproductview.jsp?select=gpurchase";
	}

	public String survey(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "수입제안");
		return "/view/survey.jsp";
	}

	public String contact(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "ABOUT US");
		return "/view/contact.jsp";
	}

	public String mypage(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "마이페이지");

		try {
			UserlistDBBean userPro = UserlistDBBean.getInstance();
			UserlistDataBean user = userPro.getUser((String) req.getSession().getAttribute("loginId"));

			req.setAttribute("user", user);

		} catch (Exception e) {
		}

		return "/mypage/mypage.jsp?select=myinfo";
	}

	public String myarticle(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "마이페이지");

		try {
			UserlistDBBean userPro = UserlistDBBean.getInstance();
			UserlistDataBean user = userPro.getUser((String) req.getSession().getAttribute("loginId"));

			req.setAttribute("user", user);

		} catch (Exception e) {
		}

		return "/mypage/mypage_article.jsp?select=articles";
	}

	public String addCart(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "마이페이지");

		String userid = (String) req.getSession().getAttribute("loginId");
		String pronum = req.getParameter("num");
		int pnum = Integer.parseInt(pronum);
		String pcode = req.getParameter("pcode");

		AuctionDBBean apro = AuctionDBBean.getInstance();
		GpurcDBBean gpro = GpurcDBBean.getInstance();

		CartDataBean cart = new CartDataBean();

		cart.setUserid(userid);
		cart.setPronum(pcode + pronum);

		if (pcode.equals("g")) {
			cart.setGproduct(gpro.getProduct(pnum, ""));
		} else if (pcode.equals("a")) {
			cart.setAproduct(apro.getProduct(pnum, ""));
		}

		CartDBBean cpro = CartDBBean.getInstance();

		cpro.addCart(cart);

		System.out.println(cart);

		return "/page/cartlist";
	}

	public String cartlist(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		req.setAttribute("title", "마이페이지");

		int pageSize = 4;

		String apageNum = req.getParameter("apageNum");
		if (apageNum == null || apageNum == "") {
			apageNum = "1";
		}
		String gpageNum = req.getParameter("gpageNum");
		if (gpageNum == null || gpageNum == "") {
			gpageNum = "1";
		}

		String userid = (String) req.getSession().getAttribute("loginId");

		int acurrentPage = Integer.parseInt(apageNum);
		int gcurrentPage = Integer.parseInt(gpageNum);
		int astartRow = (acurrentPage - 1) * pageSize + 1;
		int aendRow = acurrentPage * pageSize;
		int gstartRow = (gcurrentPage - 1) * pageSize + 1;
		int gendRow = gcurrentPage * pageSize;

		int acount = 0;
		int gcount = 0;

		int anumber = 0;
		int gnumber = 0;

		List aList = null;
		List gList = null;

		CartDBBean cPro = CartDBBean.getInstance();
		acount = cPro.getCartCount("a", userid);

		// System.out.println("acount:"+acount);

		gcount = cPro.getCartCount("g", userid);

		int bottomLine = 5;
		try {
			if (acount > 0) {
				aList = cPro.getCarts(astartRow, aendRow, "a", userid);
			}

			anumber = acount - (acurrentPage - 1) * pageSize;

			int apageCount = acount / pageSize + (acount % pageSize == 0 ? 0 : 1);
			int astartPage = 1 + (acurrentPage - 1) / bottomLine * bottomLine;
			int aendPage = astartPage + bottomLine - 1;

			if (aendPage > apageCount)
				aendPage = apageCount;

			if (gcount > 0) {
				gList = cPro.getCarts(gstartRow, gendRow, "g", userid);
			}

			gnumber = gcount - (gcurrentPage - 1) * pageSize;

			int gpageCount = gcount / pageSize + (gcount % pageSize == 0 ? 0 : 1);
			int gstartPage = 1 + (gcurrentPage - 1) / bottomLine * bottomLine;
			int gendPage = gstartPage + bottomLine - 1;

			if (gendPage > gpageCount)
				gendPage = gpageCount;

			req.setAttribute("acount", acount);
			req.setAttribute("gcount", gcount);

			req.setAttribute("aList", aList);
			req.setAttribute("gList", gList);

			req.setAttribute("astartPage", astartPage);
			req.setAttribute("bottomLine", bottomLine);
			req.setAttribute("acurrentPage", acurrentPage);
			req.setAttribute("aendPage", aendPage);
			req.setAttribute("apageCount", apageCount);
			req.setAttribute("anumber", anumber);
			req.setAttribute("apageNum", apageNum);
			req.setAttribute("gpageNum", gpageNum);

			req.setAttribute("gstartPage", gstartPage);
			req.setAttribute("userid", userid);
			req.setAttribute("gcurrentPage", gcurrentPage);
			req.setAttribute("gendPage", gendPage);
			req.setAttribute("gpageCount", gpageCount);
			req.setAttribute("gnumber", gnumber);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/mypage/mypage_cart.jsp?select=cart";

	}

	public String orderlist(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		req.setAttribute("title", "마이페이지");

		int pageSize = 4;

		String apageNum = req.getParameter("apageNum");
		if (apageNum == null || apageNum == "") {
			apageNum = "1";
		}
		String gpageNum = req.getParameter("gpageNum");
		if (gpageNum == null || gpageNum == "") {
			gpageNum = "1";
		}

		String userid = (String) req.getSession().getAttribute("loginId");

		int acurrentPage = Integer.parseInt(apageNum);
		int gcurrentPage = Integer.parseInt(gpageNum);
		int astartRow = (acurrentPage - 1) * pageSize + 1;
		int aendRow = acurrentPage * pageSize;
		int gstartRow = (gcurrentPage - 1) * pageSize + 1;
		int gendRow = gcurrentPage * pageSize;

		int acount = 0;
		int gcount = 0;

		int anumber = 0;
		int gnumber = 0;

		List aList = null;
		List gList = null;

		OrderDBBean oPro = OrderDBBean.getInstance();
		acount = oPro.getOrderCount("a", userid);
		gcount = oPro.getOrderCount("g", userid);
		OrderDataBean order1=null;
		int bottomLine = 5;
		try {
			if (acount > 0) {
				aList = oPro.getSelectOrders(astartRow, aendRow, "a", userid);
				AuctionDataBean tmp = new AuctionDataBean();
				String olddate = "";
				String formatSdate = "";
				String formatEdate = "";

		
				for (int i = 0; i < aList.size(); i++) {
					order1=(OrderDataBean) aList.get(i);
					tmp = order1.getAproduct();
				
					
					olddate = tmp.getSdate();
					formatSdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
							+ "일 " + olddate.substring(8, 10) + "시";
					olddate = tmp.getEdate();
					formatEdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
							+ "일 " + olddate.substring(8, 10) + "시";
					tmp.setSdate(formatSdate);
					tmp.setEdate(formatEdate);

					}
			}

			anumber = acount - (acurrentPage - 1) * pageSize;

			int apageCount = acount / pageSize + (acount % pageSize == 0 ? 0 : 1);
			int astartPage = 1 + (acurrentPage - 1) / bottomLine * bottomLine;
			int aendPage = astartPage + bottomLine - 1;

			if (aendPage > apageCount)
				aendPage = apageCount;

			if (gcount > 0) {
				gList = oPro.getSelectOrders(gstartRow, gendRow, "g", userid);
				GpurcDataBean tmp1 = new GpurcDataBean();
				String olddate = "";
				String formatSdate = "";
				String formatEdate = "";

		
				for (int i = 0; i < gList.size(); i++) {
					order1=(OrderDataBean) gList.get(i);
					tmp1 = order1.getGproduct();
					System.out.println("=======alist======");
					
					olddate = tmp1.getSdate();
					formatSdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
							+ "일 " + olddate.substring(8, 10) + "시";
					olddate = tmp1.getEdate();
					formatEdate = olddate.substring(0, 4) + "년 " + olddate.substring(4, 6) + "월 " + olddate.substring(6, 8)
							+ "일 " + olddate.substring(8, 10) + "시";
					tmp1.setSdate(formatSdate);
					tmp1.setEdate(formatEdate);
					}
			}
			gnumber = gcount - (gcurrentPage - 1) * pageSize;

			int gpageCount = gcount / pageSize + (gcount % pageSize == 0 ? 0 : 1);
			int gstartPage = 1 + (gcurrentPage - 1) / bottomLine * bottomLine;
			int gendPage = gstartPage + bottomLine - 1;

			if (gendPage > gpageCount)
				gendPage = gpageCount;

			req.setAttribute("acount", acount);
			req.setAttribute("gcount", gcount);

			req.setAttribute("aList", aList);
			req.setAttribute("gList", gList);

			req.setAttribute("astartPage", astartPage);
			req.setAttribute("bottomLine", bottomLine);
			req.setAttribute("acurrentPage", acurrentPage);
			req.setAttribute("aendPage", aendPage);
			req.setAttribute("apageCount", apageCount);
			req.setAttribute("anumber", anumber);
			req.setAttribute("apageNum", apageNum);
			req.setAttribute("gpageNum", gpageNum);

			req.setAttribute("gstartPage", gstartPage);
			req.setAttribute("userid", userid);
			req.setAttribute("gcurrentPage", gcurrentPage);
			req.setAttribute("gendPage", gendPage);
			req.setAttribute("gpageCount", gpageCount);
			req.setAttribute("gnumber", gnumber);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/mypage/mypage_order.jsp?select=order";

	}

	public String payPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "결제");
		String pcode = req.getParameter("pcode");
		String ordernum = req.getParameter("ordernum");
		int pronum = Integer.parseInt(req.getParameter("pronum"));

		try {
			AuctionDBBean apro = AuctionDBBean.getInstance();
			AuctionDataBean product = apro.getProduct(pronum, "");

			UserlistDBBean upro = UserlistDBBean.getInstance();
			UserlistDataBean user = upro.getUser((String) req.getSession().getAttribute("loginId"));

			PaylistDBBean paypro = PaylistDBBean.getInstance();
			PaylistDataBean pay = new PaylistDataBean();

			pay.setAddr(req.getParameter("addr"));
			pay.setDeliv(req.getParameter("deliv"));
			pay.setName(req.getParameter("name"));
			pay.setCount(Integer.parseInt(req.getParameter("count")));

			if (pcode.equals("a")) {
				pay.setPronum("a" + req.getParameter("pronum"));
			} else if (pcode.equals("g")) {
				pay.setPronum("g" + req.getParameter("pronum"));
			}

			pay.setTel(req.getParameter("tel"));
			pay.setUserid((String) req.getSession().getAttribute("loginId"));

			String submitPoint = req.getParameter("point");
			if (submitPoint == null || submitPoint.equals("")) {
				submitPoint = "0";
			}
			System.out.println(pay);

			int price = Integer.parseInt(req.getParameter("price"));
			System.out.println("=====가격======" + price);

			int point = Integer.parseInt(submitPoint);
			System.out.println("======포인트=====" + point);
			pay.setPoint(point + "");
			int afterprice = price - point;

			System.out.println("====결제가격=====" + afterprice);
			System.out.println("=====주문번호====" + ordernum);
			pay.setPrice(afterprice + "");
			pay.setOrdernum(ordernum);
			paypro.addPay(pay);

			int userpoint = Integer.parseInt(user.getPoint());

			int changePoint = (int) ((userpoint - point) + Math.round(afterprice * 0.03));
			user.setPoint(changePoint + "");

			upro.updateUser(user);

			OrderDBBean opro = OrderDBBean.getInstance();
			OrderDataBean order = null;
			order = opro.getOrder(Integer.parseInt(ordernum));
			order.setPayState("1"); // 결제완료

			opro.updateOrder(order);

			req.setAttribute("product", product);
			req.setAttribute("user", user);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/mypage/mypage_payComp.jsp?select=order";
	}

	public String mypagePay(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "결제");
		String pcode = req.getParameter("pcode");
		String apageNum = req.getParameter("apageNum");
		String gpageNum = req.getParameter("gpageNum");
		int num = Integer.parseInt(req.getParameter("num"));
		String count = req.getParameter("count");
		if (count == null || count.equals("")) {
			count = "1";
		}

		if (pcode.equals("a")) {
			AuctionDBBean apro = AuctionDBBean.getInstance();
			AuctionDataBean product = apro.getProduct(num, "");
			req.setAttribute("product", product);
		} else if (pcode.equals("g")) {
			GpurcDBBean gpro = GpurcDBBean.getInstance();
			GpurcDataBean product = gpro.getProduct(num, "");
			req.setAttribute("product", product);
		}

		UserlistDBBean upro = UserlistDBBean.getInstance();
		UserlistDataBean user = upro.getUser((String) req.getSession().getAttribute("loginId"));

		String ordernum = req.getParameter("ordernum");
		req.setAttribute("num", num);
		req.setAttribute("apageNum", apageNum);
		req.setAttribute("gpageNum", gpageNum);
		req.setAttribute("pcode", pcode);
		req.setAttribute("user", user);
		req.setAttribute("ordernum", ordernum);
		req.setAttribute("count", count);
		return "/mypage/mypage_pay.jsp?select=order";
	}

	public String paylist(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		req.setAttribute("title", "마이페이지");

		int pageSize = 4;

		String apageNum = req.getParameter("apageNum");
		if (apageNum == null || apageNum == "") {
			apageNum = "1";
		}
		String gpageNum = req.getParameter("gpageNum");
		if (gpageNum == null || gpageNum == "") {
			gpageNum = "1";
		}

		String userid = (String) req.getSession().getAttribute("loginId");

		int acurrentPage = Integer.parseInt(apageNum);
		int gcurrentPage = Integer.parseInt(gpageNum);
		int astartRow = (acurrentPage - 1) * pageSize + 1;
		int aendRow = acurrentPage * pageSize;
		int gstartRow = (gcurrentPage - 1) * pageSize + 1;
		int gendRow = gcurrentPage * pageSize;

		int acount = 0;
		int gcount = 0;

		int anumber = 0;
		int gnumber = 0;

		List aList = null;
		List gList = null;

		PaylistDBBean payPro = PaylistDBBean.getInstance();
		acount = payPro.getPayCountUser("a", userid);
		gcount = payPro.getPayCountUser("g", userid);
		System.out.println("==================" + acount);
		System.out.println("===================" + gcount);

		int bottomLine = 5;
		try {
			if (acount > 0) {
				aList = payPro.getPaylistUser(astartRow, aendRow, "a", userid);
			}

			anumber = acount - (acurrentPage - 1) * pageSize;

			int apageCount = acount / pageSize + (acount % pageSize == 0 ? 0 : 1);
			int astartPage = 1 + (acurrentPage - 1) / bottomLine * bottomLine;
			int aendPage = astartPage + bottomLine - 1;

			if (aendPage > apageCount)
				aendPage = apageCount;

			if (gcount > 0) {
				gList = payPro.getPaylistUser(gstartRow, gendRow, "g", userid);
			}

			gnumber = gcount - (gcurrentPage - 1) * pageSize;

			int gpageCount = gcount / pageSize + (gcount % pageSize == 0 ? 0 : 1);
			int gstartPage = 1 + (gcurrentPage - 1) / bottomLine * bottomLine;
			int gendPage = gstartPage + bottomLine - 1;

			if (gendPage > gpageCount)
				gendPage = gpageCount;

			req.setAttribute("acount", acount);
			req.setAttribute("gcount", gcount);

			req.setAttribute("aList", aList);
			req.setAttribute("gList", gList);

			req.setAttribute("astartPage", astartPage);
			req.setAttribute("bottomLine", bottomLine);
			req.setAttribute("acurrentPage", acurrentPage);
			req.setAttribute("aendPage", aendPage);
			req.setAttribute("apageCount", apageCount);
			req.setAttribute("anumber", anumber);
			req.setAttribute("apageNum", apageNum);
			req.setAttribute("gpageNum", gpageNum);

			req.setAttribute("gstartPage", gstartPage);
			req.setAttribute("userid", userid);
			req.setAttribute("gcurrentPage", gcurrentPage);
			req.setAttribute("gendPage", gendPage);
			req.setAttribute("gpageCount", gpageCount);
			req.setAttribute("gnumber", gnumber);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/mypage/mypage_complist.jsp?select=pay";

	}

	public String mypagePayView(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "마이페이지");
		String pcode = req.getParameter("pcode");
		String apageNum = req.getParameter("apageNum");
		String gpageNum = req.getParameter("gpageNum");
		int num = Integer.parseInt(req.getParameter("num"));
		int pronum = Integer.parseInt(req.getParameter("pronum"));

		String count = req.getParameter("count");
		if (count == null || count.equals("")) {
			count = "1";
		}

		if (pcode.equals("a")) {
			AuctionDBBean apro = AuctionDBBean.getInstance();
			AuctionDataBean product = apro.getProduct(pronum, "");
			req.setAttribute("product", product);
		} else if (pcode.equals("g")) {
			GpurcDBBean gpro = GpurcDBBean.getInstance();
			GpurcDataBean product = gpro.getProduct(pronum, "");
			req.setAttribute("product", product);
		}

		UserlistDBBean upro = UserlistDBBean.getInstance();
		UserlistDataBean user = upro.getUser((String) req.getSession().getAttribute("loginId"));

		

		PaylistDBBean paypro = PaylistDBBean.getInstance();
		PaylistDataBean pay = paypro.getPay(num);
		String ordernum=pay.getOrdernum();
		req.setAttribute("pay", pay);
		req.setAttribute("num", num);
		req.setAttribute("apageNum", apageNum);
		req.setAttribute("gpageNum", gpageNum);
		req.setAttribute("pcode", pcode);
		req.setAttribute("user", user);
		req.setAttribute("ordernum", ordernum);
		req.setAttribute("count", count);
		return "/mypage/mypage_payView.jsp?select=pay";
	}

	public String payCancelPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		req.setAttribute("title", "마이페이지");

		String pcode = req.getParameter("pcode");
		String apageNum = req.getParameter("apageNum");
		String gpageNum = req.getParameter("gpageNum");
		int num = Integer.parseInt(req.getParameter("num"));
		int pronum = Integer.parseInt(req.getParameter("pronum"));

		String ordernum = req.getParameter("ordernum");
		int ordernumber=Integer.parseInt(ordernum);
		OrderDBBean opro = OrderDBBean.getInstance();
		OrderDataBean order = opro.getOrder(Integer.parseInt(ordernum));
		order.setPayState("2");

		opro.updateOrder(order);

		// 취소단계로바꾸기

		UserlistDBBean upro = UserlistDBBean.getInstance();
		UserlistDataBean user = upro.getUser((String) req.getSession().getAttribute("loginId"));

		PaylistDBBean paypro = PaylistDBBean.getInstance();
		PaylistDataBean pay = paypro.getPay(num);

		int payPoint = Integer.parseInt(pay.getPoint());
		int userPoint = Integer.parseInt(user.getPoint());
		user.setPoint((payPoint + userPoint) + "");

		upro.updateUser(user);

		// 유저포인트복구
		
		paypro.deletePay(num);
		
		req.setAttribute("pay", pay);
		req.setAttribute("num", num);
		req.setAttribute("apageNum", apageNum);
		req.setAttribute("gpageNum", gpageNum);
		req.setAttribute("pcode", pcode);
		req.setAttribute("user", user);
		req.setAttribute("ordernum", ordernum);

		return "/mypage/mypage_payCancelComp.jsp?select=pay";
	}

}
