package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produit;

public class ProduitDao {
	 private static String jdbcURL = "jdbc:mysql://localhost:3306/stock?useSSL=false";
	    private static String jdbcUsername = "root";
	    private static String jdbcPassword = "root";

	    private static final String INSERT_PRODUIT_SQL = "INSERT INTO produit" + "  (name, description, quantity,price,category) VALUES " +
	        " (?,?,?,?,?);";

	    private static final String SELECT_PRODUIT_BY_ID = "select id,name, description, quantity,price,category from produit where id =?";
	    private static final String SELECT_ALL_PRODUIT = "select * from produit";
	    private static final String DELETE_PRODUIT_SQL = "delete from produit where id = ?;";
	    private static final String UPDATE_PRODUIT_SQL = "update produit set name = ?,description= ?, quantity =? , price=?, category=?  where id = ?;";

	    public ProduitDao() {}

	    protected static Connection getConnection() throws SQLException {
	        Connection connection = null;
	        try {
	          //  Class.forName("com.mysql.jdbc.Driver");
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            try {
					connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.print("not work errour");
				}
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public static void insertProduit(Produit produit) throws SQLException {
	        System.out.println(INSERT_PRODUIT_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUIT_SQL)) {
	            preparedStatement.setString(1, produit.getName());
	            preparedStatement.setString(2, produit.getDescription());
	            preparedStatement.setInt(3, produit.getQuantity());
	            preparedStatement.setInt(4, produit.getPrice());
	            preparedStatement.setString(5, produit.getCategory());


	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    public static Produit selectProduit(int id) {
	        Produit produit = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUIT_BY_ID);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String description = rs.getString("description");
	                int quantity = rs.getInt("quantity");
	                int price = rs.getInt("price");
	                String category = rs.getString("category");

	                produit = new Produit(id, name, description, quantity,price,category);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return produit;
	    }

	    public static List < Produit > selectAllProduits() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Produit > produits = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUIT)) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String description = rs.getString("description");
	                int quantity = rs.getInt("quantity");
	                int price = rs.getInt("price");
	                String category = rs.getString("category");
	                produits.add(new Produit(id, name, description, quantity,price,category));

	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        System.out.print("list of in method ");

	        return produits;
	    }

	    public boolean deleteProduit(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUIT_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    public boolean updateProduit(Produit produit) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUIT_SQL);) {
	        	 statement.setString(1, produit.getName());
	        	 statement.setString(2, produit.getDescription());
	        	 statement.setInt(3, produit.getQuantity());
	        	 statement.setInt(4, produit.getPrice());
	        	 statement.setString(5, produit.getCategory());
	            statement.setInt(6, produit.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }

	    private static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }

		
	    }