/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RaYHaN
 */
public class EmployeeInfo {
    
    String empFirstName;
    String empLasttName;
    String phnNum;
    String address;

    public EmployeeInfo() {
    }
    
    public EmployeeInfo(String empFirstName, String empLasttName, String phnNum, String address) {
        this.empFirstName = empFirstName;
        this.empLasttName = empLasttName;
        this.phnNum = phnNum;
        this.address = address;
    }
    


    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLasttName() {
        return empLasttName;
    }

    public void setEmpLasttName(String empLasttName) {
        this.empLasttName = empLasttName;
    }

    public String getPhnNum() {
        return phnNum;
    }

    public void setPhnNum(String phnNum) {
        this.phnNum = phnNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
