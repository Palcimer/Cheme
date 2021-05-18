package gallery.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import gallery.model.dao.GalleryDao;
import gallery.model.vo.Gallery;
import gallery.model.vo.GalleryComment;
import gallery.model.vo.GalleryPageData;
import gallery.model.vo.GalleryViewData;
import group.model.vo.Group;
import member.model.vo.Member;

public class GalleryService {

	public GalleryPageData selectGalleryList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 9;
		int end = reqPage * numPerPage;
		int start = end -numPerPage + 1;
		GalleryDao dao = new GalleryDao();
		ArrayList<Gallery> list = dao.selectGalleryList(conn , start , end);
		//페이지 네비게이션 제작
		//1) 전체 페이지수를 구해야함 
		int totalCount = dao.totalCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;			
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		//페이지 네비 길이지정
		int pageNaviSize = 5;
		//1~5페이지 요청시 페이지 네비 시작번호 : 1
		//6~10패이지 요청시 페이지 네비 시작번호 : 6
		//11~15패이지 요청시 페이지 네비 시작번호 : 11
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		//페이지네비 시작
		String pageNavi = "<ul class='pagination'>";
		//페이지 네비 시작번호가 1이 아닌경우 이전버튼 생성
		if(pageNo != 1) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/galleryList?reqPage="+(pageNo-1)+"'>&laquo;</a></li>";
		}
		//페이지 숫자 생성
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {//현재보는 페이지를 부각시키기위한 코드
				pageNavi += "<li class='page-item active'>";
				pageNavi += "<a class='page-link' href='/galleryList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}else {
				pageNavi += "<li class='page-item'>";
				pageNavi += "<a class='page-link'href='/galleryList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;
			}
		}
		//다음버튼 생성
		if(pageNo <= totalPage) { //현재 페이지넘버 보다 토탈페이지가 높으면 다음버튼을 생성함
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/galleryList?reqPage="+(pageNo)+"'>&raquo;</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		GalleryPageData gpd = new GalleryPageData(list,pageNavi);
		return gpd;
	}

	public int insertGallery(Gallery ga) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GalleryDao().insertGallery(conn,ga);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public GalleryViewData selectGalleryView(int galleryNo) {
		Connection conn = JDBCTemplate.getConnection();
		GalleryDao dao = new GalleryDao();
		Gallery g =  dao.selectOneGallery(conn,galleryNo);
		ArrayList<GalleryComment> list = dao.selectGalleryCommentList(conn,galleryNo);
		JDBCTemplate.close(conn);
		GalleryViewData gvd = new GalleryViewData(g,list);
		return gvd;
	}
}
