package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.Brand;
import tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    // Derived Query Methods

    List<Brand> findAllByNameLikeOrIdEquals(String name,int id);
    List<Brand> findByNameEndingWith(String name);


    // JPA + SQL => JPQL
    // JPQL => SQL'dekinin tersine tablo ismi değil entity ismi kullanılır.
    @Query("SELECT b FROM Brand b Where b.name LIKE %:name%")
    List<Brand> search(String name);

    @Query(value = "Select * from brands Where name LIKE %:name%", nativeQuery = true)
    List<Brand> search2(String name);


    // b=> Brand
    // expected => GetBrandListResponse
    @Query("SELECT new tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse(b.name) " +
            "FROM Brand b Where b.name LIKE %:name%")
    List<GetBrandListResponse> search3(String name);

}
