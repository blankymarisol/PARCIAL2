package umg.demostracion.DataBase.Dao;

import umg.demostracion.DataBase.Model.ModeloTelefonico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloTelefonicoDAO {
    private final String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private final String user = "tu_usuario";
    private final String password = "tu_contraseña";

    public void insertar(ModeloTelefonico modeloTelefonico) throws SQLException {
        String query = "INSERT INTO modelos_telefonicos (marca, modelo, sistema_operativo) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, modeloTelefonico.getMarca());
            ps.setString(2, modeloTelefonico.getModelo());
            ps.setString(3, modeloTelefonico.getSistemaOperativo());

            ps.executeUpdate();
        }
    }

    public void actualizar(ModeloTelefonico modeloTelefonico) throws SQLException {
        String query = "UPDATE modelos_telefonicos SET marca = ?, modelo = ?, sistema_operativo = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, modeloTelefonico.getMarca());
            ps.setString(2, modeloTelefonico.getModelo());
            ps.setString(3, modeloTelefonico.getSistemaOperativo());
            ps.setInt(4, modeloTelefonico.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM modelos_telefonicos WHERE id = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public ModeloTelefonico obtenerPorId(int id) throws SQLException {
        String query = "SELECT * FROM modelos_telefonicos WHERE id = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new ModeloTelefonico(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo")
                );
            }
        }
        return null;
    }

    public List<ModeloTelefonico> obtenerTodos() throws SQLException {
        List<ModeloTelefonico> lista = new ArrayList<>();
        String query = "SELECT * FROM modelos_telefonicos";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                ModeloTelefonico modeloTelefonico = new ModeloTelefonico(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo")
                );
                lista.add(modeloTelefonico);
            }
        }
        return lista;
    }
}