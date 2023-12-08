package tobetojava1b.rent_a_car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tobetojava1b.rent_a_car.entities.Model;
import tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelListResponse;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    List<Model> findByNameIsNot(String name);
    List<Model> findByNameStartingWith(String name);

    @Query("SELECT new tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelListResponse(m.name,m.modelYear," +
            "new tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse(b.name)) " +
            "FROM Model m INNER JOIN m.brand b Where m.name LIKE %:name%")
    List<GetModelListResponse> search(String name);

    @Query("SELECT new tobetojava1b.rent_a_car.services.dtos.responses.model.GetModelListResponse(m.name,m.modelYear," +
            "new tobetojava1b.rent_a_car.services.dtos.responses.brand.GetBrandListResponse(b.name)) " +
            "FROM Model m INNER JOIN m.brand b Where m.modelYear = :year ")
    List<GetModelListResponse> findModelYearEquals(String year);

    boolean existsByName(String name);


}
