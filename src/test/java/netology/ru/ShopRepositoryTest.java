package netology.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test
    public void notFoundException() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Вода", 2);
        Product product2 = new Product(22, "Хлеб", 2);
        Product product3 = new Product(33, "Яйца", 2);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(1);
        });
    }

    @Test
    public void removeId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Вода", 2);
        Product product2 = new Product(22, "Хлеб", 2);
        Product product3 = new Product(33, "Яйца", 2);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(11);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}

