
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DatabaseConnection;
import Interfaces.UserRepository;
import Modelo.Servicio;
import Modelo.Usuario;



public class UsuarioControlador implements UserRepository {
    private final Connection connection;

    public UsuarioControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario ");
            ResultSet resultSet = statement.executeQuery();
       
            
            while (resultSet.next()) {
            	Usuario user = new Usuario(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getInt("rol"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Usuario getUserById(int id) {
        Usuario user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new Usuario(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),resultSet.getInt("rol") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
	@Override
    public void addUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario (name, email, rol) VALUES (?, ?, ?)");
            statement.setString(1, usuario.getName());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, 1);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
    public boolean updateUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET name = ?, email = ?, rol = ? WHERE id = ?");
            statement.setString(1, usuario.getName());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, usuario.getRol());
            statement.setInt(4, usuario.getId());
            
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente");
                return true;
               
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		
    }

    @Override
    public void deleteUser(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?");
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

} 

