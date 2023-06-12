package p_04721062;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatoDAO {
    public void insert(CandidatoTO inscricoes) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova", "root", "root");

            String banco = "INSERT INTO inscricoes (nome, cpf, telefone, email, endereco, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(banco);
            statement.setString(1, inscricoes.getNome());
            statement.setString(2, inscricoes.getCpf());
            statement.setString(3, inscricoes.getTelefone());
            statement.setString(4, inscricoes.getEmail());
            statement.setString(5, inscricoes.getEndereco());
            statement.setString(6, inscricoes.getCidade());
            statement.setString(7, inscricoes.getEstado());
            statement.setString(8, inscricoes.getCep());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
