package com.hibernate.annotation.entity;

/**
 * Created by amanurat on 11/17/14 AD.
 */
public class Address {

    Integer id;

    String soi;

    String street;

    String district;

    String province;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("id=").append(id);
        sb.append(", soi='").append(soi).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
