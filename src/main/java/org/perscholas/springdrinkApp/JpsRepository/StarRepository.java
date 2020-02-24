/**
 * 
 */
package org.perscholas.springdrinkApp.JpsRepository;

import java.util.List;

import org.perscholas.springdrinkApp.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kevinbusch
 *
 */
public interface StarRepository extends JpaRepository<Star, Long>{
	List<Star> findByalcoholId(Long id);
	List<Star> findByuserId(Long id);

}
