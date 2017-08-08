package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.ProductDAO;
import ua.home.entity.Product;
import ua.home.service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SexService sexService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ColorService colorService;

    @Autowired
    BrandModelService brandModelService;

    public void add(Product product) {
        productDAO.save(product);
    }

    public void add(Product product, Integer brand, Integer category, Integer sex, Integer size, Integer color,Integer brandModel){
        product.setBrand(brandService.findOne(brand));
        product.setCategory(categoryService.findOne(category));
        product.setSex(sexService.findOne(sex));
        product.setSize(sizeService.findOne(size));
        product.setColor(colorService.findOne(color));
        product.setBrandModel(brandModelService.findOne(brandModel));
        productDAO.save(product);
    }

    public Set<Product> searchProducts(String string) throws NullPointerException{
            if (string.isEmpty()){
                throw new NullPointerException();
            }
            List<String> words = new ArrayList<String>();
            String[] array = string.split("");
            String word = "";
            for (String s: array){
                word+=s;
                if(s.equals(" ")){
                    words.add(word);
                    word = "";
                }
            }
            words.add(word);
            List<Product> products = findAll();
            Set<Product> findProducts = new HashSet<Product>();
            for (Product p: products) {
                for (String s: words){
                    if (p.toString().toLowerCase().contains(s.toLowerCase())){
                        findProducts.add(p);
                    }
                }
            }
        return findProducts;
    }

    public void edit(Product product) {
        productDAO.save(product);
    }

    public void delete(int id) {
        productDAO.delete(id);
    }

    public Product findOne(int id) {
        return productDAO.findOne(id);
    }

    public Product findByModel(String model) {
        return productDAO.findByModel(model);
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public List<Product> findBySex(String sex) {
        return productDAO.findBySex(sex);
    }

    public List<Product> findByCategory(String sex, String category) {
        return productDAO.findByCategory(sex,category);
    }

    public List<Product> findSaleSneaker() {
        return productDAO.findSaleSneaker();
    }

    public List<Product> findByBrand(String brand) {
        return productDAO.findByBrand(brand);
    }


}
