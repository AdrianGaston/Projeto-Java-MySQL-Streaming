package br.com.senac.cenaflixjpa.persistencia;

import br.com.senac.cenaflixjpa.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioBD {
    //Método para validar o tipo de usuário
    public static Usuario validarUsuario(Usuario usuario){
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;
        
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflixjpa", "root", "1234");
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            
            System.out.println("Login: " + usuario.getLogin());
            System.out.println("Senha: " + usuario.getSenha());

            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));   
            }
            
        }catch(SQLException ex){
            System.out.println("Sintaxe de comando inválida!" + ex.getMessage());
        }
        return usuarioEncontrado;
    }
}
