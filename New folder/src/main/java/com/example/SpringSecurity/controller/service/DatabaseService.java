package com.example.SpringSecurity.controller.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
	@Autowired
	private DataSource dataSource;

	public boolean performDatabaseOperation() {

		try (Connection connection = dataSource.getConnection()) {
			String sql = "SELECT * FROM user";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {

						int id = resultSet.getInt("id");
						String name = resultSet.getString("name");

						System.out.println("ID: " + id + ", Name: " + name);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return true;
	}
}
