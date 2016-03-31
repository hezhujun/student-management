package com.studentManagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.studentManagement.model.Student;

public class ReadExcelUtil {

	private MyService service;

	public List<String> readExcel(File fileName) throws Exception {
		List<String> stuName = new ArrayList<String>();
		stuName.clear();

		FileInputStream file = new FileInputStream(fileName);
		POIFSFileSystem ts = new POIFSFileSystem(file);
		file.close();
		HSSFWorkbook wb = new HSSFWorkbook(ts);
		HSSFSheet sheet = wb.getSheetAt(0);
		int startRowNum = sheet.getFirstRowNum();
		int endRowNum = sheet.getLastRowNum();
		for (int rowNum = startRowNum + 2; rowNum <= endRowNum; rowNum++) {
			Student student = new Student();
			HSSFRow row = sheet.getRow(rowNum);
			int startCellNum = row.getFirstCellNum();
			int cellNum = startCellNum + 1;
			
			HSSFCell cell = row.getCell(startCellNum);
			// 判断新一行是否有序号,没序号说明没有记录了
			Double dtemp = cell.getNumericCellValue();
			if(dtemp == null)
				break;
			cell = row.getCell(cellNum);
			try{
				// 入学年份
				int year = (int) cell.getNumericCellValue();
				student.setYear(year);
			} catch (Exception e) {
				// 出错记录为0
				try {
					// 文本形式读入
					student.setYear(Integer.parseInt(cell.getStringCellValue()));
				} catch (Exception ex) {
					// 还读不了就设置为0
					student.setYear(0);
				}
				
			}
			
			// 姓名
			cell = row.getCell(++cellNum);
			try {
				student.setName(cell.getStringCellValue());
			} catch (Exception e) {
				student.setName("");
			}
			
			// 学号
			cell = row.getCell(++cellNum);
			try {
				student.setStudentId(Long.parseLong(cell.getStringCellValue()));
			} catch (Exception e) {
				// TODO: handle exception
				try{
					student.setStudentId((long)cell.getNumericCellValue());
				} catch (Exception ex) {
					// TODO: handle exception
					// 学号都不正确，就不录入这个学生的信息了
					continue;
				}
				
			}
			// 没有学号时忽略
			if(student.getStudentId() == 1){
				continue;
			}

			// 性别
			cell = row.getCell(++cellNum);
			try {
				student.setSex(cell.getStringCellValue());
			} catch (Exception e) {
				student.setSex("");
			}
			// 民族
			cell = row.getCell(++cellNum);
			try {
				student.setNation(cell.getStringCellValue());
			} catch (Exception e) {
				student.setNation("");
			}
			// 政治面貌
			cell = row.getCell(++cellNum);
			try {
				student.setPolitical(cell.getStringCellValue());
			} catch (Exception e) {
				student.setPolitical("");
			}
			// 出生年月
			cell = row.getCell(++cellNum);
			try{
				student.setYearAndMonthOfBirth(cell.getStringCellValue());
			} catch (Exception e) {
				try {
					student.setYearAndMonthOfBirth(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setYearAndMonthOfBirth("");
				}
				
			}
			
			// 专业班级
			cell = row.getCell(++cellNum);
			try {
				student.setClass_(cell.getStringCellValue());
			} catch (Exception e) {
				// 如果是数字格式
				try {
					student.setClass_(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setClass_("");
				}
			}
			// 本人联系电话
			cell = row.getCell(++cellNum);
			try {
				student.setTel(cell.getStringCellValue());
			} catch (Exception e) {
				// 如果是数字格式
				try {
					student.setTel(String.valueOf(cell.getNumericCellValue())); 
				}catch (Exception ex) {
					student.setTel("");
				}
				
			}
			
			// 现住址
			cell = row.getCell(++cellNum);
			try {
				student.setLocation(cell.getStringCellValue());
			} catch (Exception e) {
				student.setLocation("");
			}
			// 身份证号
			cell = row.getCell(++cellNum);
			try {
				student.setIdcard(cell.getStringCellValue());
			} catch (Exception e) {
				// 如果是数字格式
				try {
					student.setIdcard(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setIdcard("");
				}
				
			}
			
			// 详细家庭住址
			cell = row.getCell(++cellNum);
			try {
				student.setFamilyLocation(cell.getStringCellValue());
			} catch (Exception e) {
				student.setFamilyLocation("");
			}
			
			// 邮政编码
			cell = row.getCell(++cellNum);
			try {
				student.setPostcode(cell.getStringCellValue());
			} catch (Exception e) {
				try{
					student.setPostcode(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setPostcode("");
				}
				
			}
			
			// 家庭联系电话
			cell = row.getCell(++cellNum);
			try {
				student.setTelOfFather(cell.getStringCellValue());
			} catch (Exception e) {
				try{
					student.setTelOfFather(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setTelOfFather("");
				}
				
			}
			cell = row.getCell(++cellNum);
			try {
				student.setTelOfMother(cell.getStringCellValue());
			} catch (Exception e) {
				try{
					student.setTelOfMother(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setTelOfMother("");
				}
				
			}
			
			// 生源省份
			cell = row.getCell(++cellNum);
			try{
				student.setProvince(cell.getStringCellValue());
			} catch (Exception e) {
				student.setProvince("");
			}
			// 学籍状态
			cell = row.getCell(++cellNum);
			try{
				student.setStudentStatus(cell.getStringCellValue());
			} catch (Exception e) {
				student.setStudentStatus("");
			}
			// 担任职务
			cell = row.getCell(++cellNum);
			try{
				student.setJob(cell.getStringCellValue());
			} catch (Exception e) {
				student.setJob("");
			}
			
			// 是否在校
			cell = row.getCell(++cellNum);
			try{
				student.setIsInSchool(cell.getStringCellValue().equals("是") ? true
						: false);
			} catch (Exception e) {
				student.setIsInSchool(true);
			}
			
			// 第一学年
			cell = row.getCell(++cellNum);
			try {
				student.setScore1((int)cell.getNumericCellValue());
			} catch (Exception e) {
				// 出错记录为0
				student.setScore1(0);
			}
			// 第二学年
			cell = row.getCell(++cellNum);
			try {
				student.setScore2((int)cell.getNumericCellValue());
			} catch (Exception e) {
				// 出错记录为0
				student.setScore2(0);
			}
			// 第三学年
			cell = row.getCell(++cellNum);
			try {
				student.setScore3((int)cell.getNumericCellValue());
			} catch (Exception e) {
				// 出错记录为0
				student.setScore3(0);
			}
			// 第四学年
			cell = row.getCell(++cellNum);
			try {
				student.setScore4((int)cell.getNumericCellValue());
			} catch (Exception e) {
				// 出错记录为0
				student.setScore4(0);
			}
			// 获奖情况
			cell = row.getCell(++cellNum);
			try{
				student.setReward(cell.getStringCellValue());
			} catch (Exception e) {
				student.setReward("");
			}
			
			// 班导师/导师
			cell = row.getCell(++cellNum);
			try {
				student.setTutor(cell.getStringCellValue());
			} catch (Exception e) {
				student.setTutor("");
			}
			
			// 培养层次
			cell = row.getCell(++cellNum);
			try {
				student.setEducationLevel(cell.getStringCellValue());
			} catch (Exception e) {
				student.setEducationLevel("");
			}
			// 学习年限
			cell = row.getCell(++cellNum);
			try {
				student.setStudentPeriod((int)cell.getNumericCellValue());
			} catch (Exception e) {
				try {
					student.setStudentPeriod(Integer.parseInt(cell.getStringCellValue()));
				} catch (Exception ex) {
					// 出错记录为0
					student.setStudentPeriod(0);
				}
			}
			// 学习形式
			cell = row.getCell(++cellNum);
			try {
				student.setStudyMode(cell.getStringCellValue());
			} catch (Exception e) {
				student.setStudyMode("");
			}
			// QQ号码
			cell = row.getCell(++cellNum);
			try {
				student.setQq(cell.getStringCellValue());
			} catch (Exception e) {
				try{
					student.setQq(String.valueOf(cell.getNumericCellValue()));
				} catch (Exception ex) {
					student.setQq("");
				}
			}
			
			// 邮箱
			cell = row.getCell(++cellNum);
			// 如果没有记录会出错，用try
			try{
				student.setEmail(cell.getStringCellValue());
			} catch (Exception e) {
				student.setEmail("");
			}
			
			
			student.setNote("");

			student.setPicture(student.getStudentId() + ".jpg");
			if (!getService().insertObjectForm(student))
				stuName.add(student.getName());
		}
		return stuName;
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}

}
