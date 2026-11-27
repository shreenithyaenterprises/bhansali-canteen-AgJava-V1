package com.abc.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

public class payloadBean
{
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String code;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String areacode;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String shiftcode;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String contcode;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String deptcode;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String emp_code;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30")
	private String date;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30")
	private String from_date;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30")
	private String to_date;	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30")
	private String status;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String meal;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String site;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String catcode;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String role;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private Integer month;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private Integer year;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAreacode()
	{
		return areacode;
	}
	public void setAreacode(String areacode)
	{
		this.areacode = areacode;
	}
	public String getShiftcode()
	{
		return shiftcode;
	}
	public void setShiftcode(String shiftcode)
	{
		this.shiftcode = shiftcode;
	}
	public String getContcode()
	{
		return contcode;
	}
	public void setContcode(String contcode)
	{
		this.contcode = contcode;
	}
	public String getDeptcode()
	{
		return deptcode;
	}
	public void setDeptcode(String deptcode)
	{
		this.deptcode = deptcode;
	}
	
	public String getEmp_code()
	{
		return emp_code;
	}
	public void setEmp_code(String emp_code)
	{
		this.emp_code = emp_code;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getFrom_date()
	{
		return from_date;
	}
	public void setFrom_date(String from_date)
	{
		this.from_date = from_date;
	}
	public String getTo_date()
	{
		return to_date;
	}
	public void setTo_date(String to_date)
	{
		this.to_date = to_date;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getCatcode() {
		return catcode;
	}
	public void setCatcode(String catcode) {
		this.catcode = catcode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "payloadBean [code=" + code + ", areacode=" + areacode + ", shiftcode=" + shiftcode + ", contcode="
				+ contcode + ", deptcode=" + deptcode + ", emp_code=" + emp_code + ", date=" + date + ", from_date="
				+ from_date + ", to_date=" + to_date + ", status=" + status + ", meal=" + meal + ", site=" + site
				+ ", catcode=" + catcode + ", month=" + month + ", year=" + year + "]";
	}
}
