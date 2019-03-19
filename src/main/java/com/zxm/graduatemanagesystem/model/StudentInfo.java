package com.zxm.graduatemanagesystem.model;

public class StudentInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.id_num
     *
     * @mbggenerated
     */
    private String idNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.gender
     *
     * @mbggenerated
     */
    private Byte gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.nation
     *
     * @mbggenerated
     */
    private String nation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.institude
     *
     * @mbggenerated
     */
    private Byte institude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.profession
     *
     * @mbggenerated
     */
    private Byte profession;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.education
     *
     * @mbggenerated
     */
    private Byte education;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.student_class
     *
     * @mbggenerated
     */
    private String studentClass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_info.student_id
     *
     * @mbggenerated
     */
    private String studentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.id
     *
     * @return the value of student_info.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.id
     *
     * @param id the value for student_info.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.user_id
     *
     * @return the value of student_info.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.user_id
     *
     * @param userId the value for student_info.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.name
     *
     * @return the value of student_info.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.name
     *
     * @param name the value for student_info.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.id_num
     *
     * @return the value of student_info.id_num
     *
     * @mbggenerated
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.id_num
     *
     * @param idNum the value for student_info.id_num
     *
     * @mbggenerated
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.gender
     *
     * @return the value of student_info.gender
     *
     * @mbggenerated
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.gender
     *
     * @param gender the value for student_info.gender
     *
     * @mbggenerated
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.nation
     *
     * @return the value of student_info.nation
     *
     * @mbggenerated
     */
    public String getNation() {
        return nation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.nation
     *
     * @param nation the value for student_info.nation
     *
     * @mbggenerated
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.institude
     *
     * @return the value of student_info.institude
     *
     * @mbggenerated
     */
    public Byte getInstitude() {
        return institude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.institude
     *
     * @param institude the value for student_info.institude
     *
     * @mbggenerated
     */
    public void setInstitude(Byte institude) {
        this.institude = institude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.profession
     *
     * @return the value of student_info.profession
     *
     * @mbggenerated
     */
    public Byte getProfession() {
        return profession;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.profession
     *
     * @param profession the value for student_info.profession
     *
     * @mbggenerated
     */
    public void setProfession(Byte profession) {
        this.profession = profession;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.education
     *
     * @return the value of student_info.education
     *
     * @mbggenerated
     */
    public Byte getEducation() {
        return education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.education
     *
     * @param education the value for student_info.education
     *
     * @mbggenerated
     */
    public void setEducation(Byte education) {
        this.education = education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.phone
     *
     * @return the value of student_info.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.phone
     *
     * @param phone the value for student_info.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.student_class
     *
     * @return the value of student_info.student_class
     *
     * @mbggenerated
     */
    public String getStudentClass() {
        return studentClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.student_class
     *
     * @param studentClass the value for student_info.student_class
     *
     * @mbggenerated
     */
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_info.student_id
     *
     * @return the value of student_info.student_id
     *
     * @mbggenerated
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_info.student_id
     *
     * @param studentId the value for student_info.student_id
     *
     * @mbggenerated
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }
}