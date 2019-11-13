/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class EmpPaymentInfo {
    public int empId;
    public double salary;
    String date;
    String paymentMonth;
    String status;

    public EmpPaymentInfo() {
    }

    public EmpPaymentInfo(int empId, double salary, String date, String paymentMonth, String status) {
        this.empId = empId;
        this.salary = salary;
        this.date = date;
        this.paymentMonth = paymentMonth;
        this.status = status;
    }
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(String paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
   
}
