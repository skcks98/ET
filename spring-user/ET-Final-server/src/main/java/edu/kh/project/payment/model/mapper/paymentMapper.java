package edu.kh.project.payment.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kh.project.payment.model.dto.Booking;
import edu.kh.project.payment.model.dto.Payment;
import edu.kh.project.payment.model.dto.Seat;
import edu.kh.project.performance.model.dto.Performance;

@Mapper
public interface paymentMapper {

	// 특정 공연 좌석 조회
	//List<Seat> selectSeatsByShow(@Param("showDate") String showDate, @Param("showTime") String showTime);

	// 좌석 상태 업데이트(예약)
	int updateSeatStatus(@Param("seatId") String seatId, @Param("status") String status);


	// 좌석 가격 조회 (등급 기준)
	int selectSeatPrice(String gradeId);

	// 결제 정보 저장
	int insertPayment(Payment paymentData);

	// 공연 정보 조회
	Performance getPerformanceDetail(String performanceId);

	// 예약 정보 저장
	int insertBooking(Booking bookingData);

	// 특정 공연 좌석 조회
	List<Seat> selectSeatsByShow(String mt20id, String selectedDate, String selectedTime);

	
	
}
