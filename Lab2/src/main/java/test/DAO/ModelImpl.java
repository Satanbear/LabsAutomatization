package test.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import test.model.Foodstuffs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Component
public class ModelImpl implements ModelImplI {

    @Autowired
    DAOFoodStuffs foodStuffs;

    public ModelImpl(DAOFoodStuffs foodStuff) {
        this.foodStuffs = foodStuff;
    }

    public ModelImpl() {
    }

    @Override
    public List<Foodstuffs> getAllProduct() throws SQLException, IOException {
        return foodStuffs.getAll();
    }

    @Override
    public void addProduct(Foodstuffs foodstuffs) throws IOException, SQLException {
        foodStuffs.insert(foodstuffs);
    }

    @DeleteMapping("delete-footballClub/{idClub}")
    public void deleteProduct(@PathVariable("id") int id) throws IOException, SQLException {
        foodStuffs.delete(id);
    }
}
