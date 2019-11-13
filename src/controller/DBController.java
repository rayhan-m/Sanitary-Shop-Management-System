/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Statement;
import java.io.DataInput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.swing.JOptionPane;
import model.CompanyInfo;
import model.EmpPaymentInfo;
import model.EmployeeInfo;
import model.ProductInfo;
import model.stockInfo;


/**
 *
 * @author RaYHaN
 */

public class DBController {
    public Statement statement;
    Connection connection;
    private JRootPane rootPane;
   
    
    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/zihad_enterprise", "root", "");

            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void queryUpdateExecutor(String sqlCommand) {
        openConnection();
        try {
            statement.executeUpdate(sqlCommand);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ////////products//////
    public ProductInfo searchProductInfo(String ProductName) {
        openConnection();
        ProductInfo pi = null;
        try {
            String sql = "select* from product_info where product_name='" + ProductName + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                pi = new ProductInfo(rs.getString("product_name"), rs.getString("company_name"), rs.getString("description"));
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pi;
    }
    
    /////company////
     public CompanyInfo searchCompanyInfo(String CompanyName) {
        openConnection();
        CompanyInfo ci = null;
        try {
            String sql = "select* from company_info where company_name='" + CompanyName + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                ci = new CompanyInfo(rs.getString("company_name"), rs.getString("email"), rs.getString("website"));
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ci;
    }
    
    
     public stockInfo searchStockInfo(String ProductId) {
        openConnection();
        stockInfo si = null;
        try {
            String sql = "select* from stock where product_id='" + ProductId + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                si = new stockInfo(rs.getInt("product_id"), rs.getDouble("unit_price"), rs.getDouble("sell_price"),rs.getInt("quantity"), rs.getDouble("total_cost"),rs.getString("in_date"));
//                si = new stockInfo(rs.getInt("product_id"), rs.getDouble("unit_price"), rs.getDouble("sell_price"), rs.getInt("quantity"),rs.getString("in_date"));
//        si = new stockInfo(rs.getString("product_id"), rs.getString("unit_price"), rs.getString("sell_price"), rs.getString("quantity"),rs.getString("in_date"));
                System.out.println("Yes");
            }
            connection.close();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        return si;
    }
     
     ////search EmpPay////
     public EmpPaymentInfo searchPayInfo(String EmpId) {
        openConnection();
        EmpPaymentInfo ei = null;
        try {
            String sql = "select* from emp_payment where emp_id='" + EmpId + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                ei = new EmpPaymentInfo(rs.getInt("emp_id"), rs.getDouble("salary"), rs.getString("pay_date"),rs.getString("payment_month"), rs.getString("status"));
//        si = new stockInfo(rs.getString("product_id"), rs.getString("unit_price"), rs.getString("sell_price"), rs.getString("quantity"),rs.getString("in_date"));
                System.out.println("Yes");
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ei;
    }
    
    public void insertProducts(ProductInfo pi){
        String sql="insert into product_info (product_name, company_name, description) values('"+pi.getProductName()+"','"+pi.getCompanyName()+"','"+pi.getDescription()+"')";
        queryUpdateExecutor(sql);
         JOptionPane.showMessageDialog(rootPane, "Product Information Insert Successfully ");
    }
    public void updateProducts(ProductInfo pi){
        String sql="Update product_info set product_name= '"+pi.getProductName()+"',company_name='"+pi.getCompanyName()+"',description='"+pi.getDescription()+"' where product_name='"+pi.getProductName()+"'";
        queryUpdateExecutor(sql);
        JOptionPane.showMessageDialog(rootPane, "Product Information Updated Successfully");
    }
    ///////Company Info////////
    public void insertCompany(CompanyInfo ci){
        String sql="insert into company_info values('"+ci.getCompanyName()+"','"+ci.getEmail()+"','"+ci.getWebsite()+"')";
        queryUpdateExecutor(sql);
         JOptionPane.showMessageDialog(rootPane, "Company Insert Successfully");
    }
    public void updateCompany(CompanyInfo ci){
        String sql="Update company_info set email= '"+ci.getEmail()+"',website='"+ci.getWebsite()+"' where company_name='"+ci.getCompanyName()+"'";
        queryUpdateExecutor(sql);
         JOptionPane.showMessageDialog(rootPane, "Company Information Updated Successfully");
    }
    public void deleteCompany(CompanyInfo ci) throws SQLException{

        statement = connection.createStatement();
      String sql = "DELETE FROM company_info " +
                   "company_name='"+ci.getCompanyName()+"'";
      statement.executeUpdate(sql);
        ////
        queryUpdateExecutor(sql);
         JOptionPane.showMessageDialog(rootPane, "Company Deleted Successfully");
    }
    
    /////stock//////
        public void insertStock(stockInfo si){
    
                String sql="insert into stock (product_id,unit_price,sell_price,quantity,total_cost,in_date) values('"+si.getProductId()+"',"+si.getUnitPrice()+","+si.getSellPrice()+","+si.getQuantity()+","+si.getTotalCost()+",'"+si.getDate()+"')";
                queryUpdateExecutor(sql);
                JOptionPane.showMessageDialog(rootPane, "Product Successfully Stored in the Stock");
    }  
    //////////Employee/////////
         public void insertEmployee(EmployeeInfo ei){
            String sql="insert into employee_info (emp_firstname, emp_lastname, phn_num, address) values('"+ei.getEmpFirstName()+"','"+ei.getEmpLasttName()+"','"+ei.getPhnNum()+"','"+ei.getAddress()+"')";
            queryUpdateExecutor(sql);
             JOptionPane.showMessageDialog(rootPane, "New Employee Successfully Stored");
    }
        public EmployeeInfo searchEmployeeInfo(String EmpFirstName) {
        openConnection();
        EmployeeInfo ei = null;
        try {
            String sql = "select* from employee_info where emp_firstname='" + EmpFirstName + "'";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                ei = new EmployeeInfo(rs.getString("emp_firstname"), rs.getString("emp_lastname"), rs.getString("phn_num"), rs.getString("address"));
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ei;
    }
        public void updateEmployee(EmployeeInfo ei){
            String sql="Update employee_info set phn_num='"+ei.getPhnNum()+"',address='"+ei.getAddress()+"' where emp_firstname='"+ei.getEmpFirstName()+"'";
            queryUpdateExecutor(sql);
             JOptionPane.showMessageDialog(rootPane, "Successfully Updated Employee Information");
        }
        
        /////////////Payment//////////
        public void insertPayment(EmpPaymentInfo epi){
            String sql="insert into emp_payment (emp_id,salary,pay_date,payment_month,status) values("+epi.getEmpId()+","+epi.getSalary()+",'"+epi.getDate()+"','"+epi.getPaymentMonth()+"','"+epi.getStatus()+"')";
            queryUpdateExecutor(sql);
            JOptionPane.showMessageDialog(rootPane, "Payment Insert Successfully");
    }
        
        public void updatePayment(EmpPaymentInfo ei) throws SQLException{
            String sql="Update emp_payment set salary= "+ei.getSalary()+",pay_date='"+ei.getDate()+"',payment_month='"+ei.getPaymentMonth()+"',status='"+ei.getStatus()+"' where emp_id="+ei.getEmpId();
            queryUpdateExecutor(sql);
            JOptionPane.showMessageDialog(rootPane, "Payment Record Updated Successfully");
        
    }    
        public void updateStock(stockInfo si) throws SQLException{
            String sql="Update stock set unit_price= "+si.getUnitPrice()+",sell_price="+si.getSellPrice()+",quantity="+si.getQuantity()+",in_date='"+si.getDate()+"' where product_id="+si.getProductId();
            queryUpdateExecutor(sql);
            JOptionPane.showMessageDialog(rootPane, "Stock Updated Successfully");
        
    } 
        public void deleteProduct(ProductInfo pi){
            
            String sql="Delete form product_info where product_name='"+pi.getProductName()+"'";
            queryUpdateExecutor(sql);
            JOptionPane.showMessageDialog(rootPane, "Product Information Deleted Successfully");
    }
        
        
}
