package edu.kh.project.performance.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kh.project.performance.model.dto.Performance;
import edu.kh.project.performance.model.dto.PerformanceRanking;

@Mapper
public interface PerformanceMapper {

	/** 장르별 공연 목록 조회
	 * @param genre
	 * @return
	 * @author 우수민
	 */
	List<Performance> genre(String genre);
	
	/** 
	 * 장르별 공연 목록 페이징 조회
	 * @param genre 장르
	 * @param pageSize 페이지당 항목 수
	 * @param offset 시작 위치
	 * @return 공연 목록
	 * @author 우수민
	 */
	List<Performance> genreWithPaging(@Param("genre") String genre, 
	                                 @Param("pageSize") int pageSize, 
	                                 @Param("offset") int offset);

	/** 공연 상세페이지 조회
	 * @param mt20id
	 * @return
	 * @author 우수민
	 */
	Performance detail(String mt20id);

	/** 스케줄 및 잔여 좌석 조회
	 * @param mt20id
	 * @return
	 */
	List<Map<String, Object>> getScheduleData(String mt20id);
	
	/** 공연 위도, 경도 조회
	 * @param mt20id
	 * @return
	 * @author 우수민
	 */
	Performance selectPerformanceById(String mt20id);

	/** 메인 페이지 주요 공연 소개
	 * @return
	 */
	List<Performance> mainPerform();

	/** 상위 10개 공연 가져오기
	 * @param i
	 * @return
	 */
	List<PerformanceRanking> performanceRanking();
	
	/** 공연관리자가 등록한 공연 목록 조회 
	 * @param memberNo
	 * @return
	 * @author 우수민
	 */
	List<Performance> selectPerformancesByManager(int memberNo);

}
