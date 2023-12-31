package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {


    @Modifying//indique que cette requête modifie les données de la base de données
    @Query("UPDATE Stock s SET s.Stock = s.Stock + :quantity WHERE s.product.idProduct = :productId")
    void UpdateStock(@Param("productId")Long idProduct, @Param("quantity") int quantite);

}