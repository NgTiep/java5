package fpoly.sd17218.assigment.repository;

import fpoly.sd17218.assigment.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {
}
