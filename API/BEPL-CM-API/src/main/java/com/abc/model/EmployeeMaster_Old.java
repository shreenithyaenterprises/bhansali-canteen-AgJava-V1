package com.abc.model;
/*package com.abc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Employee")
public class EmployeeMaster
{
	@Id
//	private String empcode;
	public String EMPCODE;
	public String COMMUNITYCODE;
	public String SITECODE;
	public String ESTABLISHMENTCODE;
	public String DIVISIONCODE;
	public String DEPTCODE;
	public String CATCODE;
	public String DESGCODE;
	public String GRADECODE;
	public String LEVGRPCODE;
	public String ENROLMENT_NUMBER;
	public String TITLE;
	public String FIRST_NAME;
	public String MIDDLE_NAME;
	public String LAST_NAME;
	public String NAME;
	public String FATHER_NAME;
	public Date BIRTHDATE;
	public String SEX;
	public String BLOOD_GROUP;
	public String PER_ADD1;
	public String PER_ADD2;
	public String PER_CITY;
	public String PER_STATE;
	public String PER_COUNTRY;
	public String PER_PINCODE;
	public String PER_TELEPHONE;
	public String CORR_ADD1;
	public String CORR_ADD2;
	public String CORR_CITY;
	public String CORR_STATE;
	public String CORR_COUNTRY;
	public String CORR_PINCODE;
	public String CORR_TELEPHONE;
	public String MOBILE;
	public String EMAIL;
	public String PAN_NO;
	public String UID_NO;
	public String VOTER_ID_CARD_NO;
	public String RASHAN_CARD_NO;
	public String DRIVING_LICENSE_NO;
	public Date JOINDATE;
	public Date CONFIRMDATE;
	public Date LEFTDATE;
	public String LEFTREMARK;
	public String EDQUAL;
	public String REPTTO;
	public String HOD;
	public String ADMIN;
	public String SHIFTTYPE;
	public String SHIFTCODE;
	public String RELAYCODE;
	public String AUTO_SHIFT_RANGE;
	public Date STARTDATE;
	public String WEEKOFF1;
	public Integer WEEKS1_1;
	public Integer WEEKS1_2;
	public Integer WEEKS1_3;
	public Integer WEEKS1_4;
	public Integer WEEKS1_5;
	public String WEEKOFF2;
	public Integer WEEKS2_1;
	public Integer WEEKS2_2;
	public Integer WEEKS2_3;
	public Integer WEEKS2_4;
	public Integer WEEKS2_5;
	public String HFWEEKOFF;
	public Integer HFWEEKS1;
	public Integer HFWEEKS2;
	public Integer HFWEEKS3;
	public Integer HFWEEKS4;
	public Integer HFWEEKS5;
	public Integer LATEFLAG;
	public Integer EARLYFLAG;
	public Integer OVERTIMEFLAG;
	public Integer ADJUST_OT;
	public Integer SINGLEPUNCH;
	public Integer COMPOFF;
	public Integer ALLPRE;
	public String PHOTOPATH;
	public Integer PF_FLAG;
	public String PF_NO;
	public Integer ESIC_FLAG;
	public String ESIC_NO;
	public String PHOTO;
	public String OLDEMPCODE;
	public String NEWEMPCODE;
	public String CREATED_USER;
	public Date CREATED_DATE;
	public String MODIFIED_USER;
	public Date MODIFIED_DATE;
	public String POSITIONCODE;
	public String OT_SH;
	public String OT_DH;
	public String OT_Admin;

	public String getEMPCODE()
	{
		return EMPCODE;
	}
	public void setEMPCODE(String eMPCODE)
	{
		EMPCODE = eMPCODE;
	}
	public String getCOMMUNITYCODE()
	{
		return COMMUNITYCODE;
	}
	public void setCOMMUNITYCODE(String cOMMUNITYCODE)
	{
		COMMUNITYCODE = cOMMUNITYCODE;
	}
	public String getSITECODE()
	{
		return SITECODE;
	}
	public void setSITECODE(String sITECODE)
	{
		SITECODE = sITECODE;
	}
	public String getESTABLISHMENTCODE()
	{
		return ESTABLISHMENTCODE;
	}
	public void setESTABLISHMENTCODE(String eSTABLISHMENTCODE)
	{
		ESTABLISHMENTCODE = eSTABLISHMENTCODE;
	}
	public String getDIVISIONCODE()
	{
		return DIVISIONCODE;
	}
	public void setDIVISIONCODE(String dIVISIONCODE)
	{
		DIVISIONCODE = dIVISIONCODE;
	}
	public String getDEPTCODE()
	{
		return DEPTCODE;
	}
	public void setDEPTCODE(String dEPTCODE)
	{
		DEPTCODE = dEPTCODE;
	}
	public String getCATCODE()
	{
		return CATCODE;
	}
	public void setCATCODE(String cATCODE)
	{
		CATCODE = cATCODE;
	}
	public String getDESGCODE()
	{
		return DESGCODE;
	}
	public void setDESGCODE(String dESGCODE)
	{
		DESGCODE = dESGCODE;
	}
	public String getGRADECODE()
	{
		return GRADECODE;
	}
	public void setGRADECODE(String gRADECODE)
	{
		GRADECODE = gRADECODE;
	}
	public String getLEVGRPCODE()
	{
		return LEVGRPCODE;
	}
	public void setLEVGRPCODE(String lEVGRPCODE)
	{
		LEVGRPCODE = lEVGRPCODE;
	}
	public String getENROLMENT_NUMBER()
	{
		return ENROLMENT_NUMBER;
	}
	public void setENROLMENT_NUMBER(String eNROLMENT_NUMBER)
	{
		ENROLMENT_NUMBER = eNROLMENT_NUMBER;
	}
	public String getTITLE()
	{
		return TITLE;
	}
	public void setTITLE(String tITLE)
	{
		TITLE = tITLE;
	}
	public String getFIRST_NAME()
	{
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME)
	{
		FIRST_NAME = fIRST_NAME;
	}
	public String getMIDDLE_NAME()
	{
		return MIDDLE_NAME;
	}
	public void setMIDDLE_NAME(String mIDDLE_NAME)
	{
		MIDDLE_NAME = mIDDLE_NAME;
	}
	public String getLAST_NAME()
	{
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME)
	{
		LAST_NAME = lAST_NAME;
	}
	public String getNAME()
	{
		return NAME;
	}
	public void setNAME(String nAME)
	{
		NAME = nAME;
	}
	public String getFATHER_NAME()
	{
		return FATHER_NAME;
	}
	public void setFATHER_NAME(String fATHER_NAME)
	{
		FATHER_NAME = fATHER_NAME;
	}
	public Date getBIRTHDATE()
	{
		return BIRTHDATE;
	}
	public void setBIRTHDATE(Date bIRTHDATE)
	{
		BIRTHDATE = bIRTHDATE;
	}
	public String getSEX()
	{
		return SEX;
	}
	public void setSEX(String sEX)
	{
		SEX = sEX;
	}
	public String getBLOOD_GROUP()
	{
		return BLOOD_GROUP;
	}
	public void setBLOOD_GROUP(String bLOOD_GROUP)
	{
		BLOOD_GROUP = bLOOD_GROUP;
	}
	public String getPER_ADD1()
	{
		return PER_ADD1;
	}
	public void setPER_ADD1(String pER_ADD1)
	{
		PER_ADD1 = pER_ADD1;
	}
	public String getPER_ADD2()
	{
		return PER_ADD2;
	}
	public void setPER_ADD2(String pER_ADD2)
	{
		PER_ADD2 = pER_ADD2;
	}
	public String getPER_CITY()
	{
		return PER_CITY;
	}
	public void setPER_CITY(String pER_CITY)
	{
		PER_CITY = pER_CITY;
	}
	public String getPER_STATE()
	{
		return PER_STATE;
	}
	public void setPER_STATE(String pER_STATE)
	{
		PER_STATE = pER_STATE;
	}
	public String getPER_COUNTRY()
	{
		return PER_COUNTRY;
	}
	public void setPER_COUNTRY(String pER_COUNTRY)
	{
		PER_COUNTRY = pER_COUNTRY;
	}
	public String getPER_PINCODE()
	{
		return PER_PINCODE;
	}
	public void setPER_PINCODE(String pER_PINCODE)
	{
		PER_PINCODE = pER_PINCODE;
	}
	public String getPER_TELEPHONE()
	{
		return PER_TELEPHONE;
	}
	public void setPER_TELEPHONE(String pER_TELEPHONE)
	{
		PER_TELEPHONE = pER_TELEPHONE;
	}
	public String getCORR_ADD1()
	{
		return CORR_ADD1;
	}
	public void setCORR_ADD1(String cORR_ADD1)
	{
		CORR_ADD1 = cORR_ADD1;
	}
	public String getCORR_ADD2()
	{
		return CORR_ADD2;
	}
	public void setCORR_ADD2(String cORR_ADD2)
	{
		CORR_ADD2 = cORR_ADD2;
	}
	public String getCORR_CITY()
	{
		return CORR_CITY;
	}
	public void setCORR_CITY(String cORR_CITY)
	{
		CORR_CITY = cORR_CITY;
	}
	public String getCORR_STATE()
	{
		return CORR_STATE;
	}
	public void setCORR_STATE(String cORR_STATE)
	{
		CORR_STATE = cORR_STATE;
	}
	public String getCORR_COUNTRY()
	{
		return CORR_COUNTRY;
	}
	public void setCORR_COUNTRY(String cORR_COUNTRY)
	{
		CORR_COUNTRY = cORR_COUNTRY;
	}
	public String getCORR_PINCODE()
	{
		return CORR_PINCODE;
	}
	public void setCORR_PINCODE(String cORR_PINCODE)
	{
		CORR_PINCODE = cORR_PINCODE;
	}
	public String getCORR_TELEPHONE()
	{
		return CORR_TELEPHONE;
	}
	public void setCORR_TELEPHONE(String cORR_TELEPHONE)
	{
		CORR_TELEPHONE = cORR_TELEPHONE;
	}
	public String getMOBILE()
	{
		return MOBILE;
	}
	public void setMOBILE(String mOBILE)
	{
		MOBILE = mOBILE;
	}
	public String getEMAIL()
	{
		return EMAIL;
	}
	public void setEMAIL(String eMAIL)
	{
		EMAIL = eMAIL;
	}
	public String getPAN_NO()
	{
		return PAN_NO;
	}
	public void setPAN_NO(String pAN_NO)
	{
		PAN_NO = pAN_NO;
	}
	public String getUID_NO()
	{
		return UID_NO;
	}
	public void setUID_NO(String uID_NO)
	{
		UID_NO = uID_NO;
	}
	public String getVOTER_ID_CARD_NO()
	{
		return VOTER_ID_CARD_NO;
	}
	public void setVOTER_ID_CARD_NO(String vOTER_ID_CARD_NO)
	{
		VOTER_ID_CARD_NO = vOTER_ID_CARD_NO;
	}
	public String getRASHAN_CARD_NO()
	{
		return RASHAN_CARD_NO;
	}
	public void setRASHAN_CARD_NO(String rASHAN_CARD_NO)
	{
		RASHAN_CARD_NO = rASHAN_CARD_NO;
	}
	public String getDRIVING_LICENSE_NO()
	{
		return DRIVING_LICENSE_NO;
	}
	public void setDRIVING_LICENSE_NO(String dRIVING_LICENSE_NO)
	{
		DRIVING_LICENSE_NO = dRIVING_LICENSE_NO;
	}
	public Date getJOINDATE()
	{
		return JOINDATE;
	}
	public void setJOINDATE(Date jOINDATE)
	{
		JOINDATE = jOINDATE;
	}
	public Date getCONFIRMDATE()
	{
		return CONFIRMDATE;
	}
	public void setCONFIRMDATE(Date cONFIRMDATE)
	{
		CONFIRMDATE = cONFIRMDATE;
	}
	public Date getLEFTDATE()
	{
		return LEFTDATE;
	}
	public void setLEFTDATE(Date lEFTDATE)
	{
		LEFTDATE = lEFTDATE;
	}
	public String getLEFTREMARK()
	{
		return LEFTREMARK;
	}
	public void setLEFTREMARK(String lEFTREMARK)
	{
		LEFTREMARK = lEFTREMARK;
	}
	public String getEDQUAL()
	{
		return EDQUAL;
	}
	public void setEDQUAL(String eDQUAL)
	{
		EDQUAL = eDQUAL;
	}
	public String getREPTTO()
	{
		return REPTTO;
	}
	public void setREPTTO(String rEPTTO)
	{
		REPTTO = rEPTTO;
	}
	public String getHOD()
	{
		return HOD;
	}
	public void setHOD(String hOD)
	{
		HOD = hOD;
	}
	public String getADMIN()
	{
		return ADMIN;
	}
	public void setADMIN(String aDMIN)
	{
		ADMIN = aDMIN;
	}
	public String getSHIFTTYPE()
	{
		return SHIFTTYPE;
	}
	public void setSHIFTTYPE(String sHIFTTYPE)
	{
		SHIFTTYPE = sHIFTTYPE;
	}
	public String getSHIFTCODE()
	{
		return SHIFTCODE;
	}
	public void setSHIFTCODE(String sHIFTCODE)
	{
		SHIFTCODE = sHIFTCODE;
	}
	public String getRELAYCODE()
	{
		return RELAYCODE;
	}
	public void setRELAYCODE(String rELAYCODE)
	{
		RELAYCODE = rELAYCODE;
	}
	public String getAUTO_SHIFT_RANGE()
	{
		return AUTO_SHIFT_RANGE;
	}
	public void setAUTO_SHIFT_RANGE(String aUTO_SHIFT_RANGE)
	{
		AUTO_SHIFT_RANGE = aUTO_SHIFT_RANGE;
	}
	public Date getSTARTDATE()
	{
		return STARTDATE;
	}
	public void setSTARTDATE(Date sTARTDATE)
	{
		STARTDATE = sTARTDATE;
	}
	public String getWEEKOFF1()
	{
		return WEEKOFF1;
	}
	public void setWEEKOFF1(String wEEKOFF1)
	{
		WEEKOFF1 = wEEKOFF1;
	}
	public Integer getWEEKS1_1()
	{
		return WEEKS1_1;
	}
	public void setWEEKS1_1(Integer wEEKS1_1)
	{
		WEEKS1_1 = wEEKS1_1;
	}
	public Integer getWEEKS1_2()
	{
		return WEEKS1_2;
	}
	public void setWEEKS1_2(Integer wEEKS1_2)
	{
		WEEKS1_2 = wEEKS1_2;
	}
	public Integer getWEEKS1_3()
	{
		return WEEKS1_3;
	}
	public void setWEEKS1_3(Integer wEEKS1_3)
	{
		WEEKS1_3 = wEEKS1_3;
	}
	public Integer getWEEKS1_4()
	{
		return WEEKS1_4;
	}
	public void setWEEKS1_4(Integer wEEKS1_4)
	{
		WEEKS1_4 = wEEKS1_4;
	}
	public Integer getWEEKS1_5()
	{
		return WEEKS1_5;
	}
	public void setWEEKS1_5(Integer wEEKS1_5)
	{
		WEEKS1_5 = wEEKS1_5;
	}
	public String getWEEKOFF2()
	{
		return WEEKOFF2;
	}
	public void setWEEKOFF2(String wEEKOFF2)
	{
		WEEKOFF2 = wEEKOFF2;
	}
	public Integer getWEEKS2_1()
	{
		return WEEKS2_1;
	}
	public void setWEEKS2_1(Integer wEEKS2_1)
	{
		WEEKS2_1 = wEEKS2_1;
	}
	public Integer getWEEKS2_2()
	{
		return WEEKS2_2;
	}
	public void setWEEKS2_2(Integer wEEKS2_2)
	{
		WEEKS2_2 = wEEKS2_2;
	}
	public Integer getWEEKS2_3()
	{
		return WEEKS2_3;
	}
	public void setWEEKS2_3(Integer wEEKS2_3)
	{
		WEEKS2_3 = wEEKS2_3;
	}
	public Integer getWEEKS2_4()
	{
		return WEEKS2_4;
	}
	public void setWEEKS2_4(Integer wEEKS2_4)
	{
		WEEKS2_4 = wEEKS2_4;
	}
	public Integer getWEEKS2_5()
	{
		return WEEKS2_5;
	}
	public void setWEEKS2_5(Integer wEEKS2_5)
	{
		WEEKS2_5 = wEEKS2_5;
	}
	public String getHFWEEKOFF()
	{
		return HFWEEKOFF;
	}
	public void setHFWEEKOFF(String hFWEEKOFF)
	{
		HFWEEKOFF = hFWEEKOFF;
	}
	public Integer getHFWEEKS1()
	{
		return HFWEEKS1;
	}
	public void setHFWEEKS1(Integer hFWEEKS1)
	{
		HFWEEKS1 = hFWEEKS1;
	}
	public Integer getHFWEEKS2()
	{
		return HFWEEKS2;
	}
	public void setHFWEEKS2(Integer hFWEEKS2)
	{
		HFWEEKS2 = hFWEEKS2;
	}
	public Integer getHFWEEKS3()
	{
		return HFWEEKS3;
	}
	public void setHFWEEKS3(Integer hFWEEKS3)
	{
		HFWEEKS3 = hFWEEKS3;
	}
	public Integer getHFWEEKS4()
	{
		return HFWEEKS4;
	}
	public void setHFWEEKS4(Integer hFWEEKS4)
	{
		HFWEEKS4 = hFWEEKS4;
	}
	public Integer getHFWEEKS5()
	{
		return HFWEEKS5;
	}
	public void setHFWEEKS5(Integer hFWEEKS5)
	{
		HFWEEKS5 = hFWEEKS5;
	}
	public Integer getLATEFLAG()
	{
		return LATEFLAG;
	}
	public void setLATEFLAG(Integer lATEFLAG)
	{
		LATEFLAG = lATEFLAG;
	}
	public Integer getEARLYFLAG()
	{
		return EARLYFLAG;
	}
	public void setEARLYFLAG(Integer eARLYFLAG)
	{
		EARLYFLAG = eARLYFLAG;
	}
	public Integer getOVERTIMEFLAG()
	{
		return OVERTIMEFLAG;
	}
	public void setOVERTIMEFLAG(Integer oVERTIMEFLAG)
	{
		OVERTIMEFLAG = oVERTIMEFLAG;
	}
	public Integer getADJUST_OT()
	{
		return ADJUST_OT;
	}
	public void setADJUST_OT(Integer aDJUST_OT)
	{
		ADJUST_OT = aDJUST_OT;
	}
	public Integer getSINGLEPUNCH()
	{
		return SINGLEPUNCH;
	}
	public void setSINGLEPUNCH(Integer sINGLEPUNCH)
	{
		SINGLEPUNCH = sINGLEPUNCH;
	}
	public Integer getCOMPOFF()
	{
		return COMPOFF;
	}
	public void setCOMPOFF(Integer cOMPOFF)
	{
		COMPOFF = cOMPOFF;
	}
	public Integer getALLPRE()
	{
		return ALLPRE;
	}
	public void setALLPRE(Integer aLLPRE)
	{
		ALLPRE = aLLPRE;
	}
	public String getPHOTOPATH()
	{
		return PHOTOPATH;
	}
	public void setPHOTOPATH(String pHOTOPATH)
	{
		PHOTOPATH = pHOTOPATH;
	}
	public Integer getPF_FLAG()
	{
		return PF_FLAG;
	}
	public void setPF_FLAG(Integer pF_FLAG)
	{
		PF_FLAG = pF_FLAG;
	}
	public String getPF_NO()
	{
		return PF_NO;
	}
	public void setPF_NO(String pF_NO)
	{
		PF_NO = pF_NO;
	}
	public Integer getESIC_FLAG()
	{
		return ESIC_FLAG;
	}
	public void setESIC_FLAG(Integer eSIC_FLAG)
	{
		ESIC_FLAG = eSIC_FLAG;
	}
	public String getESIC_NO()
	{
		return ESIC_NO;
	}
	public void setESIC_NO(String eSIC_NO)
	{
		ESIC_NO = eSIC_NO;
	}
	public String getPHOTO()
	{
		return PHOTO;
	}
	public void setPHOTO(String pHOTO)
	{
		PHOTO = pHOTO;
	}
	public String getOLDEMPCODE()
	{
		return OLDEMPCODE;
	}
	public void setOLDEMPCODE(String oLDEMPCODE)
	{
		OLDEMPCODE = oLDEMPCODE;
	}
	public String getNEWEMPCODE()
	{
		return NEWEMPCODE;
	}
	public void setNEWEMPCODE(String nEWEMPCODE)
	{
		NEWEMPCODE = nEWEMPCODE;
	}
	public String getCREATED_USER()
	{
		return CREATED_USER;
	}
	public void setCREATED_USER(String cREATED_USER)
	{
		CREATED_USER = cREATED_USER;
	}
	public Date getCREATED_DATE()
	{
		return CREATED_DATE;
	}
	public void setCREATED_DATE(Date cREATED_DATE)
	{
		CREATED_DATE = cREATED_DATE;
	}
	public String getMODIFIED_USER()
	{
		return MODIFIED_USER;
	}
	public void setMODIFIED_USER(String mODIFIED_USER)
	{
		MODIFIED_USER = mODIFIED_USER;
	}
	public Date getMODIFIED_DATE()
	{
		return MODIFIED_DATE;
	}
	public void setMODIFIED_DATE(Date mODIFIED_DATE)
	{
		MODIFIED_DATE = mODIFIED_DATE;
	}
	public String getPOSITIONCODE()
	{
		return POSITIONCODE;
	}
	public void setPOSITIONCODE(String pOSITIONCODE)
	{
		POSITIONCODE = pOSITIONCODE;
	}
	public String getOT_SH()
	{
		return OT_SH;
	}
	public void setOT_SH(String oT_SH)
	{
		OT_SH = oT_SH;
	}
	public String getOT_DH()
	{
		return OT_DH;
	}
	public void setOT_DH(String oT_DH)
	{
		OT_DH = oT_DH;
	}
	public String getOT_Admin()
	{
		return OT_Admin;
	}
	public void setOT_Admin(String oT_Admin)
	{
		OT_Admin = oT_Admin;
	}


}
*/