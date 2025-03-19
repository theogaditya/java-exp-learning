package com.example.demo.dao;

import com.example.demo.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;  
import java.sql.Statement;   
import com.example.demo.model.Job;

@Repository

public class JobDAO {
    
    private final DataSource dataSource;

    @Autowired
    public JobDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Job> getJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setCompany(rs.getString("company"));
                job.setDescription(rs.getString("description"));
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public boolean addJob(Job job) {
        String sql = "INSERT INTO jobs (title, company, description) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getCompany());
            pstmt.setString(3, job.getDescription());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

