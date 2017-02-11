package com.java.jdbc;

import java.sql.*;

/**
 * Created by Oleg on 11.02.2017.
 */
public class AccessJdbc {
    private String result="Результат:";
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Connection connection;

    public AccessJdbc(){
        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/flats","postgres","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String selectAll() throws SQLException {
        try {
             preparedStatement=connection.prepareStatement("SELECT* FROM DATA ");
             resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                result=result+"\n"+resultSet.getString("район").trim()+" "+resultSet.getString("площадь").trim()+" "+resultSet.getString("кол.комнат").trim()+" "+resultSet.getString("цена").trim()+" "+resultSet.getString("адрес").trim();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
                preparedStatement.close();
                resultSet.close();
        }
        return result;
    }
    public String selectFlatsByPrice(Integer price) throws SQLException  {
        try {
            preparedStatement=connection.prepareStatement("SELECT* FROM DATA WHERE (цена<=(?))");
            preparedStatement.setInt(1,price);
            resultSet=preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                result="Не найдено";
            }
            else {
                while (resultSet.next()){
                    result= result+"\n"+resultSet.getString("район").trim()+" "+resultSet.getString("площадь").trim()+" "+resultSet.getString("кол.комнат").trim()+" "+resultSet.getString("цена").trim()+" "+resultSet.getString("адрес").trim();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
return result;
    }
    public String selectFlatsByArea(int area) throws SQLException {
        try {
            preparedStatement=connection.prepareStatement("SELECT *FROM DATA WHERE (площадь<=(?))");
            preparedStatement.setInt(1,area);
            resultSet=preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                result="Не найдено";
            }
            else {
                while (resultSet.next()){
                    result= result+"\n"+resultSet.getString("район").trim()+" "+resultSet.getString("площадь").trim()+" "+resultSet.getString("кол.комнат").trim()+" "+resultSet.getString("цена").trim()+" "+resultSet.getString("адрес").trim();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            resultSet.close();
            preparedStatement.close();
        }
        return result;
    }
}
