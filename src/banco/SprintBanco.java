package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Sprint;

public class SprintBanco {
    private DBConnection connection;

    public SprintBanco() {
        this.connection = new DBConnection();
    }

    public void incluir(Sprint sprint) {
        try {
            String sql = "INSERT INTO Tb_Sprint (nome_sprint, data_inicio, data_fim) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, sprint.getNomeSprint());
            statement.setObject(2, sprint.getDataInicio());
            statement.setObject(3, sprint.getDataFim());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public Sprint consultar(int id) {
        try {
            String sql = "SELECT * FROM Tb_Sprint WHERE id = ?";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                Sprint sprint = new Sprint();
                sprint.setId(rs.getInt("id"));
                sprint.setNomeSprint(rs.getString("nome_sprint"));
                sprint.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
                sprint.setDataFim(rs.getObject("data_fim", LocalDate.class));
                return sprint;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Sprint> consultarProjeto(int idProjeto) {
        List<Sprint> sprints = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Tb_Sprint WHERE projeto_id = ?";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idProjeto);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Sprint sprint = new Sprint();
                sprint.setId(rs.getInt("id"));
                sprint.setNomeSprint(rs.getString("nome_sprint"));
                sprint.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
                sprint.setDataFim(rs.getObject("data_fim", LocalDate.class));
                sprints.add(sprint);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sprints;
    }

    public List<Sprint> listarTodos() {
        List<Sprint> sprints = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Tb_Sprint";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs != null && rs.next()) {
                Sprint sprint = new Sprint();
                sprint.setId(rs.getInt("id"));
                sprint.setNomeSprint(rs.getString("nome_sprint"));
                sprint.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
                sprint.setDataFim(rs.getObject("data_fim", LocalDate.class));
                sprints.add(sprint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sprints;
    }
    
    public void deletar(int id) {
        try {
            String sql = "DELETE FROM Tb_Sprint WHERE id = ?";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
