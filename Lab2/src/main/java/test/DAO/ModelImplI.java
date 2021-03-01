package test.DAO;

import test.model.Foodstuffs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ModelImplI {

    List<Foodstuffs> getAllProduct() throws SQLException, IOException;
    void addProduct(Foodstuffs foodstuffs) throws IOException, SQLException;
}
