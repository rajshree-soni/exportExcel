package ExcelImport;

import java.util.Date;

public class StudentExcel
{
	String admissionNO,studentName,stuclass,session,rollNo,statusType,aadharNo,mobNo,CurrentAdr,PermanentAddr,gender,nationality,religion,category,caste,bplStatus,pincode,singleParent,singleChild,country,fatherName,motherName,fatherEmail,fatherUuid,motherEmail,motherUuid,motherNo,residenceNm,liveWithParents,
	lastSchool,passesClass,medium,result,board,prcntage,reasontoLeave,height,weight,eyes,bloodGroup,guardianName1,relation1,occupation1,number1,address1,guardianName2,relation2,occupation2,number2,address2,faQualification,fasOccupation,faofficeContact,faofficeAddr,faIsSchoolEmploy,maQualification,masOccupation,maofficeContact,maofficeAddr,maIsSchoolEmploy,
	route,routeFee,discountFee,totalFee,concession,hostler,house,sibling1,sibClass1,sibling2,sibClass2,bplNo,statusStu,admitClass;
	String state,tehsil,district;
	
	int dateDob,monthDob,yearDob,dateAdmission,monthAdmission,yearAdmission;
	
	String strDob,TCDate;
	String strAdd;
	
	String srNo;
	
	
	public String getAdmitClass() {
		return admitClass;
	}
	public void setAdmitClass(String admitClass) {
		this.admitClass = admitClass;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	public String getStatusStu() {
		return statusStu;
	}
	public void setStatusStu(String statusStu) {
		this.statusStu = statusStu;
	}
	public String getBplNo() {
		return bplNo;
	}
	public void setBplNo(String bplNo) {
		this.bplNo = bplNo;
	}
	public String getFaQualification() {
		return faQualification;
	}
	public void setFaQualification(String faQualification) {
		this.faQualification = faQualification;
	}
	public String getMaQualification() {
		return maQualification;
	}
	public void setMaQualification(String maQualification) {
		this.maQualification = maQualification;
	}
	public String getStrDob() {
		return strDob;
	}
	public void setStrDob(String strDob) {
		this.strDob = strDob;
	}
	public String getStrAdd() {
		return strAdd;
	}
	public void setStrAdd(String strAdd) {
		this.strAdd = strAdd;
	}
	
	public String getAdmissionNO() {
		return admissionNO;
	}
	public void setAdmissionNO(String admissionNO) {
		this.admissionNO = admissionNO;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public int getDateDob() {
		return dateDob;
	}
	public void setDateDob(int dateDob) {
		this.dateDob = dateDob;
	}
	public int getMonthDob() {
		return monthDob;
	}
	public void setMonthDob(int monthDob) {
		this.monthDob = monthDob;
	}
	public int getYearDob() {
		return yearDob;
	}
	public void setYearDob(int yearDob) {
		this.yearDob = yearDob;
	}
	public int getDateAdmission() {
		return dateAdmission;
	}
	public void setDateAdmission(int dateAdmission) {
		this.dateAdmission = dateAdmission;
	}
	public int getMonthAdmission() {
		return monthAdmission;
	}
	public void setMonthAdmission(int monthAdmission) {
		this.monthAdmission = monthAdmission;
	}
	public int getYearAdmission() {
		return yearAdmission;
	}
	public void setYearAdmission(int yearAdmission) {
		this.yearAdmission = yearAdmission;
	}
	
	public String getStuclass() {
		return stuclass;
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getCurrentAdr() {
		return CurrentAdr;
	}
	public void setCurrentAdr(String currentAdr) {
		CurrentAdr = currentAdr;
	}
	public String getPermanentAddr() {
		return PermanentAddr;
	}
	public void setPermanentAddr(String permanentAddr) {
		PermanentAddr = permanentAddr;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getBplStatus() {
		return bplStatus;
	}
	public void setBplStatus(String bplStatus) {
		this.bplStatus = bplStatus;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getSingleParent() {
		return singleParent;
	}
	public void setSingleParent(String singleParent) {
		this.singleParent = singleParent;
	}
	public String getSingleChild() {
		return singleChild;
	}
	public void setSingleChild(String singleChild) {
		this.singleChild = singleChild;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherEmail() {
		return fatherEmail;
	}
	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}
	public String getFatherUuid() {
		return fatherUuid;
	}
	public void setFatherUuid(String fatherUuid) {
		this.fatherUuid = fatherUuid;
	}
	public String getMotherEmail() {
		return motherEmail;
	}
	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}
	public String getMotherUuid() {
		return motherUuid;
	}
	public void setMotherUuid(String motherUuid) {
		this.motherUuid = motherUuid;
	}
	public String getMotherNo() {
		return motherNo;
	}
	public void setMotherNo(String motherNo) {
		this.motherNo = motherNo;
	}
	public String getResidenceNm() {
		return residenceNm;
	}
	public void setResidenceNm(String residenceNm) {
		this.residenceNm = residenceNm;
	}
	public String getLiveWithParents() {
		return liveWithParents;
	}
	public void setLiveWithParents(String liveWithParents) {
		this.liveWithParents = liveWithParents;
	}
	public String getLastSchool() {
		return lastSchool;
	}
	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}
	public String getPassesClass() {
		return passesClass;
	}
	public void setPassesClass(String passesClass) {
		this.passesClass = passesClass;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getPrcntage() {
		return prcntage;
	}
	public void setPrcntage(String prcntage) {
		this.prcntage = prcntage;
	}
	public String getReasontoLeave() {
		return reasontoLeave;
	}
	public void setReasontoLeave(String reasontoLeave) {
		this.reasontoLeave = reasontoLeave;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getEyes() {
		return eyes;
	}
	public void setEyes(String eyes) {
		this.eyes = eyes;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getGuardianName1() {
		return guardianName1;
	}
	public void setGuardianName1(String guardianName1) {
		this.guardianName1 = guardianName1;
	}
	public String getRelation1() {
		return relation1;
	}
	public void setRelation1(String relation1) {
		this.relation1 = relation1;
	}
	public String getOccupation1() {
		return occupation1;
	}
	public void setOccupation1(String occupation1) {
		this.occupation1 = occupation1;
	}
	public String getNumber1() {
		return number1;
	}
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getGuardianName2() {
		return guardianName2;
	}
	public void setGuardianName2(String guardianName2) {
		this.guardianName2 = guardianName2;
	}
	public String getRelation2() {
		return relation2;
	}
	public void setRelation2(String relation2) {
		this.relation2 = relation2;
	}
	public String getOccupation2() {
		return occupation2;
	}
	public void setOccupation2(String occupation2) {
		this.occupation2 = occupation2;
	}
	public String getNumber2() {
		return number2;
	}
	public void setNumber2(String number2) {
		this.number2 = number2;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getFasOccupation() {
		return fasOccupation;
	}
	public void setFasOccupation(String fasOccupation) {
		this.fasOccupation = fasOccupation;
	}
	public String getFaofficeContact() {
		return faofficeContact;
	}
	public void setFaofficeContact(String faofficeContact) {
		this.faofficeContact = faofficeContact;
	}
	public String getFaofficeAddr() {
		return faofficeAddr;
	}
	public void setFaofficeAddr(String faofficeAddr) {
		this.faofficeAddr = faofficeAddr;
	}
	public String getFaIsSchoolEmploy() {
		return faIsSchoolEmploy;
	}
	public void setFaIsSchoolEmploy(String faIsSchoolEmploy) {
		this.faIsSchoolEmploy = faIsSchoolEmploy;
	}
	public String getMasOccupation() {
		return masOccupation;
	}
	public void setMasOccupation(String masOccupation) {
		this.masOccupation = masOccupation;
	}
	public String getMaofficeContact() {
		return maofficeContact;
	}
	public void setMaofficeContact(String maofficeContact) {
		this.maofficeContact = maofficeContact;
	}
	public String getMaofficeAddr() {
		return maofficeAddr;
	}
	public void setMaofficeAddr(String maofficeAddr) {
		this.maofficeAddr = maofficeAddr;
	}
	public String getMaIsSchoolEmploy() {
		return maIsSchoolEmploy;
	}
	public void setMaIsSchoolEmploy(String maIsSchoolEmploy) {
		this.maIsSchoolEmploy = maIsSchoolEmploy;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getRouteFee() {
		return routeFee;
	}
	public void setRouteFee(String routeFee) {
		this.routeFee = routeFee;
	}
	public String getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(String discountFee) {
		this.discountFee = discountFee;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getConcession() {
		return concession;
	}
	public void setConcession(String concession) {
		this.concession = concession;
	}
	public String getHostler() {
		return hostler;
	}
	public void setHostler(String hostler) {
		this.hostler = hostler;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getSibling1() {
		return sibling1;
	}
	public void setSibling1(String sibling1) {
		this.sibling1 = sibling1;
	}
	public String getSibClass1() {
		return sibClass1;
	}
	public void setSibClass1(String sibClass1) {
		this.sibClass1 = sibClass1;
	}
	public String getSibling2() {
		return sibling2;
	}
	public void setSibling2(String sibling2) {
		this.sibling2 = sibling2;
	}
	public String getSibClass2() {
		return sibClass2;
	}
	public void setSibClass2(String sibClass2) {
		this.sibClass2 = sibClass2;
	}
	public String getTCDate() {
		return TCDate;
	}
	public void setTCDate(String tCDate) {
		TCDate = tCDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTehsil() {
		return tehsil;
	}
	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	

	
	
	
}