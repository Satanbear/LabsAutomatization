package test.controller;

import test.DAO.DAOFoodStuffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.DAO.ModelImpl;
import test.model.Foodstuffs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class Controller{

    @Autowired
    public ModelImpl model;

    @GetMapping(value = "/productlist", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Foodstuffs> getAllProducts() throws IOException, SQLException {
        return model.getAllProduct();
    }

    @PostMapping(path = "/addProduct")
    public void addFootballLeague(@RequestBody Foodstuffs foodstuffs) throws IOException, SQLException {
        model.addProduct(foodstuffs);
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteFootballClub(@PathVariable("id") int id) throws IOException, SQLException {
        model.deleteProduct(id);
    }
}
