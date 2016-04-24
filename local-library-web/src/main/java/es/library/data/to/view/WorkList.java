package es.library.data.to.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import es.everis.library.ejb.BookService;
import es.everis.library.ejb.FilmService;
import es.everis.library.ejb.WorkService;
import es.everis.library.entity.business.Work;
import es.everis.library.entity.business.WorkType;
import es.library.model.WorkData;

@Named
@ApplicationScoped
public class WorkList {
	
	@EJB
	FilmService filmService;
	@EJB
	BookService bookService;
	
	private Integer workId;
	private String title;
	private String artistName;
	private WorkType workType;
	
	private Map<Integer, String> workList;
	private List<WorkData> worksDataList;
	
	public WorkList() {
		workList = new HashMap<Integer, String>();
		worksDataList = new ArrayList<WorkData>();
	}
	
	private void init() {
		for(Work work : filmService.getAll()) {
			workList.put(work.getWorkId(), work.getTitle());
//			work
//			worksDataList.add(WorkData.toData(work));
		}
		for(Work work : bookService.getAll()) {
			workList.put(work.getWorkId(), work.getTitle());
//			worksDataList.add(WorkData.toData(work));
		}
		
	}
	
	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Map<Integer, String> getWorkList() {
		init();
		return workList;
	}

	public void setWorkList(Map<Integer, String> workList) {
		this.workList = workList;
	}

	public List<WorkData> getWorksDataList() {
		init();
		return worksDataList;
	}

	public void setWorksDataList(List<WorkData> worksDataList) {
		this.worksDataList = worksDataList;
	}
	
	

}
