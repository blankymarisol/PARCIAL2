package umg.demostracion.DataBase.Service;

import umg.demostracion.DataBase.Dao.ModeloTelefonicoDAO;
import umg.demostracion.DataBase.Model.ModeloTelefonico;

import java.sql.SQLException;
import java.util.List;

public class ModeloTelefonicoService {
    private ModeloTelefonicoDAO modeloTelefonicoDAO = new ModeloTelefonicoDAO();

    public void agregarModeloTelefonico(ModeloTelefonico modeloTelefonico) {
        try {
            modeloTelefonicoDAO.insertar(modeloTelefonico);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean actualizarModeloTelefonico(ModeloTelefonico modeloTelefonico) {
        try {
            modeloTelefonicoDAO.actualizar(modeloTelefonico);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void eliminarModeloTelefonico(int id) {
        try {
            modeloTelefonicoDAO.eliminar(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ModeloTelefonico obtenerModeloTelefonicoPorId(int id) {
        try {
            return modeloTelefonicoDAO.obtenerPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ModeloTelefonico> obtenerTodosLosModelosTelefonicos() {
        try {
            return modeloTelefonicoDAO.obtenerTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
